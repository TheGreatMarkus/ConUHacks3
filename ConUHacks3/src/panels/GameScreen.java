package panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import logic.Question;

public class GameScreen extends JPanel {

	private Question[] questionsToAsk;
	private JFrame mainWindow;

	private JLabel lblQuestion;
	private JButton btnSubmit;
	private JTextField txtInput;

	private int index;

	public GameScreen(JFrame mainWindow) {
		this.mainWindow = mainWindow;
		this.index = 0;
		this.lblQuestion = new JLabel();
		this.btnSubmit = new JButton("Submit");
		this.txtInput = new JTextField(20);
		this.btnSubmit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				index++;
				lblQuestion.setText(questionsToAsk[index].toString());

			}
		});
		this.add(lblQuestion);
		this.add(txtInput);
		this.add(btnSubmit);

	}

	public void getQuestion(Question[] questions) {
		this.questionsToAsk = questions.clone();
		lblQuestion.setText(questionsToAsk[index].toString());

	}

}
