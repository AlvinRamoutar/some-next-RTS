package game.loading;

import game.GV;

public class DTT {

	public static boolean main(float seconds) {
		GV.SPLASHTICKS++;
		
		if(GV.SPLASHTICKS/1000 == seconds) {
			GV.SPLASHTICKS = 0;
			return true;
		} else {
			return false;
		}
	}
}
