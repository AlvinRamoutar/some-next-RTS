package game;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Menu extends BasicGameState {
	
	public String mousePos = "----------";
	
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
		
		g.drawString(mousePos, 525, 10);
		
		g.drawRect(0, 430, 100, 50);
		g.drawString("State #2 - Play", 10, 400);
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		//Mouse tracking. Apparantly starts from bottom-left.
		int mouseXPos = Mouse.getX();
		int mouseYPos = Mouse.getY();
		mousePos = "X|" + mouseXPos + " Y|" + mouseYPos;
		Input input = gc.getInput();
		if ((mouseXPos > 0 && mouseXPos < 100) && (mouseYPos > 0 && mouseYPos < 50)) {
			if (input.isMouseButtonDown(0)) {
				sbg.enterState(1);
			}
		}
	}
	
	public int getID() {
		return 0;
	}
	
	
}
