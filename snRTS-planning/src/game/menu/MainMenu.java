package game.menu;

import org.newdawn.slick.*;
import org.newdawn.slick.gui.MouseOverArea;
import org.newdawn.slick.state.*;

import game.GV;

public class MainMenu extends BasicGameState {
		
	private Image bg0;
	private Image bg1;
	private int bgPulseCount = 0;
	private boolean doPulse = false;
	
	private Image optionsPlaceholder;
	private MouseOverArea[] menuOptions = new MouseOverArea[5];
	private float[] menuOptionOpacity = new float[5];
	private boolean[] menuOptionOpacityStatus = new boolean[5];
	
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
		
		//Defining mouseOver area for options.
		optionsPlaceholder = new Image("res/images/menu/optionsPlaceholder.jpg");
		for(int a = 0; a < menuOptions.length; a++) {
			menuOptions[a] = new MouseOverArea(gc, optionsPlaceholder, 454, 318 + (a*30), 188, 20);
			menuOptions[a].setNormalColor(new Color(255,255,255,0f));
			menuOptions[a].setMouseOverColor(new Color(255,255,255,0f));
			menuOptions[a].setMouseDownColor(new Color(255,255,255,0f));
			menuOptionOpacity[a] = 0.5f;
		}
	}
	
	//Draw objects to state/window.
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.drawImage(bg0,0,0);
		g.drawImage(bg1,0,0);
		
		GV.FONTBOLD_COMFORTAA.drawString(30, 85, "SOME NEXT RTS", new org.newdawn.slick.Color(255, 255, 255, 0.60f));
		GV.FONTLIGHT_COMFORTAA.drawString(5, 5, GV.VERSION, new org.newdawn.slick.Color(255, 255, 255, 0.5f));
		GV.FONTLIGHT_COMFORTAA.drawString(454, 318, "SINGLE PLAYER [WIP]", new org.newdawn.slick.Color(255, 255, 255, menuOptionOpacity[0]));
		GV.FONTLIGHT_COMFORTAA.drawString(518, 348, "MULTIPLAYER", new org.newdawn.slick.Color(255, 255, 255, menuOptionOpacity[1]));
		GV.FONTLIGHT_COMFORTAA.drawString(556, 378, "OPTIONS", new org.newdawn.slick.Color(255, 255, 255, menuOptionOpacity[2]));
		GV.FONTLIGHT_COMFORTAA.drawString(590, 408, "HELP", new org.newdawn.slick.Color(255, 255, 255, menuOptionOpacity[3]));
		GV.FONTLIGHT_COMFORTAA.drawString(592, 438, "QUIT", new org.newdawn.slick.Color(255, 255, 255, menuOptionOpacity[4]));

		//Preparing areas for menu options.
		//Also adjusts opacity as per mouseover.
		for (int a=0; a < menuOptions.length; a++) {
			menuOptions[a].render(gc, g);
			
			if(menuOptionOpacityStatus[a] == true) {
				if(menuOptionOpacity[a] < 1) {
					menuOptionOpacity[a] += 0.005f;
				}
			} else {
				if(menuOptionOpacity[a] > 0.5) {
					menuOptionOpacity[a] -= 0.005f;
				}
			}
		}	
	
		// Adjusts the opacity of background images to create a pulsating effect.
		if (doPulse == false) {
			if (bg1.getAlpha() > 0.00) {
				bg1.setAlpha(bg1.getAlpha() - 0.001f);
			}
		} else  {
			if (bg1.getAlpha() < 0.75) {
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
		
		//Handles changing of option opacity, and actions upon clicking said option.
		for(int a=0; a < menuOptions.length; a++) {
			if(menuOptions[a].isMouseOver()) {
				menuOptionOpacityStatus[a] = true;
			} else {
				menuOptionOpacityStatus[a] = false;
			}
			
			if(menuOptions[a].isMouseOver() && gc.getInput().isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
				switch(a) {
					case 0:
						break;
					case 1:
						break;
					case 2:
						game.Options.main(null);
						break;
					case 3:
						break;
					case 4:
						gc.exit();
						break;
				}
			}
		}
	}
	
	//ID of the current state. Change '?' accordingly.
	public int getID() {
		return 2;
	}
	
}
