package game.menu;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

import game.GV;

public class MainMenu extends BasicGameState {
		
	Image bg;
	
	//Constructor
	public MainMenu(int state) {
		
	}
	
	//Initialize elements. Runs ONCE before any rendering.
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		bg = new Image("res/sample_imgs/nullbg.jpg");
		Font font = new Font('Verdana', Font.BOLD, 32);
		TrueTypeFont ttf = new TrueTypeFont(font, true);
		/*
		org.newdawn.slick.font.effects.ColorEffect a = new org.newdawn.slick.font.effects.ColorEffect();
        a.setColor(Color.white);
        GV.UNIFONT_COMFORTAA.getEffects().add(Color.white);
        GV.UNIFONT_COMFORTAA.addAsciiGlyphs();
		*/
	}
	
	//Draw objects to state/window.
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.drawImage(bg, 0, 0);
        g.drawString("HERPADADERPADA", 20, 30);
	}
	
	//Interact with drawn objects through updates.
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
	
	}
	
	//ID of the current state. Change '?' accordingly.
	public int getID() {
		return 2;
	}
	
}
