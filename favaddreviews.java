package miniproject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class favaddreviews implements ActionListener, KeyListener {
	JButton b;JTextArea review;Statement statement=null;ResultSet resultSet=null;
	Connection con=databasecnct.con();Connection con1=databasecnct.con();
	  int r=0;Statement statement1=null;ResultSet resultSet1=null;
	  JFrame f;
public favaddreviews(){
	String text=favreviews.b.getText();
	if(text.equals("Add review")) {
	f=new JFrame("Add your review");
	JLabel l=new JLabel();
	l.setBounds(20,5,250,20);
	l.setText("Say us something about this car");
	b=new JButton("Submit Review");
	b.setBounds(150,180,100,30);
	b.addActionListener(this);
    review = new JTextArea();
    review.setLineWrap(true);
	review.setWrapStyleWord(true);
	review.setBounds(20,30,320,140);
	review.addKeyListener(this);
	f.add(l);
	f.add(review);
	f.add(b);
	f.setSize(400,250);
	f.setLayout(null);
	f.setVisible(true);
	
	
	
	
	

	
	
	
	
	
	
}
else
{
	
	f=new JFrame("Update review");
	JLabel l=new JLabel();
	l.setBounds(20,5,250,20);
	l.setText("Update your review about this car");
	b=new JButton("Update Review");
	b.setBounds(150,180,100,30);
	b.addActionListener(this);
    review = new JTextArea();
    
    review.setText(favreviews.myreview);
    review.setLineWrap(true);
	review.setWrapStyleWord(true);
	review.setBounds(20,30,320,140);
	review.addKeyListener(this);
	f.add(l);
	f.add(review);
	f.add(b);
	f.setSize(400,250);
	f.setLayout(null);
	f.setVisible(true);
	
	
}}
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	String rev=review.getText();
	System.out.println(rev);
	
	try {
		
		statement=con.createStatement();
		String sql ="select * from cardata where id="+favourites.a[favourites.fa];
		
		resultSet = statement.executeQuery(sql);
		if(b.getText().equals("Submit Review")) {
			
			
			statement1=con1.createStatement();
			String sql1="select * from reviews where mobileno='"+signin.mobileno+"'";
			resultSet1=statement1.executeQuery(sql1);
			if(resultSet1.next()) {
				PreparedStatement p=con.prepareStatement("UPDATE reviews SET `"+favourites.a[favourites.fa]+"` = '"+rev+"' WHERE mobileno = '"+signin.mobileno+"'");
				int i=p.executeUpdate(); 
				System.out.println(i+" record added to reviews"); 
			}
			
			
			
			else {PreparedStatement p=con.prepareStatement("INSERT INTO reviews (`"+favourites.a[favourites.fa]+"`,mobileno) VALUES('"+rev+"',"+signin.mobileno+")");
			int i=p.executeUpdate();
			System.out.println(i+" record added to reviews"); 
			}
			 
			 
			 
			 
			 
			 
			 
			 JOptionPane.showMessageDialog(f, "Review added successfully");
			 con.close();
			 f.dispatchEvent(new WindowEvent(f, WindowEvent.WINDOW_CLOSING));
			 new favreviews();
			 
			
		}
		else {
			 PreparedStatement p=con.prepareStatement("UPDATE reviews SET `"+favourites.a[favourites.fa]+"` = '"+rev+"' WHERE mobileno = '"+signin.mobileno+"'");
			 int i=p.executeUpdate();  
			 System.out.println(i+" record added to reviews"); 
			 JOptionPane.showMessageDialog(f, "Review updated successfully");
			 con.close();
			 f.dispatchEvent(new WindowEvent(f, WindowEvent.WINDOW_CLOSING));
			 new favreviews();
			
		}
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
}


public void keyTyped(KeyEvent e) {
    int max = 300;
    if(review.getText().length() > max+1) {
        e.consume();
        String shortened = review.getText().substring(0, max);
        review.setText(shortened);
    }else if(review.getText().length() > max) {
        e.consume();
    }
}
@Override
public void keyPressed(KeyEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
	
}

}
