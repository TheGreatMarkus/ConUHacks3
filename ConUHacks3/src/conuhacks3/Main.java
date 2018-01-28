package conuhacks3;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JFrame;

import panels.ArithmeticMenu;
import panels.MainMenu;
import panels.ArithmeticMenu;
import panels.WelcomeMenu;

public class Main {

	public static MainMenu mainMenu;
	public static WelcomeMenu welcomeMenu;
	public static ArithmeticMenu arithmeticMenu ;
	

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
		arithmeticMenu = new ArithmeticMenu (mainWindow);
		mainWindow.add(welcomeMenu);
		mainWindow.setVisible(true);
	}

}