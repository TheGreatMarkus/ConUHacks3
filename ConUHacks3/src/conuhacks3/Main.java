package conuhacks3;

import java.awt.Dimension;

import javax.swing.JFrame;

import logic.GeneralCalculations;
import logic.GeneralCalculations.Difficulty;
import logic.GeneralCalculations.GameMode;
import logic.GeneralCalculations.Topic;
import panels.ArithmeticMenu;
import panels.GameScreen;
import panels.MainMenu;
import panels.ResultScreen;
import panels.WelcomeMenu;

public class Main {

	public static MainMenu mainMenu;
	public static WelcomeMenu welcomeMenu;
	public static ArithmeticMenu arithmeticMenu;
	public static GameScreen gameScreen;
	public static ResultScreen resultScreen;

	public static void main(String[] args) {
		System.out.println("This is the main file.");
		// Creating the window
		GeneralCalculations.generateQuestions(Difficulty.HARD, Topic.ADD, GameMode.FIND_RESULT);
		JFrame mainWindow = new JFrame();

		// Initializing the window
		mainWindow.setSize(new Dimension(900, 600));
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindow.setLocationRelativeTo(null);

		// Initializing the JPanels/Pages
		mainMenu = new MainMenu(mainWindow);
		welcomeMenu = new WelcomeMenu(mainWindow);
		arithmeticMenu = new ArithmeticMenu(mainWindow);
		gameScreen = new GameScreen(mainWindow);
		resultScreen = new ResultScreen(mainWindow);
		mainWindow.add(welcomeMenu);
		mainWindow.setVisible(true);
	}

}