package game.sp_play;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

import game.GV;

public class SPPlay extends BasicGameState {
	
	private Image guiBacking;
	private Image promptTab;
	private Image x, checkmark;
	private int promptTabXPos = -225;
	private int promptTransitionCount = 0;
	private boolean isPromptEntering = false;
	private boolean isPromptLeaving = false;
	
	
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
		
		// Simple yes/no acknowledgement window.
		g.drawImage(promptTab, promptTabXPos,276);
		if(isPromptEntering == true && isPromptLeaving == false) {
			g.drawImage(checkmark, 192, 280);
			g.drawImage(x, 192, 310);
			GV.FONTLIGHT_EXO.drawString(5, 280, "This is a test prompt.");
			GV.FONTLIGHT_EXO.drawString(5, 296, "Do you agree?");
		}
	}
	
	//Interact with drawn objects through updates.
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		promptTransition(delta);
	}
	
	//ID of the current state. Change '?' accordingly.
	public int getID() {
		return 4;
	}
	
	public void promptTransition(int delta) {
		promptTransitionCount += delta;
		if(promptTransitionCount > 2 && isPromptEntering == false) {
			promptTabXPos += 1;
			promptTransitionCount = 0;
			if(promptTabXPos == 0) {
				isPromptEntering = true;
			}
		}
		if(promptTransitionCount > 2 && isPromptLeaving == true) {
			promptTabXPos -= 1;
			promptTransitionCount = 0;
			if(promptTabXPos == -225) {
				isPromptLeaving = false;
			}
		}
	}
	
}
