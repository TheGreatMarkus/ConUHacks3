package panels;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import conuhacks3.Main;

public class ArithmeticMenu extends JPanel {
	
	 private JFrame mainWindow;




	public ArithmeticMenu(JFrame mainWindow) {
		this.mainWindow = mainWindow;
		Object[] topic = new String[]{"Additaion","subtaction","multipication","dividation"};
		Object[] level = new String[]{"easy","medium","differcult"};
        final JComboBox topicdrop = new JComboBox(topic);
        JComboBox  difficultydrop  = new JComboBox  (level);
       
        this.add(topicdrop);
        this.add(difficultydrop);
        
        
        
        
	}
}
