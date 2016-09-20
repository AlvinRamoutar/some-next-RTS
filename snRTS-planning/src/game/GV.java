//Global variables & constants used.

package game;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;

public class GV {
	
	public static final String GAMENAME = "Some Next RTS!";
	public static final String VERSION = "VER. ALPHA 1.0";
	
	
	public static java.awt.Font COMFORTAA_BOLD = new Font("TimesRoman", Font.PLAIN, 12);
	
	//Loading fonts, static initializer to catch IO exceptions.
	static {
		try {
			COMFORTAA_BOLD = java.awt.Font.createFont(java.awt.Font.TRUETYPE_FONT, org.newdawn.slick.util.ResourceLoader.getResourceAsStream("res/fonts/Comfortaa/Comfortaa-Bold.ttf"));
		} catch(IOException e) {
			e.printStackTrace();
		} catch(FontFormatException e) {
			e.printStackTrace();
		}
	}
	
	public static final org.newdawn.slick.UnicodeFont UNIFONT_COMFORTAA = new org.newdawn.slick.UnicodeFont(COMFORTAA_BOLD);
	
	/*Use me to load fonts.	
	uniFont.addAsciiGlyphs();
	uniFont.getEffects().add(new org.newdawn.slick.font.effects.ColorEffect.ColorEffect());
	*/
	
	public static final int SPLASH = 0;
	public static final int LOADING = 1;
	public static final int MAIN_MENU = 2;
	public static final int MP_MENU = 3;
	public static final int PLAY = 4;
	public static final int POST_PLAY = 5;
	
	public static int screenWidth = 640;
	public static int screenHeight = 480;
	public static int currentTicks = 0;
}

