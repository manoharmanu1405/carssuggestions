package miniproject;
// java Program to create a slider with min and
// max value and major and minor ticks painted.
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.*;
 public class slider extends JFrame implements ChangeListener, ActionListener {
public static float cost;
	// frame
	static JFrame f;

	// slider
	static JSlider b;

	// label
	static JLabel l;
	

	// main class
	public slider()
	{
		// create a new frame
		f = new JFrame("cost slider");
		

		// create a object
		

		// create label
		l = new JLabel();

		// create a panel
		JPanel p = new JPanel();
		

		// create a slider
		b = new JSlider(0, 50, 12);

		// paint the ticks and tracks
		b.setPaintTrack(true);
		b.setPaintTicks(true);
		b.setPaintLabels(true);

		// set spacing
		b.setMajorTickSpacing(10);
		b.setMinorTickSpacing(5);

		// setChangeListener
		b.addChangeListener(this);
		JButton n=new JButton("done");
		n.addActionListener(this);
		

		// add slider to panel
		p.add(b);
		p.add(l);
		p.add(n);
		

		f.add(p);

		// set the text of label
		l.setText("Budget of car is =" + b.getValue()+" lakhs");

		// set the size of frame
		f.setSize(300,150);

		f.show();
	}

	// if JSlider value is changed
	public void stateChanged(ChangeEvent e)
	{
		l.setText("Budget of car is =" + b.getValue()+" lakhs");
	/*	if(password.equals(password1)){
			

			Connection con=databasecnct.con();
			try{

				 PreparedStatement p=con.prepareStatement("insert into signup(firstname,lastname,dob,email,mobileno,password)values(?,?,?,?,?,?)");
				 
				 p.setString(1,firstname);
				 p.setString(2,lastname);
				 p.setString(3,dob);
				 p.setString(4,email);
				 p.setString(5,mobileno);
				 p.setString(6,password);
				 
				 int i=p.executeUpdate();  
				 System.out.println(i+" records inserted"); 
				 con.close();

				 } catch (Exception e1) {
				 e1.printStackTrace();
				 }
			f.dispatchEvent(new WindowEvent(f, WindowEvent.WINDOW_CLOSING));
			signin s=new signin();

			}   */

		
	}

public static void main(String args[]){

new slider();


}

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	f.dispatchEvent(new WindowEvent(f, WindowEvent.WINDOW_CLOSING));
	cost=b.getValue();
	System.out.println(cost);
	
	
}



}
