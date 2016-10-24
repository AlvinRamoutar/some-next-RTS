package game.sp_play;

import org.newdawn.slick.*;
import org.newdawn.slick.gui.MouseOverArea;
import org.newdawn.slick.state.*;
import org.newdawn.slick.tiled.TiledMap;

import game.GV;

public class SPPlay extends BasicGameState {
	
	private Image mapBackground;
	protected Image promptTab;
	protected Image x;
	protected Image checkmark;
	private int promptTabXPos = -225;
	private int promptTransitionCount = 0;
	private int promptElementXPos = -225;
	private MouseOverArea[] promptOptions = new MouseOverArea[2];	
	private boolean isPromptNeeded = true;
	private boolean isPromptActive = false;
	private boolean isPromptReadyForInteraction = false;
	
	private TiledMap map;
	public static MouseOverArea[] mapScroll = new MouseOverArea[4];
	
	private static float mapCamX = 0;
	private static float mapCamY = 0;
	private float mapScrollSpeed = 1;
	private boolean[] mapScrollMouseoverState = new boolean[4];
	private float moveSpeed;

	private Animation animation;
	private int start = 5000;
	
	//Constructor
	public SPPlay(int state) {

	}
	
	//Initialize elements. Runs ONCE before any rendering.
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		mapBackground = new Image("res/images/play/mapBackground.png");
		promptTab = new Image("res/images/play/prompt/promptTab.png");
		x = new Image("res/images/play/prompt/x.png");
		checkmark = new Image("res/images/play/prompt/checkmark.png");
		
		GV.FONTLIGHT_EXO = new AngelCodeFont("res/fonts/Exo/Exo-Light.fnt", "res/fonts/Exo/Exo-Light.png");
		
		//Initializing the Map.
		try {
			map = new TiledMap("res/map/mapSample.tmx", "res/map/");
			game.menu.console.Command.print("Map loaded successfully!", 1);
		} catch(SlickException e) {
			e.printStackTrace();
			game.menu.console.Command.print("Failed to load map!", 3);
		}
		
		//Setting up map edges for scrolling.
		initMapScrollAreas(gc);
		
		//Setting up the Sample Hero animation.
		SpriteSheet sheet = new SpriteSheet("res/images/entities/hero/sampleHeroSS.png", 72, 72);
		animation = new Animation();
		
		int tX = 0;
	    int tY = 0;
    	for (int row=0;row<8;row++) {
    		tX = 0;
    		for(int col=0;col<5;col++){
    			tX++;
    			animation.addFrame(sheet.getSprite(tX,tY), 60);
    		}
    		tY++;
    	}
	}
	
	//Draw objects to state/window.
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		
		g.drawImage(mapBackground,0,0);
		
		g.translate(-mapCamX * mapScrollSpeed, -mapCamY * mapScrollSpeed);

		//map.render((int)-mapCamX,(int)-mapCamY);
		map.render((GV.SCREENWIDTH/2)-32,0);

		//Draws the, well, notification prompt.
		drawPrompt(g, gc, "line1", "line2", "line3", 1);
			
		//Draw the Sample Hero.
		animation.draw(100,100);

	}
	
	//Interact with drawn objects through updates.
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		promptTransition(delta);
		
		if(isPromptReadyForInteraction) {
			if(promptOptions[0].isMouseOver() && gc.getInput().isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
				isPromptNeeded = false;
			}
		}
		
		moveSpeed = delta * 0.4f * (1/mapScrollSpeed);
		  
		if(mapScrollMouseoverState[3]) {
			mapCamX -= moveSpeed;
		}
		if(mapScrollMouseoverState[0]) {
			mapCamY -= moveSpeed;
		}
		if(mapScrollMouseoverState[1]) {
			mapCamX += moveSpeed;
		}
		if(mapScrollMouseoverState[2]) {
			mapCamY += moveSpeed;
		}
		if(mapScrollMouseoverState[0] ||
				mapScrollMouseoverState[1] ||
				mapScrollMouseoverState[2] ||
				mapScrollMouseoverState[3]) {
			initMapScrollAreas(gc);
		}
		
		// Implements scrolling by mousing over the edges of the map, checks interface.
		if (GV.SCROLL_INTERFACE == false) {
			for(int a=0; a < mapScroll.length; a++) {
				if(mapScroll[a].isMouseOver()) {
					mapScrollMouseoverState[a] = true;
				} else {
					mapScrollMouseoverState[a] = false;
				}
			}
		}
		
		// Draw the Sample Hero
		if (start >= 0) {
			start -= delta;
		}
	}
	
	public void keyPressed(int key, char c) {
		
		// Checks if the current scroll interface is keyboard, or mouse.
		if (GV.SCROLL_INTERFACE) {
			if( key == Input.KEY_LEFT) {
				mapScrollMouseoverState[3] = true;
		    }
		    if( key == Input.KEY_UP ) {
		    	mapScrollMouseoverState[0] = true;
		    }
		    if( key == Input.KEY_RIGHT ) {
		        mapScrollMouseoverState[1] = true;
		    }
		    if( key == Input.KEY_DOWN ) {
		    	mapScrollMouseoverState[2] = true;
		    }
		}
		
	}
	
	public void keyReleased(int key, char c) {
		
		// Checks if the current scroll interface is keyboard, or mouse.
		if (GV.SCROLL_INTERFACE) {
			if( key == Input.KEY_LEFT) {
				mapScrollMouseoverState[3] = false;
		    }
		    if( key == Input.KEY_UP ) {
		    	mapScrollMouseoverState[0] = false;
		    }
		    if( key == Input.KEY_RIGHT ) {
		        mapScrollMouseoverState[1] = false;
		    }
		    if( key == Input.KEY_DOWN ) {
		    	mapScrollMouseoverState[2] = false;
		    }
		}
		
		if( key == Input.KEY_GRAVE ) {
			GV.OPTIONSVISIBLE = true;
			game.Options.main(null);
		}
	}
	
	public static void initMapScrollAreas(GameContainer gc) {
		mapScroll[0] = new MouseOverArea(gc, null, (int)mapCamX, (int)mapCamY, GV.SCREENWIDTH + (int)mapCamX, GV.MAPSCROLLBAR_THICKNESS + (int)mapCamY);
		mapScroll[1] = new MouseOverArea(gc, null, (int)mapCamX + GV.SCREENWIDTH - GV.MAPSCROLLBAR_THICKNESS, (int)mapCamY, (int)mapCamX + GV.MAPSCROLLBAR_THICKNESS, (int)mapCamY + GV.SCREENHEIGHT);
		mapScroll[2] = new MouseOverArea(gc, null, (int)mapCamX, (int)mapCamY + GV.SCREENHEIGHT - GV.MAPSCROLLBAR_THICKNESS, (int)mapCamX + GV.SCREENWIDTH, (int)mapCamY + GV.MAPSCROLLBAR_THICKNESS);
		mapScroll[3] = new MouseOverArea(gc, null, (int)mapCamX, (int)mapCamY, (int)mapCamX + GV.MAPSCROLLBAR_THICKNESS,(int)mapCamY + GV.SCREENHEIGHT);
	}
	
	//ID of the current state. Change '?' accordingly.
	public int getID() {
		return 4;
	}
	
	public void promptTransition(int delta) {
		promptTransitionCount += delta;
		
		//Transition tab into existence.
		if(promptTransitionCount > 2 && isPromptActive == false && isPromptNeeded) {

			if(promptElementXPos == 0 + mapCamX || promptElementXPos > 0 + mapCamX) {
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
			if(promptTabXPos == -225 + mapCamX) {
				isPromptReadyForInteraction = false;
				isPromptActive = false;
			} else {
				promptTabXPos -= 1;
				promptTransitionCount = 0;
			}
			
			if(promptElementXPos == -225 + mapCamX || promptElementXPos < -225 + mapCamX) {
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
				g.drawImage(promptTab, promptTabXPos + mapCamX ,276 + mapCamY);
				g.drawImage(checkmark, 192 + promptElementXPos + mapCamX, 280 + mapCamY);
				promptOptions[0] = new MouseOverArea(gc, checkmark, (192 + promptElementXPos + (int)mapCamX), 280 + (int)mapCamY, 24, 24);
				GV.FONTLIGHT_EXO.drawString(5 + promptElementXPos + mapCamX, 280 + mapCamY, pTextL1);
				GV.FONTLIGHT_EXO.drawString(5 + promptElementXPos + mapCamX, 296 + mapCamY, pTextL2);
				GV.FONTLIGHT_EXO.drawString(5 + promptElementXPos + mapCamX, 312 + mapCamY, pTextL3);
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
