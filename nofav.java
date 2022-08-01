package miniproject;

import javax.swing.*;


public class nofav {
public nofav() {
	JFrame f=new JFrame("No  favourites");
	JLabel l=new JLabel("No favourites");
	JLabel l1=new JLabel("Go through our app to add");
	l1.setBounds(70,130,150,30);
	l.setBounds(100,100,100,30);
	f.setSize(300,300);
	f.setVisible(true);
	f.setLayout(null);
	f.add(l);
	f.add(l1);
}




}

