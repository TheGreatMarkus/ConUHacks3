package conuhacks3;

import java.awt.Dimension;

import javax.swing.JFrame;

import panels.MainMenu;
import panels.WelcomeMenu;

public class Main {

	public static MainMenu mainMenu;
	public static WelcomeMenu welcomeMenu;

	public static void main(String[] args) {
		System.out.println("This is the main file.");
		// Creating the window
		JFrame mainWindow = new JFrame();
		
		// Initializing the window
		mainWindow.setSize(new Dimension(500, 500));
		mainWindow.setLocationRelativeTo(null);
		
		// Initializing the JPanels/Pages
		mainMenu = new MainMenu(mainWindow);
		welcomeMenu = new WelcomeMenu(mainWindow);

		mainWindow.add(welcomeMenu);
		mainWindow.setVisible(true);
	}

}
