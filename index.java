
package miniproject;
import java.awt.event.*;
import java.io.IOException;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import miniproject.*;

public class index implements ActionListener {
	JButton in,up,b;JFrame j;public static boolean skip;
	public index() {
		j=new JFrame("Home Page");
		JLabel q=new JLabel("BUYING CAR HAS NEVER BEEN EASY");
		q.setBounds(40,120,300,60);
		JLabel q1=new JLabel("BUT NOT NOW");
		q1.setBounds(260,120,300,60);
		JLabel q2=new JLabel("BECAUSE WE MADE IT EASY FOR YOU");
		q2.setBounds(85,160,300,60);
		//j.setContentPane(new JLabel(new ImageIcon("C:\\Users\\john\\Downloads\\home.jpg")));
		up=new JButton("signup");
		up.setBounds(40,30,75,30);
		up.addActionListener(this);
		in=new JButton("login");
		in.setBounds(285,30,75,30);
		in.addActionListener(this);
		
		b=new JButton("Skip Signin");
		b.addActionListener(this);
		b.setBounds(150,300,100,30);
		JLabel l=new JLabel(" ");
		l.setBounds(300,300,10,10);
        j.add(q1);
        j.add(q2);
		j.add(q);
		j.add(in);
		j.add(up);
		j.add(b);
		j.add(l);

		j.setVisible(true);
		j.setSize(400,400);
		j.setLayout(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==in) {
			new signin();
			
		}
		if(e.getSource()==up) {
			try {
				new signup();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		if(e.getSource()==b) {
			new home();
			skip=true;
			
		}
		
	}
	public static void main(String args[]){

		new index();


		}
}
