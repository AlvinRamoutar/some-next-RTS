package game.sp_play;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

public class MapBackup extends SPPlay {

	public MapBackup(int state) {
		super(state);
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		super.init(gc, sbg);
		
		/*
		try {
			map = new TiledMap("res/map/mapSample.tmx", "res/map/");
		} catch(SlickException e) {
			e.printStackTrace();
			game.menu.console.Command.print("Failed to load map!", 3);
		}
		*/
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		super.render(gc, sbg, g);
		map.render((int)-mapCamX,(int)-mapCamY);
		System.out.println("Trying 2 renderp");
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		super.update(gc, sbg, delta);
	}

}
