package game.sp_play.map;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.gui.MouseOverArea;

import game.GV;

public class MapMovement {
	
	private static int mapScrollThickness = 16;
	
	public MapMovement() {
		
	}
	
	// Initialize Map Scroller Areas
	public static MouseOverArea MapScrollInit(GameContainer gc, int moaPos) {
		switch(moaPos) {
		case 0:
			return new MouseOverArea(gc, null, 0, 0, GV.SCREENWIDTH, mapScrollThickness);
		}
		return null;
	}

}
