package game.loading;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Loading extends BasicGameState{
		
	//Constructor
	public Loading(int state) {
		
	}
	
	//Initialize elements. Runs ONCE before any rendering.
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {

	}
	
	//Draw objects to state/window.
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		Image bg = new Image("res/sample_imgs/bg2.jpg");
		g.drawImage(bg, 0, 0);
		g.drawString("This is the loading state.", 10, 30);
	}
	
	//Interact with drawn objects through updates.
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
	
	}
	
	//ID of the current state. Change '?' accordingly.
	public int getID() {
		return 1;
	}
}
