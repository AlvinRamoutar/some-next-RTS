package game.menu.console;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import game.GV;

public class Command {

	static ArrayList<String> consoleLog = new ArrayList<>();
	
	public static void main(String cmd) {

		String justCMD = "";
		
		if(cmd.indexOf("/") == -1) {
			print("Prefix '/' to your CMD.", 2);
		} else {
			justCMD = cmd.substring(cmd.indexOf("/")+1);
			if(cmd.indexOf(" ") == -1) {
				commandParse(justCMD, cmd);
			} else {
				justCMD = justCMD.substring(0, justCMD.indexOf(" "));
				commandParse(justCMD, cmd);	
			}
		}
	}
	
	public static void commandParse(String cmd, String entireCMD) {
		switch(cmd) {
			case "exportlogs":
				String[] currentLog = consoleLog.toArray(new String[0]);
				game.menu.console.Filechooser.exportLogs(currentLog);
				print("Exporting logs to designated location.", 1);
				break;
			case "togglefps":
				if(GV.TOGGLEFPS == false) {
					print("Enabling FPS counter.", 1);
					GV.TOGGLEFPS = true;
					game.Game.toggleFPS();
				} else {
					print("Disabling FPS counter.", 1);
					GV.TOGGLEFPS = false;
					game.Game.toggleFPS();
				}
				break;
			case "help":
				game.menu.MainMenu.openHelpPage(GV.HELPURL);
				print("Launching help page in web browser.", 1);
				break;
			case "quit":
				print("Terminating game instance, good bye!", 2);
				game.Game.quitGame(null);
				GV.EXIT = true;
				break;
			case "exit":
				print("Terminating game instance, good bye!", 2);
				game.Game.quitGame(null);
				GV.EXIT = true;
				break;
			default:
				print("Command doesn't exist!", 2);
				break;
		}
	}
	
	//Handles printing command status' to debug window.
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