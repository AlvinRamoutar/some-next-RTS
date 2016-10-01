package game.sp_play;

import org.newdawn.slick.*;
import org.newdawn.slick.gui.MouseOverArea;
import org.newdawn.slick.state.*;

import game.GV;

public class SPPlay extends BasicGameState {
	
	private Image guiBacking;
	private Image promptTab;
	private Image x, checkmark;
	private int promptTabXPos = -225;
	private int promptTransitionCount = 0;
	private int promptElementXPos = -225;
	
	private boolean isPromptNeeded = true;
	private boolean isPromptActive = false;
	private boolean isPromptReadyForInteraction = false;
	
	
	private MouseOverArea[] promptOptions = new MouseOverArea[2];
	
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
		
	}
	
	//Draw objects to state/window.
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.drawImage(guiBacking,0,0);
		
		//Draws the, well, notification prompt.
		drawPrompt(g, gc, "line1", "line2", "line3", 1);

	}
	
	//Interact with drawn objects through updates.
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		promptTransition(delta);
		
		//for(int a=0; a < promptOptions.length; a++) {
		if(isPromptReadyForInteraction) {
			if(promptOptions[0].isMouseOver() && gc.getInput().isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
				isPromptNeeded = false;
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
