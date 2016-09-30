package game.menu.console;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ExternalPrompts {

	JLabel promptLabel;
	JTextField promptForm;
	JButton okayButton;
	JButton yesButton;
	JButton noButton;
	
	static Point mouseDownCoords;
	static Point currentCoords;
	
	final JFrame ExternalPrompts = new JFrame();
	
	public static void main(String promptTitle, String promptText, int promptType, int promptWidth, int promptHeight) {
		new ExternalPrompts(promptTitle, promptText, promptType, promptWidth, promptHeight);
	}
	
	public ExternalPrompts(String promptTitle, String promptText, int promptType, int promptWidth, int promptHeight) {
		
		ExternalPrompts.setSize(promptWidth, promptHeight);
		ExternalPrompts.setResizable(false);
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		
		Dimension screenSize = tk.getScreenSize();
		ExternalPrompts.setLocation((screenSize.width/2) - promptWidth, (screenSize.height/2) - promptHeight);
		
		ExternalPrompts.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				
		ExternalPrompts.setTitle(promptTitle);
				
		ExternalPrompts.setUndecorated(true);
		
		ExternalPrompts.setOpacity(0.55f);
		
		// Handle moving window by dragging with mouse.
		// Required, since I've removed the window ribbon.
		ExternalPrompts.addMouseListener(new MouseListener(){
            public void mouseReleased(MouseEvent e) {
                mouseDownCoords = null;
            }
            public void mousePressed(MouseEvent e) {
                mouseDownCoords = e.getPoint();
            }
            public void mouseExited(MouseEvent e) {
            }
            public void mouseEntered(MouseEvent e) {
            }
            public void mouseClicked(MouseEvent e) {
            }
        });
		
		// Listener, checks for MouseDown, changes window location according to drag.
		// Might need to remove  if it interferes with something else.
        ExternalPrompts.addMouseMotionListener(new MouseMotionListener(){
            public void mouseMoved(MouseEvent e) {
            }

            public void mouseDragged(MouseEvent e) {
            	System.out.println("Mouse being dragged!");
                currentCoords = e.getLocationOnScreen();
                ExternalPrompts.setLocation(currentCoords.x - mouseDownCoords.x, currentCoords.y - mouseDownCoords.y);
            }
        });
        
        // Type of prompt selector.
		switch(promptType) {
			case 1:
				infoPromptGen(promptText);
				break;
			case 2:
				optionPromptGen();
				break;
			case 3:
				formPromptGen();
				break;
			default:
				infoPromptGen(promptText);
				break;
		}
		
		ExternalPrompts.toFront();
	}
	
	private void infoPromptGen(String promptText) {
		JPanel theOneAndOnlyPanel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		theOneAndOnlyPanel.setBackground(Color.darkGray);
		ExternalPrompts.add(theOneAndOnlyPanel);
		ExternalPrompts.setVisible(true);
			
		okayButton = new JButton("");
		Acknowledge okayThen = new Acknowledge();
		okayButton.addActionListener(okayThen);

		theOneAndOnlyPanel.add(okayButton, c);
		
		
		// Sets pressing 'enter' to default to 'ok'
		theOneAndOnlyPanel.getRootPane().setDefaultButton(okayButton);
	}
	
	private void optionPromptGen() {
		JPanel theOneAndOnlyPanel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
	}

	private void formPromptGen() {
		JPanel theOneAndOnlyPanel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
	}
	
	private class Acknowledge implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == okayButton) {
				dispose();
			}
		}
	}

	public void dispose() {
		dispose();
	}


}