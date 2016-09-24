package game.menu.console;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import game.GV;

public class Command {

	static ArrayList<String> consoleLog = new ArrayList<>();
	
	public static void main(String cmd) {

		String justCMD = "";
		String entireCMD = "";
		
		if(cmd.indexOf("/") == -1) {
			print("Prefix '/' to your CMD.", 2);
		} else {
			entireCMD = cmd.substring(cmd.indexOf("/")+1);
			justCMD = entireCMD.substring(0, entireCMD.indexOf(" "));
			commandParse(justCMD, entireCMD);
		}
	}
	
	public static void commandParse(String cmd, String entireCMD) {
		switch(cmd) {
			case "help":
				break;
			case "quit":
				break;
			case "exit":
				
				break;
		}
	}
	
	public static void print(String msg, int type) {
		
		Calendar time = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		
		switch(type) {
		case 1:
			game.Options.consoleOutput.append("\n" + "[" + sdf.format(time.getTime()) + "]" + "[INFO] " + msg);
			System.out.println("[" + sdf.format(time.getTime()) + "]" + "[INFO] " + msg);
			consoleLog.add(("[" + sdf.format(time.getTime()) + "]" + "[INFO] " + msg));
			break;
		case 2:
			game.Options.consoleOutput.append( "\n" + "[" + sdf.format(time.getTime()) + "]" + "[WARN] " + msg);
			System.out.println("[" + sdf.format(time.getTime()) + "]" + "[WARN] " + msg);
			consoleLog.add(("[" + sdf.format(time.getTime()) + "]" + "[WARN] " + msg));
			break;
		case 3:
			game.Options.consoleOutput.append("\n" + "[" + sdf.format(time.getTime()) + "]" + "[ERR] " + msg);
			System.out.println("[" + sdf.format(time.getTime()) + "]" + "[ERR] " + msg);
			consoleLog.add(("[" + sdf.format(time.getTime()) + "]" + "[ERR] " + msg));
			break;
		default:
			game.Options.consoleOutput.append( "\n" + "[" + sdf.format(time.getTime()) + "]" + "[?] " + msg);
			System.out.println("[" + sdf.format(time.getTime()) + "]" + "[?] " + msg);
			consoleLog.add(("[" + sdf.format(time.getTime()) + "]" + "[?] " + msg));
			break;
		}
	}

}
