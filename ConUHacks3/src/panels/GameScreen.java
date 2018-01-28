package panels;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
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
		// This only work for the gamemode "Find the result". more code to
		// check the missing term must be added to function with the other modes
		if (nfe) {
			System.out.println("A NumberFormatException has occured. The answer was NaN");
			lblQuestion2.setText(lblQuestion1.getText() + " ; Wrong Answer, NaN");
		} else if (answer == questionsToAsk[index].getResult()) {
			System.out.println("The right answer was given");
			lblQuestion2.setText(lblQuestion1.getText() + " ; Right! : " + answer);
			questionsToAsk[index].setAnsweredCorrectly(true);
		} else {
			System.out.println("The wrong answer was given");
			lblQuestion2.setText(
					lblQuestion1.getText() + " ; Wrong! The answer was : " + questionsToAsk[index].getResult());
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
