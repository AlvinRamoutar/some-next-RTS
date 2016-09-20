package game.loading;

import game.GV;

public class DTT {

	public static boolean main(float seconds) {
		GV.currentTicks++;
		
		if(GV.currentTicks/1000 == seconds) {
			GV.currentTicks = 0;
			return true;
		} else {
			return false;
		}
	}
}
