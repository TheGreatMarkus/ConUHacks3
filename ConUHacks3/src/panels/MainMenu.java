package panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import conuhacks3.Main;

public class MainMenu extends JPanel {

	private JFrame mainWindow;

	private JLabel lblMainMenu;
	private JButton btnArithmetic;
	private JButton btnSomething;
	private JButton btnOption;

	public MainMenu(JFrame mainWindow) {
		this.mainWindow = mainWindow;
		this.lblMainMenu = new JLabel("Main Menu Text");
		btnArithmetic = new JButton("Arithmetic");
		// Possible topic if we can get it done in time.
		btnSomething = new JButton("Optional Topic");
		btnOption = new JButton("Options");

		// this is adding the buttons
		this.add(btnArithmetic);
		this.add(btnSomething);
		this.add(btnOption);
		// positioning
		// functioning
		btnArithmetic.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainWindow.remove(Main.mainMenu);
				mainWindow.add(Main.arithmeticMenu);
				mainWindow.validate();
				mainWindow.repaint();
			}
		});

	}
}