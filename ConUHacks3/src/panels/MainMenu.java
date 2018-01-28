package panels;

import java.awt.GridLayout;
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
	private JButton btnOption;

	public MainMenu(JFrame mainWindow) {
		this.mainWindow = mainWindow;
		this.lblMainMenu = new JLabel("Welcome to the Main Menu of our Math Educational Game!");
		this.lblMainMenu.setHorizontalAlignment(JLabel.CENTER);
		btnArithmetic = new JButton("Arithmetic");
		btnOption = new JButton("Options");
		this.setLayout(new GridLayout(3, 1));
		// this is adding the buttons
		this.add(lblMainMenu);
		this.add(btnArithmetic);
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