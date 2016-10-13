package game.sp_play;

import org.newdawn.slick.*;
import org.newdawn.slick.gui.MouseOverArea;
import org.newdawn.slick.state.*;
import org.newdawn.slick.tiled.TiledMap;
import org.newdawn.slick.tiled.Layer;

import game.GV;

public class SPPlay extends BasicGameState {
	
	private Image guiBacking;
	protected Image promptTab;
	protected Image x;
	protected Image checkmark;
	private int promptTabXPos = -225;
	private int promptTransitionCount = 0;
	private int promptElementXPos = -225;
	protected MouseOverArea[] promptOptions = new MouseOverArea[2];	
	private boolean isPromptNeeded = true;
	private boolean isPromptActive = false;
	private boolean isPromptReadyForInteraction = false;
	
	private TiledMap map;
	private MouseOverArea[] mapScroll = new MouseOverArea[4];
	private int mapScrollThickness = 16;
	
	//Constructor
	public SPPlay(int state) {
		
	}
	
	//Initialize elements. Runs ONCE before any rendering.
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		guiBacking = new Image("res/images/play/guiExperiment.jpg");
		promptTab = new Image("res/images/play/prompt/promptTab.png");
		x = new Image("res/images/play/prompt/x.png");
		checkmark = new Image("res/images/play/prompt/checkmark.png");
		
		GV.FONTLIGHT_EXO = new AngelCodeFont("res/fonts/Exo/Exo-Light.fnt", "res/fonts/Exo/Exo-Light.png");
		
		// Loading default map, which is mapDraft.
		//map = new TiledMap("res/map/isometric_grass_and_water.tmx", "res/map");
		// Map fills screen @ 10 tiles by 15 (MIN).
		
		try {
			map = new TiledMap("res/map/mapSample.tmx", "res/map/");
		} catch(SlickException e) {
			e.printStackTrace();
			game.menu.console.Command.print("Failed to load map!", 3);
		}
		
		//Setting up map edges for scrolling.
		mapScroll[0] = new MouseOverArea(gc, null, 0, 0, GV.SCREENWIDTH, mapScrollThickness);
		mapScroll[1] = new MouseOverArea(gc, null, GV.SCREENWIDTH - mapScrollThickness, 0, mapScrollThickness, GV.SCREENHEIGHT);
		mapScroll[2] = new MouseOverArea(gc, null, 0, GV.SCREENHEIGHT - mapScrollThickness, GV.SCREENWIDTH, mapScrollThickness);
		mapScroll[3] = new MouseOverArea(gc, null, 0, 0, mapScrollThickness, GV.SCREENHEIGHT);
		
		
	}
	
	//Draw objects to state/window.
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		
		//g.drawImage(guiBacking,0,0);
		
		map.render((GV.SCREENWIDTH/2)-32,0);
		//map.renderIsometricMap(0,0,64,16,64,32,null, false);
		
		//Draws the, well, notification prompt.
		drawPrompt(g, gc, "line1", "line2", "line3", 1);

	}
	
	//Interact with drawn objects through updates.
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		promptTransition(delta);
		
		if(isPromptReadyForInteraction) {
			if(promptOptions[0].isMouseOver() && gc.getInput().isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
				isPromptNeeded = false;
			}
		}
		
		//Map scroller 
		
		for(int a=0; a < mapScroll.length; a++) {
			if(mapScroll[a].isMouseOver()) {
				System.out.println("Mousing over: " + a);
			}
		}
		
	}
	
	//ID of the current state. Change '?' accordingly.
	public int getID() {
		return 4;
	}
	
	public void promptTransition(int delta) {
		promptTransitionCount += delta;
		
		//Transition tab into existence.
		if(promptTransitionCount > 2 && isPromptActive == false && isPromptNeeded) {

			if(promptElementXPos == 0 || promptElementXPos > 0) {
				isPromptReadyForInteraction = true;
			} else {
				promptElementXPos += 1;
				promptTransitionCount = 0;
			}
			
			if(promptTabXPos == 0) {
				isPromptActive = true;
			} else {
				promptTabXPos += 1;
				promptTransitionCount = 0;
			}
		}
		
		//Transition tab out of existence.
		if(promptTransitionCount > 2 && isPromptActive == true && isPromptNeeded == false) {
			if(promptTabXPos == -225) {
				isPromptReadyForInteraction = false;
				isPromptActive = false;
			} else {
				promptTabXPos -= 1;
				promptTransitionCount = 0;
			}
			
			if(promptElementXPos == -225 || promptElementXPos < -225) {
				isPromptReadyForInteraction = false;
			} else {
				promptElementXPos -= 1;
				promptTransitionCount = 0;
			}
		}
	}
	
	public void drawPrompt(Graphics g, GameContainer gc, String pTextL1, String pTextL2, String pTextL3, int promptType) {
		switch(promptType) {
			case 1:
				g.drawImage(promptTab, promptTabXPos,276);
				g.drawImage(checkmark, 192 + promptElementXPos, 280);
				promptOptions[0] = new MouseOverArea(gc, checkmark, 192 + promptElementXPos, 280, 24, 24);
				GV.FONTLIGHT_EXO.drawString(5 + promptElementXPos, 280, pTextL1);
				GV.FONTLIGHT_EXO.drawString(5 + promptElementXPos, 296, pTextL2);
				GV.FONTLIGHT_EXO.drawString(5 + promptElementXPos, 312, pTextL3);
				break;
			case 2:
				g.drawImage(promptTab, promptTabXPos,276);
				g.drawImage(checkmark, 192 + promptElementXPos, 280);
				g.drawImage(x, 192 + promptElementXPos, 310);
				promptOptions[0] = new MouseOverArea(gc, checkmark, 192 + promptElementXPos, 280, 24, 24);
				promptOptions[1] = new MouseOverArea(gc, checkmark, 192 + promptElementXPos, 310, 24, 24);
				GV.FONTLIGHT_EXO.drawString(5 + promptElementXPos, 280, pTextL1);
				GV.FONTLIGHT_EXO.drawString(5 + promptElementXPos, 296, pTextL2);
				GV.FONTLIGHT_EXO.drawString(5 + promptElementXPos, 312, pTextL3);
				break;
		}

	}
	
}
