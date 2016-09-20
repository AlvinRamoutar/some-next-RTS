package game.menu;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;

import game.GV;

public class MainMenu extends BasicGameState {
		
	Image bg;
		
	Font COMFORTAA_BOLD = null;
	
	//Constructor
	public MainMenu(int state) {
		
	}
	
	//Initialize elements. Runs ONCE before any rendering.
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		bg = new Image("res/sample_imgs/nullbg.jpg");
		
		//Initializing menu font.
		try {
			COMFORTAA_BOLD = Font.createFont(Font.TRUETYPE_FONT, new File("res/fonts/Comfortaa/Comfortaa-Bold.ttf"));
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
		}
		COMFORTAA_BOLD = COMFORTAA_BOLD.deriveFont(14.0f);
		
	}
	
	//Draw objects to state/window.
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.drawImage(bg, 0, 0);
			
		TrueTypeFont cbF = new TrueTypeFont(COMFORTAA_BOLD, true);
		cbF.drawString(32, 32, "Your words here", Color.gray);
		
	}
	
	//Interact with drawn objects through updates.
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
	
	}
	
	//ID of the current state. Change '?' accordingly.
	public int getID() {
		return 2;
	}
	
}
