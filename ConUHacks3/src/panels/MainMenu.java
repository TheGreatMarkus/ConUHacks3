package panels;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import conuhacks3.Main;

public class MainMenu extends JPanel {
	
	private JFrame mainWindow;
	

	private JButton ArithmaticButton;
	private JButton SomethingButton;
	private JButton OptionButton;

	public MainMenu(JFrame mainWindow) {
		this.mainWindow = mainWindow;
		ArithmaticButton = new JButton("Arithmatic");
		SomethingButton =new JButton("       ");
		
		OptionButton = new JButton("Option");
		
		//this is adding the buttons
		;
		this.add(ArithmaticButton);
		this.add(SomethingButton);
		this.add(OptionButton);
		// positioning
		//functioning
		ArithmaticButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainWindow.remove(Main.mainMenu);
				mainWindow.add(Main.arithmeticMenu);
				mainWindow.invalidate();
				mainWindow.repaint();
				mainWindow.revalidate();
			}
		});
		
		
		
		
		
	}
}