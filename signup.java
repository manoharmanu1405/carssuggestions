package miniproject;
import javax.imageio.ImageIO;
import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.time.LocalDateTime;
import miniproject.*;
public class signup implements ActionListener, KeyListener, ItemListener 
{
	
	JTextField t4=new JTextField();
	JTextField t2=new JTextField();
	JTextField t1=new JTextField();
	JTextField em=new JTextField();
	JTextField t3=new JTextField();
	JPasswordField p=new JPasswordField();
	JLabel t9=new JLabel();JButton b;
	JPasswordField p1=new JPasswordField();boolean finalv;
	int count;JFrame f;boolean dobv,mobilenov,firstnamev,lastnamev,emailv,checkboxv,passwordv;
JCheckBox cb;
JLabel t8=new JLabel();  
JLabel dobr;
JLabel emailr;
JLabel mobilenor;
JLabel spr;
JLabel cpr,fr,lr;

public signup() throws IOException   
{ 
	
	fr=new JLabel("");
	fr.setForeground (Color.red);
	lr=new JLabel("");
	lr.setForeground (Color.red);
	dobr=new JLabel("");
	dobr.setForeground (Color.red);
	emailr=new JLabel("");
	emailr.setForeground (Color.red);
	mobilenor=new JLabel("");
	mobilenor.setForeground (Color.red);
	spr=new JLabel("");
	spr.setForeground (Color.red);
	cpr=new JLabel("");
	cpr.setForeground (Color.red);
f= new JFrame("SignUp Form");

//final BufferedImage img=new ImgUtils().scaleImage(800,600,"C:\\Users\\john\\Downloads\\trail.jpg");
//create label with image as background
//JLabel label=new JLabel(new ImageIcon((Image)img));
//f.setContentPane(label);
f.setContentPane(new JLabel(new ImageIcon("C:\\Users\\john\\Downloads\\home (1).jpg")));
JLabel l1,l2,l3;  
l1=new JLabel("Firstname");  
l1.setBounds(50,50, 100,30);  
l2=new JLabel("Lastname");  
l2.setBounds(50,100, 100,30);  
f.add(l1); f.add(l2);
l3=new JLabel("MobileNo.");  
l3.setBounds(50,250, 100,30);f.add(l3);

t3.setBounds(200,250,100,30);f.add(t3);
t3.addKeyListener(this);
mobilenor.setBounds(320,250,100,30);f.add(mobilenor);

t1.setBounds(200,50,100,30);
t1.addKeyListener(this);
fr.setBounds(320,50,100,30);f.add(fr);

t2.setBounds(200,100,100,30);
f.add(t1);f.add(t2); 
lr.setBounds(320,100,100,30);f.add(lr);
f.add(t1);
JLabel l4,l5;
l4=new JLabel("Email");  
l4.setBounds(50,200, 100,30);
f.add(l4);
l5=new JLabel("DOB(dd/mm/yyyy)");
l5.setBounds(50,150,100,30);f.add(l5);
t4.setBounds(200,150,100,30);f.add(t4);
dobr.setBounds(320,150,100,30);f.add(dobr);
t4.addKeyListener(this);

em.setBounds(200,200,100,30);
emailr.setBounds(320,200,100,30);f.add(emailr);
f.add(em);
em.addKeyListener(this);

p.setBounds(200,300,100,30);
p.addKeyListener(this);
f.add(p);
cpr.setBounds(320,350,400,30);f.add(cpr);
JLabel l6,l7;
l6=new JLabel("Set Password");
l6.setBounds(50,300,150,30);f.add(l6);
l7=new JLabel("Confirm Password");
l7.setBounds(50,350,150,30);f.add(l7);

p1.setBounds(200,350,100,30);
p1.addKeyListener(this);
f.add(p1);
cb= new JCheckBox("I agree to all terms and conditions");
cb.setOpaque(false);
cb.setBounds(50,400,400,30);
cb.addActionListener(this);
cb.addItemListener(this);
f.add(cb);
b = new JButton("submit");
b.setBounds(100,450,100,30);
f.add(b);
b.addActionListener(this);
t8.setBounds(10,500,300,30);f.add(t8);

t9.setBounds(10,530,300,30);f.add(t9);
Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
f.setSize(1108,600);
f.setLocationRelativeTo(null);






f.setLayout(null);  
f.setVisible(true);

}

    
    public void actionPerformed(ActionEvent e) {

 //storing values to database
 
String firstname=t1.getText();
 String lastname=t2.getText();
 String dob=t4.getText();
 String email=em.getText();
 String mobileno=t3.getText();
 char[] arr = p.getPassword(); 
String password = String.valueOf(arr);
 char[] arr1 = p1.getPassword(); 
String password1 = String.valueOf(arr1);


                                                     //email validation


if(e.getSource()==b) {





	EmailValidator emailValidator = new EmailValidator();
	if(emailValidator.validate(em.getText().trim())) {                             
	     System.out.println("valid Email ID");
	     emailv=true;
	     emailr.setText("");
	     
	}
	else {
		System.out.println("Invalid Email");
		emailv=false;
		
		emailr.setText("!Invalid");
	}
	
    //dateofbirth validation
String str;
str = t4.getText();
SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
sdf.setLenient(false);
try {
Date d1 = sdf.parse(str);
System.out.println("date of birth valid");
dobr.setText("");
dobv=true;
} catch (Exception e1) {
System.out.println("invalid date of birth");
dobr.setText("!Invalid");
dobv=false;

}



/*if(firstName(t1.getText())) {
	firstnamev=true;
	
}
else {
	firstnamev=false;
	fr.setText("!Invalid");
}
if(lastName(t2.getText())) {
	lastnamev=true;
}
else {
	lastnamev=false;
	lr.setText("!Invalid");
}  */












if(password.equals(password1)) {                                          //  password validation
	if(password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$"))
    {
	//	^                 # start-of-string
	//	(?=.*[0-9])       # a digit must occur at least once
	//	(?=.*[a-z])       # a lower case letter must occur at least once
	//	(?=.*[A-Z])       # an upper case letter must occur at least once
	//	(?=.*[@#$%^&+=])  # a special character must occur at least once
	//	(?=\S+$)          # no whitespace allowed in the entire string
	//	.{8,}             # anything, at least eight places though
	//	$                 # end-of-string
		
		
		
		
             passwordv=true;
             cpr.setText("");
    }
    else
    {
                 passwordv=false;
                 cpr.setText("should contain at least a digit and special character(@,#,$) and length of 8");
    }
	
}
else {
	System.out.println("Passwords doesnot match");
	passwordv=false;
	
	cpr.setText("!Not Matched");
}

if(isValidMobileNo(t3.getText()))
{
	System.out.print("mobile no valid");
	mobilenov=true;
}
else {
	mobilenov=false;
	
	mobilenor.setText("!Invalid");
}







	if(checkboxv) {
		
			
			
			
			Connection con=databasecnct.con();
	    	  Statement statement = null;
	    		
	    		ResultSet resultSet=null;
	    		try {
					statement=con.createStatement();
					String sql ="select * from signup where mobileno='"+mobileno+"'";
		    		 
		    		 resultSet = statement.executeQuery(sql);
		    			
		    			if(resultSet.next()) {
		    				System.out.println("signup success");
		    				JOptionPane.showMessageDialog(null,"Account already exists with this mobile number\n"+"You can login instead by closing this window","Error",JOptionPane.ERROR_MESSAGE);
		    			    finalv = false;
		    			}
		    			
		    			else
		    			{
		    				finalv=true;
		    			}
			
	    		} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
	    		if(mobilenov && emailv && passwordv && dobv && finalv) {
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			System.out.print("authenticated");
			Connection con1=databasecnct.con();
			try{

				 PreparedStatement p=con1.prepareStatement("insert into signup(firstname,lastname,dob,email,mobileno,password)values(?,?,?,?,?,?)");
				 
				 p.setString(1,firstname);
				 p.setString(2,lastname);
				 p.setString(3,dob);
				 p.setString(4,email);
				 p.setString(5,mobileno);
				 p.setString(6,password);
				 
				 int i=p.executeUpdate();  
				 System.out.println(i+" records inserted"); 
				 con1.close();

				 } catch (Exception e1) {
				 e1.printStackTrace();
				 }

			f.dispatchEvent(new WindowEvent(f, WindowEvent.WINDOW_CLOSING));
			new acccreate();
			
			
			
			
		}
		
		
		
		
		
		
	}
	else {
		JOptionPane.showMessageDialog(f, "Checkbox not Checked");
	}
	
	
	
}
















 

 
   
    
    }  

    public static void main(String args[]) throws IOException{
      new signup();
    }


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==t1) {                                                       //firstname validation
	    int max = 16;
	    if(t1.getText().length() > max+1) {
	        e.consume();
	        String shortened = t1.getText().substring(0, max);
	        t1.setText(shortened);
	    }else if(t1.getText().length() > max) {
	        e.consume();
	        JOptionPane.showMessageDialog(f, "firstname can only be max 16 letters");
	    }
	}
		
		if(e.getSource()==t2) {                                                       //lastname validation
		    int max = 16;
		    if(t2.getText().length() > max+1) {
		        e.consume();
		        String shortened = t2.getText().substring(0, max);
		        t2.setText(shortened);
		    }else if(t2.getText().length() > max) {
		        e.consume();
		        JOptionPane.showMessageDialog(f, "firstname can only be max 16 letters");
		    }
		}

		

		
		
		
	
	}


	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==p) {
			
			cpr.setText("");
		}
		if(e.getSource()==p1) {
			
			cpr.setText("");
		}
		if(e.getSource()==t3) {
			
			mobilenor.setText("");
		}
		if(e.getSource()==t4) {
			
			dobr.setText("");
		}
		if( e.getSource()==em) {
			
			emailr.setText("");
		}
if( e.getSource()==t1) {
			
			fr.setText("");
		}
if( e.getSource()==t2) {
	
	lr.setText("");
}
 
        
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		 if (e.getSource() == cb) {
	            if (e.getStateChange() == 1) {
	            	checkboxv=true;
	            }
	                
	            else {
	            	checkboxv=false;
	            }
	                
	        }
	}

	public static boolean isValidMobileNo(String str)  
	{  
	//(0/91): number starts with (0/91)  
	//[7-9]: starting of the number may contain a digit between 0 to 9  
	//[0-9]: then contains digits 0 to 9  
	Pattern ptrn = Pattern.compile("(0/91)?[6-9][0-9]{9}");  
	//the matcher() method creates a matcher that will match the given input against this pattern  
	Matcher match = ptrn.matcher(str);  
	//returns a boolean value  
	return (match.find() && match.group().equals(str));  
	}  
	   // validate first name
	/*   public static boolean firstName( String firstName ) {
	      return firstName.matches( "[A-Z][a-z]*" );
	   }
	   // validate last name
	   public static boolean lastName( String lastName ) {
	      return lastName.matches( "[A-Z]+([ '-][a-zA-Z]+)*" );
	   }            */
	 
	
	
	
	
	
  
}  







