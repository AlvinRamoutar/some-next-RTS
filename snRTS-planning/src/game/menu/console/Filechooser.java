package game.menu.console;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;

public class Filechooser {
	
	public static void main(String[] args) {

	}
	
	public static void exportLogs(String[] currentLog) {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.showSaveDialog(null);
		try {
			BufferedWriter logWriter = new BufferedWriter(new FileWriter(fileChooser.getSelectedFile().getPath()));
			for (int line = 0; line < currentLog.length; line++) {
				logWriter.write(currentLog[line]);
				logWriter.newLine();
			}
			logWriter.close();
		} catch (IOException e) {
			game.menu.console.Command.print("Failed to save logs to location.", 3);
			e.printStackTrace();
		}
	}
	
}
