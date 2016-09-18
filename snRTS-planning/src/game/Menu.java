package game;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Menu extends BasicGameState {
	
	public Menu(int state) {
		
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {

	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {

		Image background = new Image("res/img.jpg");
		g.drawImage(background, 0, 0);
		
		g.drawString("That place between asleep and awake,", 50, 50);
		g.drawString("where you can still remember dreams...", 70, 70);
		g.drawString("...that's where I'll always love you,", 200, 420);
		g.drawString("and thats where I'll be waiting.", 220, 440);

	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {

	}
	
	public int getID() {
		return 0;
	}
	
	
}
