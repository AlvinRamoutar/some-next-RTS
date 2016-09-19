package game;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

import game.loading.*;
import game.menu.*;
import game.play.*;

public class Game extends StateBasedGame{
	
	public static final String gameName = "Some Next RTS!";
	public static final int intro = 0;
	public static final int loading = 1;
	public static final int main_menu = 2;
	public static final int mp_menu = 3;
	public static final int play = 4;
	public static final int post_play = 5;
	
	public Game(String gameName) {
		super(gameName);
		this.addState(new Intro(intro));
		this.addState(new Loading(loading));
		this.addState(new MainMenu(main_menu));
		this.addState(new MPMenu(mp_menu));
		this.addState(new Play(play));
		this.addState(new PostPlay(post_play));
	}
	
	public void initStatesList(GameContainer gc) throws SlickException {
		this.getState(intro).init(gc, this);
		this.getState(loading).init(gc, this);
		this.getState(main_menu).init(gc, this);
		this.getState(mp_menu).init(gc, this);
		this.getState(play).init(gc, this);
		this.getState(post_play).init(gc, this);
		
		this.enterState(intro);
	}
	
	public static void main(String[] args) {
		AppGameContainer appgc;
		try {
			appgc = new AppGameContainer(new Game(gameName));
			appgc.setDisplayMode(Globals.screenWidth, Globals.screenHeight, false);
			appgc.start();
		} catch(SlickException e) {
			e.printStackTrace();
		}
		
	

	}

}
