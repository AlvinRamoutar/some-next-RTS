package game.menu;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

import game.GV;

public class MainMenu extends BasicGameState {
		
	Image bg0;
	Image bg1;
	int bgPulseCount = 0;
	int deltaCount = 0;
	boolean doPulse = false;
	
	//Constructor
	public MainMenu(int state) {
		
	}
	
	//Initialize elements. Runs ONCE before any rendering.
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {

		bg1 = new Image("res/images/bg/title_11.jpg");
		bg0 = new Image("res/images/bg/title_0.jpg");
		
		//AngelCodeFont Initializing
		GV.FONTBOLD_COMFORTAA = new AngelCodeFont("res/fonts/Comfortaa/Comfortaa-Bold.fnt","res/fonts/Comfortaa/Comfortaa-Bold.png");
		GV.FONTLIGHT_COMFORTAA = new AngelCodeFont("res/fonts/Comfortaa/Comfortaa-Light.fnt","res/fonts/Comfortaa/Comfortaa-Light.png");

	}
	
	//Draw objects to state/window.
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.drawImage(bg0,0,0);
		g.drawImage(bg1,0,0);
		
		GV.FONTBOLD_COMFORTAA.drawString(30, 85, "SOME NEXT RTS", new org.newdawn.slick.Color(255, 255, 255, 0.60f));
		GV.FONTLIGHT_COMFORTAA.drawString(5, 5, GV.VERSION, new org.newdawn.slick.Color(255, 255, 255, 0.5f));
		GV.FONTLIGHT_COMFORTAA.drawString(454, 318, "SINGLE PLAYER [WIP]", new org.newdawn.slick.Color(255, 255, 255, 0.5f));
		GV.FONTLIGHT_COMFORTAA.drawString(518, 348, "MULTIPLAYER", new org.newdawn.slick.Color(255, 255, 255, 0.5f));
		GV.FONTLIGHT_COMFORTAA.drawString(556, 378, "OPTIONS", new org.newdawn.slick.Color(255, 255, 255, 0.5f));
		GV.FONTLIGHT_COMFORTAA.drawString(590, 408, "HELP", new org.newdawn.slick.Color(255, 255, 255, 0.5f));
		GV.FONTLIGHT_COMFORTAA.drawString(592, 438, "QUIT", new org.newdawn.slick.Color(255, 255, 255, 0.5f));

		
		// Adjusts the opacity of background images to create a pulsating effect.
		if (doPulse == false) {
			if (bg1.getAlpha() > 0.00) {
				bg1.setAlpha(bg1.getAlpha() - 0.001f);
			}
		} else  {
			if (bg1.getAlpha() < 1) {
				bg1.setAlpha(bg1.getAlpha() + 0.001f);
			}
		} 
	}
	
	//Interact with drawn objects through updates.
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		bgPulseCount+=delta;
		if (bgPulseCount > 500) {
			doPulse = !doPulse;
			bgPulseCount = 0;
		}
	}
	
	//ID of the current state. Change '?' accordingly.
	public int getID() {
		return 2;
	}
	
}
