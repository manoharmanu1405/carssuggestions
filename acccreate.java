package miniproject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class acccreate implements ActionListener {
	public acccreate(){
		JFrame f=new JFrame();
		JLabel l=new JLabel();
		l.setBounds(120,100,200,30);
		f.add(l);
		JLabel l2=new JLabel();
		l2.setBounds(140,150,200,30);
		f.add(l2);
		l.setText("Account Created successfully");
		l2.setText("You can login now");
		JLabel lr=new JLabel("");
		lr.setBounds(300,300,10,10);
		f.add(lr);
		f.setSize(400,400);
		f.setVisible(true);
		f.setLayout(null);
		JButton b=new JButton("Login");
		b.setBounds(170,300,80,30);
		f.add(b);
		b.addActionListener(this);
		
	}
	
	
	
	 public void actionPerformed(ActionEvent e){ 
		 new signin();
	 }
	
	

}
