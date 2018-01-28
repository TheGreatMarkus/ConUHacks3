package panels;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import conuhacks3.Main;
import logic.Question;

public class GameScreen extends JPanel {

	private Question[] questionsToAsk;
	private JFrame mainWindow;

	private JLabel lblQuestion2;
	private JLabel lblQuestion1;
	private JButton btnSubmit;
	private JTextField txtInput;

	private int index;

	public GameScreen(JFrame mainWindow) {
		this.mainWindow = mainWindow;
		this.setLayout(new BorderLayout());

		JPanel pnlQuestions = new JPanel();
		JPanel pnlInput = new JPanel();
		this.lblQuestion2 = new JLabel();
		this.lblQuestion1 = new JLabel();
		this.btnSubmit = new JButton("Submit");
		this.txtInput = new JTextField(20);

		pnlQuestions.setLayout(new GridLayout(5, 1));
		this.lblQuestion1.setHorizontalAlignment(JLabel.CENTER);
		this.lblQuestion2.setHorizontalAlignment(JLabel.CENTER);

		this.btnSubmit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				answerSubmitted();
			}
		});
		this.txtInput.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				answerSubmitted();
			}
		});

		this.add(pnlQuestions, BorderLayout.CENTER);
		this.add(pnlInput, BorderLayout.SOUTH);

		pnlInput.add(txtInput);
		pnlInput.add(btnSubmit);

		pnlQuestions.add(lblQuestion2);
		pnlQuestions.add(lblQuestion1);
	}

	public void getQuestions(Question[] questions) {
		this.questionsToAsk = questions.clone();
		this.index = 0;
		lblQuestion1.setText(questionsToAsk[index].toString());
		lblQuestion2.setText("");

	}

	public void answerSubmitted() {

		boolean nfe = false;
		String a = txtInput.getText();
		txtInput.setText("");
		int answer = -1;
		try {
			answer = Integer.parseInt(a);
		} catch (NumberFormatException ex) {
			nfe = true;
		}
		int expectedAnswer = 0;
		switch (questionsToAsk[index].getMissingTerm()) {
		case TERM_1:
			expectedAnswer = questionsToAsk[index].getTerm1();
			break;
		case TERM_2:
			expectedAnswer = questionsToAsk[index].getTerm2();
			break;
		case RESULT:
			expectedAnswer = questionsToAsk[index].getResult();
			break;
		}
		if (nfe) {
			System.out.println("A NumberFormatException has occured. The answer was NaN");
			lblQuestion2.setText(
					lblQuestion1.getText() + " ; Wrong! That's not a number. The answer was " + expectedAnswer);
		} else if (answer == expectedAnswer) {
			System.out.println("The right answer was given");
			lblQuestion2.setText(lblQuestion1.getText() + " ; Right! : Your answer was " + answer);
			questionsToAsk[index].setAnsweredCorrectly(true);
		} else {
			System.out.println("The wrong answer was given");
			lblQuestion2.setText(lblQuestion1.getText() + " ; Wrong! The answer was : " + expectedAnswer);
		}
		if ((index + 1) <= questionsToAsk.length - 1) {
			lblQuestion1.setText(questionsToAsk[++index].toString());
		} else {
			System.out.println("Questions are over, going to the result screen");
			Main.resultScreen.getGivenQuestions(questionsToAsk.clone());
			mainWindow.remove(Main.gameScreen);
			mainWindow.add(Main.resultScreen);
			mainWindow.validate();
			mainWindow.repaint();

		}
	}

}
