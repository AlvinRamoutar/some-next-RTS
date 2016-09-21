package game.menu;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;

import game.GV;

public class MainMenu extends BasicGameState {
		
	Image bg0;
	Image bg1;
	int bgPulseCount = 0;
	int deltaCount = 0;
	boolean doPulse = false;
	
	Font COMFORTAA_BOLD = null;
	Font COMFORTAA_LIGHT = null;
	
	//Constructor
	public MainMenu(int state) {
		
	}
	
	//Initialize elements. Runs ONCE before any rendering.
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		//gc.setTargetFrameRate(5);
		bg1 = new Image("res/images/bg/title_1.jpg");
		bg0 = new Image("res/images/bg/title_0.jpg");
		
		//Initializing menu font.
		try {
			COMFORTAA_BOLD = Font.createFont(Font.TRUETYPE_FONT, new File("res/fonts/Comfortaa/Comfortaa-Bold.ttf"));
			COMFORTAA_LIGHT = Font.createFont(Font.TRUETYPE_FONT, new File("res/fonts/Comfortaa/Comfortaa-Light.ttf"));
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
		}
		//COMFORTAA_BOLD = COMFORTAA_BOLD.deriveFont(14.0f);
		COMFORTAA_BOLD = COMFORTAA_BOLD.deriveFont(50.0f);
		COMFORTAA_LIGHT = COMFORTAA_LIGHT.deriveFont(14.0f);
		System.out.println("Done initializing main menu.");
	}
	
	//Draw objects to state/window.
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.drawImage(bg0,0,0);
		g.drawImage(bg1,0,0);
		
		//TrueTypeFont cbF = new TrueTypeFont(COMFORTAA_BOLD, true);
		//TrueTypeFont clF = new TrueTypeFont(COMFORTAA_LIGHT, true);
		
		//cbF.drawString(32, 32, "Some Next RTS!", Color.lightGray);
		
		String debugDeltaAndRender = "bgPulseCount is @ " + bgPulseCount;
		g.drawString(debugDeltaAndRender, 32, 128);
		
		
		if (doPulse == false) {
			if (bg1.getAlpha() > 0.00) {
				bg1.setAlpha(bg1.getAlpha() - 0.001f);
				//System.out.println("Making it transparent!");
			}
		} else if (doPulse == true) {
			if (bg1.getAlpha() < 1) {
				bg1.setAlpha(bg1.getAlpha() + 0.001f);
				//System.out.println("Making it full!!");
			}
		} else {
			//System.out.println("Confused atm... alpha @ " + bg1.getAlpha());
		}
	
	}
	
	//Interact with drawn objects through updates.
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		bgPulseCount+=delta;
		if (bgPulseCount > 1000) {
			doPulse = !doPulse;
			//System.out.println("Alternating pulse!");
			bgPulseCount = 0;
		}
	}
	
	//ID of the current state. Change '?' accordingly.
	public int getID() {
		return 2;
	}
	
}
