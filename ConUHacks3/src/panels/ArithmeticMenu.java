package panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import conuhacks3.Main;
import logic.GeneralCalculations;
import logic.GeneralCalculations.Difficulty;
import logic.GeneralCalculations.GameMode;
import logic.GeneralCalculations.Topic;
import logic.Question;

public class ArithmeticMenu extends JPanel {

	private JFrame mainWindow;

	private JLabel lblTopic;
	private JComboBox cbTopic;
	private JLabel lblGameMode;
	private JComboBox cbGameMode;
	private JLabel lblDifficulty;
	private JComboBox cbDifficulty;
	private JButton btnSubmit;

	public ArithmeticMenu(JFrame mainWindow) {
		this.mainWindow = mainWindow;
		String[] topic = new String[] { "Addition", "Substraction", "Multiplication", "Division" };
		String[] level = new String[] { "Easy", "Medium", "Hard" };
		String[] gameMode = new String[] { "Find the Result" };

		lblTopic = new JLabel("Topic");
		cbTopic = new JComboBox(topic);
		lblGameMode = new JLabel("Game Mode");
		cbGameMode = new JComboBox(gameMode);
		lblDifficulty = new JLabel("Difficulty");
		cbDifficulty = new JComboBox(level);
		btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int topic = cbTopic.getSelectedIndex();
				int gameMode = cbGameMode.getSelectedIndex();
				int difficulty = cbDifficulty.getSelectedIndex();
				// From the values of the selected comboboxes, mpa it to the correct enum
				Topic t = null;
				GameMode gm = null;
				Difficulty dif = null;

				switch (topic) {
				case 0:
					t = Topic.ADD;
					break;
				case 1:
					t = Topic.SUB;
					break;
				case 2:
					t = Topic.MULT;
					break;
				case 3:
					t = Topic.DIV;
					break;
				}
				switch (gameMode) {
				case 0:
					gm = GameMode.FIND_RESULT;
					break;
				}

				switch (difficulty) {
				case 0:
					dif = Difficulty.EASY;
					break;
				case 1:
					dif = Difficulty.NORMAL;
					break;
				case 2:
					dif = Difficulty.HARD;
					break;
				}

				Question[] questions = GeneralCalculations.generateQuestions(dif, t, gm);
				System.out.println("The questions are going to be given to the game screen");
				Main.gameScreen.getQuestion(questions);
				System.out.println("The questions have been given");
				mainWindow.remove(Main.arithmeticMenu);
				mainWindow.add(Main.gameScreen);
				mainWindow.validate();
				mainWindow.repaint();
			}
		});

		this.add(lblTopic);
		this.add(cbTopic);
		this.add(lblGameMode);
		this.add(cbGameMode);
		this.add(lblDifficulty);
		this.add(cbDifficulty);
		this.add(btnSubmit);

	}
}
