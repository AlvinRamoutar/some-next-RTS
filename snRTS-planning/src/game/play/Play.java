package game.play;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Play extends BasicGameState {
	
	Image movIcon;
	int movIconX = 0;
	int movIconY = 400;
	
	public Play(int state) {
		
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		movIcon = new Image("res/energyBlip.png");
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		movIcon.draw(movIconX, movIconY, 0.1f);
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		Input input = gc.getInput();
		if(input.isKeyDown(Input.KEY_UP) && movIconY > 0) {
			movIconY -= 1;
		} 
		if (input.isKeyDown(Input.KEY_DOWN)) {
			movIconY += 1;
		} 
		if (input.isKeyDown(Input.KEY_RIGHT)) {
			movIconX += 1;
		}
		if (input.isKeyDown(Input.KEY_LEFT) && movIconX > 0) {
			movIconX -= 1;
		}
	}
	
	public int getID() {
		return 1;
	}
	
	
}
