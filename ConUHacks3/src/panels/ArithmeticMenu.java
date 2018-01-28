package panels;

import java.awt.GridLayout;
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

	private JLabel lblTitles;
	private JComboBox cbTopic;
	private JComboBox cbGameMode;
	private JComboBox cbDifficulty;
	private JButton btnSubmit;
	private JButton btnBack;
	private JPanel top;
	private JPanel mid;
	private JPanel bottom;

	public ArithmeticMenu(JFrame mainWindow) {
		this.mainWindow = mainWindow;
		String[] topic = new String[] { "Addition", "Substraction", "Multiplication", "Division" };
		String[] level = new String[] { "Easy", "Medium", "Hard" };
		String[] gameMode = new String[] { "Find the Result", "Fill in the Blank" };

		lblTitles = new JLabel("Topic                 Game Mode               Difficulty");
		cbTopic = new JComboBox(topic);
		cbGameMode = new JComboBox(gameMode);
		cbDifficulty = new JComboBox(level);
		btnSubmit = new JButton("Submit");
		btnBack = new JButton("Back");
		top = new JPanel();
		mid = new JPanel();
		bottom = new JPanel();

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
				case 1:
					gm = GameMode.FILL_IN_THE_BLANK;
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
				Main.gameScreen.getQuestions(questions.clone());
				mainWindow.remove(Main.arithmeticMenu);
				mainWindow.add(Main.gameScreen);
				mainWindow.validate();
				mainWindow.repaint();
			}
		});
		btnBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mainWindow.remove(Main.arithmeticMenu);
				mainWindow.add(Main.mainMenu);
				mainWindow.validate();
				mainWindow.repaint();
			}
		});
		this.setLayout(new GridLayout(3, 1));
		this.add(lblTitles);
		lblTitles.setVerticalAlignment(JLabel.BOTTOM);
		lblTitles.setHorizontalAlignment(JLabel.CENTER);

		/////////////////////
		this.add(mid);
		mid.add(cbTopic);
		mid.add(cbGameMode);
		mid.add(cbDifficulty);
		///////////////////////////////////////////////////////////////

		this.add(bottom);
		bottom.add(btnBack);
		bottom.add(btnSubmit);

	}
}
