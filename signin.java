package miniproject;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import miniproject.*;
import javax.swing.*;
public class signin implements ActionListener{

public static String mobileno;
public static boolean signin;
JTextField tf1=new JTextField();
JPasswordField tf2=new JPasswordField();
JFrame f;
public signin(){
f=new JFrame("Signin Form");

JButton b= new JButton("SUBMIT");
b.setBounds(85,165,90,30);f.add(b);
b.addActionListener(this);
JLabel l1=new JLabel("Mobile No.");
l1.setBounds(20,40,80,30);
f.add(l1);
JLabel l2=new JLabel("Password:");
l2.setBounds(20,100,80,30);f.add(l2);
tf1.setBounds(120,40,100,30);f.add(tf1);
tf2.setBounds(120,100,100,30);f.add(tf2);
JLabel l3=new JLabel("");
l3.setBounds(10,70,80,30);f.add(l3);

f.setSize(250,250);
f.setVisible(true);
f.setLayout(null);



}
    public void actionPerformed(ActionEvent e){ 
    	 
    	
    	String us=tf1.getText();
    	
    	 char[] arr = tf2.getPassword(); 
    	 String ps = String.valueOf(arr);
    	 Connection con=databasecnct.con();
    	  Statement statement = null;
    		
    		ResultSet resultSet=null;
    		try {
				statement=con.createStatement();
				String sql ="select * from signup where mobileno='"+us+"' and password='"+ps+"'";
	    		 
	    		 resultSet = statement.executeQuery(sql);
	    			
	    			if(resultSet.next()) {
	    				System.out.println("signin success");
	    				f.dispatchEvent(new WindowEvent(f, WindowEvent.WINDOW_CLOSING));
	    				new home();	
	    			signin=true;
	    			mobileno=us;
	    			}
	    			
	    			else
	    			{
	    				System.out.println("username or password incorrect");
	    				JOptionPane.showMessageDialog(null,"UserName or Password incorrect","Error",JOptionPane.ERROR_MESSAGE);
	    			}
	    		
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}  
    		
    		
    }  
public static void main(String args[])
{ new signin();  }
}