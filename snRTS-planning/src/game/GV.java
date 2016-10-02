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
	public static final int SPPLAY = 4;
	public static final int POST_SPPLAY = 5;
	//public static final int MPPLAY = 6;
	//public static final int POST_MPPLAY = 7;
	public static boolean TOGGLEFPS = false;
	
	public static int SPLASHTICKS = 0;
	
	public static int SCREENWIDTH = 640;
	public static int SCREENHEIGHT = 480;
	public static int DEBUG_SCREENWIDTH = 320;
	public static int DEBUG_SCREENHEIGHT = 320;
	public static boolean OPTIONSVISIBLE = false;
	public static boolean EXIT = false; //Does nothing for now, use as a check in the future
	
	public static AngelCodeFont FONTBOLD_COMFORTAA;
	public static AngelCodeFont FONTLIGHT_COMFORTAA;
	public static AngelCodeFont FONTLIGHT_EXO;
	
	public static final String HELPURL = "https://github.com/AlvinRamoutar/some-next-RTS/";
	
	public static int MASTERVOLUME = 100;
	public static int SLAVESOUNDVOLUME = 100;
	public static int SLAVEMUSICVOLUME = 100;
	public static int SOUNDVOLUME = SLAVESOUNDVOLUME * (MASTERVOLUME/100);
	public static int MUSICVOLUME = SLAVEMUSICVOLUME * (MASTERVOLUME/100);
	
	public static String PLAYERNAME = "Player";
}

