package panels;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import conuhacks3.Main;

public class WelcomeMenu extends JPanel {

	private JFrame mainWindow;

	private JLabel lblWelcomeMessage;
	private JButton startButton;

	public WelcomeMenu(JFrame mainWindow) {
		this.mainWindow = mainWindow;
		this.setLayout(new GridLayout(2, 1));
		this.lblWelcomeMessage = new JLabel("Welcome to the Math Educational Game!");
		this.lblWelcomeMessage.setHorizontalAlignment(JLabel.CENTER);
		startButton = new JButton("Start The Application!");
		startButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainWindow.remove(Main.welcomeMenu);
				mainWindow.add(Main.mainMenu);
				mainWindow.validate();
				mainWindow.repaint();
			}
		});
		this.add(lblWelcomeMessage);
		this.add(startButton);
	}

}