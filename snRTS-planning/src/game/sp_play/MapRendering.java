package game.sp_play;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.MouseOverArea;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

import game.GV;

public class MapRendering {
	
	TiledMap map;
	private MouseOverArea[] mapScroll = new MouseOverArea[4];
	private int mapScrollThickness = 16;
	
	private float mapCamX, mapCamY = 0;
	private float mapScrollSpeed = 1;
	private boolean mapScrollUp, mapScrollDown, mapScrollLeft, mapScrollRight;
	
	public MapRendering(GameContainer gc, StateBasedGame sbg) {
		
		game.menu.console.Command.print("Initializing Map and Map Functions", 1);
		
		// Loading default map, which is mapDraft.
		//map = new TiledMap("res/map/isometric_grass_and_water.tmx", "res/map");
		// Map fills screen @ 10 tiles by 15 (MIN).
		/*
		try {
			map = new TiledMap("res/map/mapSample.tmx", "res/map/");
			game.menu.console.Command.print("Map loaded successfully!", 1);
		} catch(SlickException e) {
			e.printStackTrace();
			game.menu.console.Command.print("Failed to load map!", 3);
		}
		*/
		
		//Setting up map edges for scrolling.
		mapScroll[0] = new MouseOverArea(gc, null, 0, 0, GV.SCREENWIDTH, mapScrollThickness);
		mapScroll[1] = new MouseOverArea(gc, null, GV.SCREENWIDTH - mapScrollThickness, 0, mapScrollThickness, GV.SCREENHEIGHT);
		mapScroll[2] = new MouseOverArea(gc, null, 0, GV.SCREENHEIGHT - mapScrollThickness, GV.SCREENWIDTH, mapScrollThickness);
		mapScroll[3] = new MouseOverArea(gc, null, 0, 0, mapScrollThickness, GV.SCREENHEIGHT);
	}
	
	public MapRendering(GameContainer gc, StateBasedGame sbg, Graphics g) {
		while(GV.MAP_RENDERED == false) {
			try {
				map = new TiledMap("res/map/mapSample.tmx", "res/map/");
				game.menu.console.Command.print("Map loaded successfully!", 1);
				GV.MAP_RENDERED = true;
			} catch(SlickException e) {
				e.printStackTrace();
				game.menu.console.Command.print("Failed to load map!", 3);
			}
		}
		map.render(0,0);
	}
	
	/*
	public MapRendering(GameContainer gc, StateBasedGame sbg, int delta) {
		
		float moveSpeed = delta * 0.4f * (1/mapScrollSpeed);
		  
		if(mapScrollLeft) {
			mapCamX -= moveSpeed;
		}
		if(mapScrollUp) {
			mapCamY -= moveSpeed;
		}
		if(mapScrollRight) {
			mapCamX += moveSpeed;
		}
		if(mapScrollDown) {
			mapCamY += moveSpeed;
		}
	}
	*/
	
	public void keyPressed(int key, char c) {
		if( key == Input.KEY_LEFT) {
			mapScrollLeft = true;
	    }
	    if( key == Input.KEY_UP ) {
	        mapScrollUp = true;
	    }
	    if( key == Input.KEY_RIGHT ) {
	        mapScrollRight = true;
	    }
	    if( key == Input.KEY_DOWN ) {
	        mapScrollDown = true;
	    }
	}
	
	public void keyReleased(int key, char c) {
		if( key == Input.KEY_LEFT) {
			mapScrollLeft = false;
	    }
	    if( key == Input.KEY_UP ) {
	        mapScrollUp = false;
	    }
	    if( key == Input.KEY_RIGHT ) {
	    	mapScrollRight = false;
	    }
	    if( key == Input.KEY_DOWN ) {
	        mapScrollDown = false;
	    }
	}
	

}
