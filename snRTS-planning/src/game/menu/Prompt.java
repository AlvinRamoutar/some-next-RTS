/*
 * 
 * TO BE REVISED.
 * Probably not necessary, will attempt and/or try to dodge for as long as possible.
 * 
 */

package game.menu;

import game.GV;

public class Prompt {

	public static void main(String promptTitle,
							String promptText,
							byte promptType,
							String renderWhere) {
		
		int windowXPos, windowYPos,
			titleXPos, titleYPos, 
			promptXPos, promptYPos,
			button1XPos, button1YPos,
			button2XPos, button2YPos,
			button3XPos, button3YPos = 0;
		
		windowXPos = GV.SCREENWIDTH/2 - 350/2;
		windowYPos = GV.SCREENHEIGHT/2 - 138/2;
		
		titleXPos = GV.SCREENWIDTH/2 - 350/2;
		titleYPos = GV.SCREENHEIGHT/2 - 138/2 - 2;
		
		promptXPos = GV.SCREENWIDTH/2 - 350/2;
		promptYPos = GV.SCREENHEIGHT/2 - 138/2 - 20;
		
		switch(promptType) {
			case 1:
				button1XPos = GV.SCREENWIDTH/2 - 350/2;
				button1YPos = GV.SCREENHEIGHT/2 - 138/2 - 60;
				break;
		}

	}

}
