package game;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class GenericState extends BasicGameState {
	
	//Constructor
	public GenericState(int state) {
		
	}
	
	//Initialize elements. Runs ONCE before any rendering.
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {

	}
	
	//Draw objects to state/window.
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		
	}
	
	//Interact with drawn objects through updates.
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
	
	}
	
	//ID of the current state. Change '?' accordingly.
	public int getID() {
		return ?;
	}
	
}
