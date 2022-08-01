package miniproject;

import javax.swing.*;


public class nocarsfound {
public nocarsfound() {
	JFrame f=new JFrame("No Cars Found");
	JLabel l=new JLabel("No Cars Found");
	JLabel l1=new JLabel("Try adding different filters");
	l1.setBounds(70,130,150,30);
	l.setBounds(100,100,100,30);
	f.setSize(300,300);
	f.setVisible(true);
	f.setLayout(null);
	f.add(l);
	f.add(l1);
}
}
