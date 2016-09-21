//Global variables & constants used.

package game;

import org.newdawn.slick.AngelCodeFont;

public class GV {
	
	public static final String GAMENAME = "Some Next RTS!";
	public static final String VERSION = "version | alpha 1.0";
		
	public static final int SPLASH = 0;
	public static final int LOADING = 1;
	public static final int MAIN_MENU = 2;
	public static final int MP_MENU = 3;
	public static final int PLAY = 4;
	public static final int POST_PLAY = 5;
	
	public static int screenWidth = 640;
	public static int screenHeight = 480;
	public static int currentTicks = 0;
	
	//Fonts, consider leaving me here.
	public static AngelCodeFont FONTBOLD_COMFORTAA;
	public static AngelCodeFont FONTLIGHT_COMFORTAA;
}

