package game.sp_play;

import java.util.HashMap;

import game.GV;

public class EntityMovement {

	public EntityMovement() {
		// TODO Auto-generated constructor stub
	}
	
	public void moveEntity(String entityID, int x, int y) {
		GV.ACTIVE_ENTITIES.put(entityID, x + "," + y);
	}
	
	public int drawEntity(String entityID, char cordinate) {
		if(doesEntityExist(entityID)) {
			switch(cordinate) {
				case 'x':
					int xMap = Integer.parseInt(GV.ACTIVE_ENTITIES.get(entityID).substring(GV.ACTIVE_ENTITIES.get(entityID).indexOf(",")));
					int xCoord = (xMap*64);
					return xCoord;
					break;
				case 'y':
					return yCoord;
					break;
			}
		} else {
			game.menu.console.Command.print("Cannot draw entity " + entityID + " , because it hasn't been created!", 3);
			return -1;
		}
	}
	
	// Just in case, might be necessary in the future.
	private boolean doesEntityExist(String entityID) {
		if(GV.ACTIVE_ENTITIES.get(entityID) == null) {
			return false;
		} else {
			return true;
		}
	}
}
