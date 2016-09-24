package game;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

import game.loading.*;
import game.menu.*;
import game.play.*;
import game.GV;

public class Game extends StateBasedGame{
		
	public Game(String gameName) {
		super(GV.GAMENAME);
		this.addState(new Splash(GV.SPLASH));
		this.addState(new Loading(GV.LOADING));
		this.addState(new MainMenu(GV.MAIN_MENU));
		this.addState(new MPMenu(GV.MP_MENU));
		this.addState(new Play(GV.PLAY));
		this.addState(new PostPlay(GV.POST_PLAY));
	}
	
	public void initStatesList(GameContainer gc) throws SlickException {
		this.getState(GV.SPLASH).init(gc, this);
		this.getState(GV.LOADING).init(gc, this);
		this.getState(GV.MAIN_MENU).init(gc, this);
		this.getState(GV.MP_MENU).init(gc, this);
		this.getState(GV.PLAY).init(gc, this);
		this.getState(GV.POST_PLAY).init(gc, this);
		
		this.enterState(GV.SPLASH);
	}
	
	public static void main(String[] args) {
		AppGameContainer appgc;
		try {
			appgc = new AppGameContainer(new Game(GV.GAMENAME));
			appgc.setDisplayMode(GV.SCREENWIDTH, GV.SCREENHEIGHT, false);
			
			// Enable/Disable me as please!
			appgc.setShowFPS(false);
			appgc.setAlwaysRender(true);
			
			game.Options.main(null);
			game.menu.console.Command.print("Game Window launching.", 1);
			appgc.start();
		} catch(SlickException e) {
			game.menu.console.Command.print("Failed to launch game window.", 3);
			e.printStackTrace();
		}

	}
}
