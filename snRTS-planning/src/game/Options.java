package game;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import javax.swing.text.DefaultCaret;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import game.GV;

public class Options extends JFrame {
	
	private static final long serialVersionUID = 0;
	
	JLabel instMasterVolume;
	JLabel instSoundVolume;
	JLabel instMusicVolume;
	public static JTextArea consoleOutput;
	JTextArea consoleInput;
	JSeparator consoleSeparator1;
	JSeparator consoleSeparator2;
	JButton submitCMD;
	JSlider masterVolume;
	JSlider soundVolume;
	JSlider musicVolume;
	
	public static void main(String args[]) {
		new Options();
	}
	
	public Options() {
		this.setSize(GV.DEBUG_SCREENWIDTH, GV.DEBUG_SCREENHEIGHT);
		this.setResizable(false);
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		
		Dimension screenSize = tk.getScreenSize();
		this.setLocation((screenSize.width/2) - GV.DEBUG_SCREENWIDTH, (screenSize.height/2) - GV.DEBUG_SCREENHEIGHT);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
		this.setTitle(GV.GAMENAME + " - Debug");
		
		jPanelCreation();
	}

	private void jPanelCreation() {
		JPanel theOneAndOnlyPanel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		
		instMasterVolume = new JLabel("MASTER VOLUME");
		instMasterVolume.setForeground(Color.white);
		c.ipady = 2;
		c.insets = new Insets(10,0,0,0);
		c.gridwidth = 2;
		c.weightx = 0;
		c.gridx = 0;
		c.gridy = 0;
		theOneAndOnlyPanel.add(instMasterVolume, c);
		
		masterVolume = new JSlider(JSlider.HORIZONTAL, 0, 100, 100);
		masterVolume.setBackground(null);
		c.insets = new Insets(0,0,0,0);
		c.gridy = 1;
		theOneAndOnlyPanel.add(masterVolume, c);
		
		instSoundVolume = new JLabel("SOUND VOLUME");
		instSoundVolume.setForeground(Color.white);
		c.gridy = 2;
		theOneAndOnlyPanel.add(instSoundVolume, c);
		
		soundVolume = new JSlider(JSlider.HORIZONTAL, 0, 100, 100);
		soundVolume.setBackground(null);
		c.gridy = 3;
		theOneAndOnlyPanel.add(soundVolume, c);
		
		instMusicVolume = new JLabel("MUSIC VOLUME");
		instMusicVolume.setForeground(Color.white);
		c.gridy = 4;
		theOneAndOnlyPanel.add(instMusicVolume, c);
		
		musicVolume = new JSlider(JSlider.HORIZONTAL, 0, 100, 100);
		musicVolume.setBackground(null);
		c.gridy = 5;
		theOneAndOnlyPanel.add(musicVolume, c);
		
		consoleSeparator1 = new JSeparator();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridy = 6;
		c.insets = new Insets(10,0,0,0);
		theOneAndOnlyPanel.add(consoleSeparator1, c);
		
		consoleOutput = new JTextArea("Debug instance running!");
		Font italicConsoleFont = new Font(consoleOutput.getFont().getName(),Font.ITALIC,consoleOutput.getFont().getSize());
		consoleOutput.setFont(italicConsoleFont);
		DefaultCaret consoleCaret = (DefaultCaret)consoleOutput.getCaret();
		consoleCaret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		JScrollPane consoleScrollbar = new JScrollPane(consoleOutput, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		consoleOutput.setEditable(false);
		consoleOutput.setForeground(Color.lightGray);
		consoleScrollbar.setBackground(null);
		consoleOutput.setBackground(Color.darkGray);
		consoleScrollbar.getViewport().setOpaque(true);
		c.fill = GridBagConstraints.BOTH;
		c.insets = new Insets(0,0,0,0);
		c.weighty = 2;
		c.gridy = 7;
		//theOneAndOnlyPanel.add(consoleOutput, c);
		theOneAndOnlyPanel.add(consoleScrollbar, c);
		
		consoleInput = new JTextArea("enter cmd...");
		consoleInput.setBackground(new Color(90,90,90));
		consoleInput.setForeground(Color.white);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 1;
		c.ipady = 0;
		c.weightx = 2;
		c.weighty = 0;
		c.gridx = 0;
		c.gridy = 8;
		theOneAndOnlyPanel.add(consoleInput, c);
		
		submitCMD = new JButton("SUBMIT");
		ListenForCMD lForCMD = new ListenForCMD();
		submitCMD.addActionListener(lForCMD);
		c.weightx = 0;
		c.gridx = 1;
		c.gridy = 8;
		theOneAndOnlyPanel.add(submitCMD, c);
				
		this.add(theOneAndOnlyPanel);
		
		theOneAndOnlyPanel.setBackground(Color.darkGray);
		
		this.setVisible(GV.OPTIONSVISIBLE);
	}
	
	// Implementing a listener for command send.
	/*
	 * Tired ASF. Finish later.
	 * PLAN:
	 * -Create seperate class to handle commands
	 * -Implement sliders for audio (once we even HAVE a soundsystem).
	 * -Have source(button) activation send commands to said class, W. status return.
	 * -Integrate commandline into EVERYTHING. Including states, AND EXCEPTIONS.
	 * 															 ESPECIALLY EXCEPTIONS.
	 * 
	 */
	
	private class ListenForCMD implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == submitCMD) {
				game.menu.console.Command.main(consoleInput.getText());
				consoleOutput.setCaretPosition(consoleOutput.getDocument().getLength());
			}
		}
	}

}
