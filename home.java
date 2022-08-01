package miniproject;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.font.TextAttribute;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import miniproject.*;

public class home implements ActionListener, MouseListener {
	JButton b,b1;JLabel f;JFrame j;
	
	public home() {
		j=new JFrame("Main Page");
		f=new JLabel("Favourites");
		Font font = f.getFont();
		Map<TextAttribute, Object> attributes = new HashMap<>(font.getAttributes());
		attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		f.setFont(font.deriveFont(attributes));
		f.setBounds(275,20,85,30);
		f.addMouseListener(this);
		j.add(f);
		JLabel q=new JLabel("JUST TWO STEPS");
		q.setBounds(140,70,130,60);
		JLabel q1=new JLabel("Decide your Budjet");
		q1.setBounds(40,120,130,60);
		JLabel q2=new JLabel("Select your Specs");
		q2.setBounds(200,120,130,60);
		//j.setContentPane(new JLabel(new ImageIcon("C:\\Users\\john\\Downloads\\home.jpg")));
		b=new JButton("Budjet");
		b.setFont(new Font("Arial", Font.PLAIN,12));
		b1=new JButton("Specs");
		b.setBounds(60,250,80,30);
		b.addActionListener(this);
		b1.setFont(new Font("Arial", Font.PLAIN,12));
		b1.setBounds(220,250,80,30);
		b1.addActionListener(this);
		JLabel r=new JLabel("");
		r.setBounds(300,390,10,10);
		j.add(q);
		j.add(q1);
		j.add(q2);
		j.add(b);
		j.add(b1);
		j.add(r);
	
		
	    j.setSize(400,400);
	    j.setVisible(true);
	    j.setLayout(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b) {
			new slider();
			
		}
		if(e.getSource()==b1) {
			new specsheet();
			
		}
	}


	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	//	new favourites();
		if(signin.signin) {
		new favproccessing();
		}
		else
		{
			JOptionPane.showMessageDialog(j, "You should signin to to use this feature");	
		}
		}
		
		
		
		
		
		
	
		
		


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	



		}	


