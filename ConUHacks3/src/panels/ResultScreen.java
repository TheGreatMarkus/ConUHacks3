package panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import conuhacks3.Main;
import logic.Question;

public class ResultScreen extends JPanel {

	private JFrame mainWindow;

	private Question[] questionsThatWereAsked;

	private JLabel lblScore;
	private JButton btnConfirm;

	public ResultScreen(JFrame mainWindow) {
		this.mainWindow = mainWindow;

		this.lblScore = new JLabel();
		this.btnConfirm = new JButton("Ok");
		this.btnConfirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainWindow.remove(Main.resultScreen);
				mainWindow.add(Main.arithmeticMenu);
				mainWindow.validate();
				mainWindow.repaint();

			}
		});
		this.add(lblScore);
		this.add(btnConfirm);
	}

	public void getGivenQuestions(Question[] questions) {
		questionsThatWereAsked = questions;
		int score = 0;
		for (int i = 0; i < questions.length; i++) {
			if (questionsThatWereAsked[i].isAnsweredCorrectly()) {
				score++;
			}
		}
		lblScore.setText("Your final score is " + score + "/" + questionsThatWereAsked.length);
	}
}
