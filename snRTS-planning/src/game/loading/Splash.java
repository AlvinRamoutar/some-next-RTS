package game.loading;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import game.GV;
import game.loading.DTT;

public class Splash extends BasicGameState {
	
	//TEMPORARY
	Image testgif;
		
	//Constructor
	public Splash(int state) {
		
	}
	
	//Initialize elements. Runs ONCE before any rendering.
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {

	}
	
	//Draw objects to state/window.
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		
		//TEMPORARY
		Image bg = new Image("res/sample_imgs/bg1.jpg");
		g.drawImage(bg, 0, 0);
		g.drawString("This is the splash state.", 10, 30);
	}
	
	//Interact with drawn objects through updates.
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {

		if (DTT.main(3)) {
			sbg.enterState(GV.LOADING, new FadeOutTransition(), new FadeInTransition());	
		}
	}
	
	//ID of the current state. Change '?' accordingly.
	public int getID() {
		return 0;
	}
	
}

