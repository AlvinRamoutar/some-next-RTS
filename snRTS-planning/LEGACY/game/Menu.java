package game;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
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
		
		//ONLY this text will open the webpage. Refer to mouse tracking code below.
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
		
		//Launches song in youtube.
		if ((mouseXPos > 45 && mouseXPos < 412) && (mouseYPos > 392 && mouseYPos < 432)) {
			if (input.isMouseButtonDown(0)) {
				try {
					URI wibw = new URI("https://www.youtube.com/watch?annotation_id=annotation_2000278929&feature=iv&src_vid=zrQyUvxMuKY&v=H1iGOgs4fLE");
					try {
						java.awt.Desktop.getDesktop().browse(wibw);
					} catch(IOException e) {
						e.printStackTrace();
					}
				} catch(URISyntaxException e) {
					e.printStackTrace();
				}
			}
		}
		

	}
	
	public int getID() {
		return 0;
	}
	
	
}
