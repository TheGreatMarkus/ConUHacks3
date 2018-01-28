package panels;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import conuhacks3.Main;

public class WelcomeMenu extends JPanel {

	private JFrame mainWindow;

	private JButton startButton;

	public WelcomeMenu(JFrame mainWindow) {
		this.mainWindow = mainWindow;
		this.setBackground(Color.BLACK);

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
		this.add(startButton);
	}

}