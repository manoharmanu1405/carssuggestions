package miniproject;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.font.TextAttribute;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.*;
import miniproject.*;
public class carimage implements ActionListener, MouseListener {
	 
	 
	JLabel label2,label14,label11,label12,label13,label15,label16,label18,label,h;
	JButton fav;
	ImageIcon icon;
	JButton next,prev,more,reviews;JFrame frame;
	 
	 String s_cap="5";
	 String bootspace="405";
	  
	String fuel="petrol";
	String  btype="SUV";
	String cost="Rs. 5.64 - 10.08 Lakh";
	public static int[] a=specprocessing.intArray;
	  int r=0;
	  public static int fa;
	 JLabel tr;
	
   Statement statement = null;
	
	ResultSet resultSet=null;
	Connection con=databasecnct.con();
	
 public carimage() {
	 if(specprocessing.f==1) {
	 tr=new JLabel(String.valueOf(specprocessing.f)+" result");}
	 if(specprocessing.f!=1) {
	 tr=new JLabel(String.valueOf(specprocessing.f)+" results");}
	 frame = new JFrame();
		h=new JLabel("Home");
		Font font = h.getFont();
		Map<TextAttribute, Object> attributes = new HashMap<>(font.getAttributes());
		attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		h.setFont(font.deriveFont(attributes));
		h.setBounds(40,90,85,30);
		tr.setBounds(710,10,50,30);
		frame.add(tr);
		h.addMouseListener(this);
	 frame.add(h);

	try{

		
		
		statement=con.createStatement();
		String sql ="select * from cardata where id="+a[r];
		fa=r;
		
		
		 
		 resultSet = statement.executeQuery(sql);
			
			resultSet.next();
			
		 
		 
			String carname = resultSet.getString("car");
			 label2=new JLabel(carname);                                           //carname
			 label2.setBounds(300,320,400,80);
			 label2.setFont(new Font("Serif", Font.BOLD, 36));
			 frame.add(label2);
			  
			  
	        String cc=resultSet.getString("cc");
	        label14 = new JLabel(cc);                                                    //cc
	        label14.setBounds(280,540,100,40);
	        label14.setFont(new Font("Calibri", Font.PLAIN, 18));
	        frame.add(label14);
	        
	        String mileage=resultSet.getString("arai_milage");
	        label11 = new JLabel(mileage);                                              //milg
	        label11.setBounds(280,450,100,40);
	        label11.setFont(new Font("Calibri", Font.PLAIN, 18));
	        frame.add(label11);
	        
	        String s_cap=resultSet.getString("seating_cap");
	        label12 = new JLabel(s_cap);                                                   //scap
	        label12.setBounds(280,480,100,40);
	        label12.setFont(new Font("Calibri", Font.PLAIN, 18));
	        frame.add(label12);
	        
	        String bootspace=resultSet.getString("bootspace");
	        label13 = new JLabel(bootspace);                                                 //bootspace
	        label13.setBounds(280,510,100,40);
	        label13.setFont(new Font("Calibri", Font.PLAIN, 18));
		    frame.add(label13);
		    
		    String cost=resultSet.getString("cost");
		    label18 = new JLabel(cost);                                             //cost
		    label18.setBounds(280,630,200,40);
		    label18.setFont(new Font("Calibri", Font.PLAIN, 18));
		    frame.add(label18);
		    
		    
		    
		    String imagepath=resultSet.getString("imagepath");
		    icon = new ImageIcon(imagepath);
		    label = new JLabel(icon);
		    label.setBounds(200,100,400,216);                                             //carimages
		    frame.add(label);
		    
		    
		    
		    
		    String btype=resultSet.getString("btype");
		    label16 = new JLabel(btype);                                                    //btype
		    label16.setBounds(280,600,100,40);
		    label16.setFont(new Font("Calibri", Font.PLAIN, 18));
		    frame.add(label16);
		    
		    String fuel=resultSet.getString("fuel");
		    label15 = new JLabel(fuel);                                                  //fuel
		    label15.setBounds(280,570,100,40);
		    label15.setFont(new Font("Calibri", Font.PLAIN, 18));
		    frame.add(label15);                 
		    
	
	} catch (Exception e1) {
		 e1.printStackTrace();
		 }
	



  
  
  JLabel label3 = new JLabel("Specs:");                                 
  label3.setBounds(40,380,200,40);
  label3.setFont(new Font("Serif", Font.ITALIC, 28));
  
  
  JLabel label5 = new JLabel("ARAI Mileage :");
  label5.setBounds(40,450,150,40);
  label5.setFont(new Font("Calibri", Font.PLAIN, 18));
  
  
  JLabel label6 = new JLabel("Seating Capacity :");
  label6.setBounds(40,480,150,40);
  label6.setFont(new Font("Calibri", Font.PLAIN, 18));
  
  
  JLabel label7 = new JLabel("BootSpace :");
  label7.setBounds(40,510,100,40);
  label7.setFont(new Font("Calibri", Font.PLAIN, 18));
  
  
  JLabel label8 = new JLabel("Engine Displacement (cc) :");
  label8.setBounds(40,540,200,40);
  label8.setFont(new Font("Calibri", Font.PLAIN, 18));
  
  
  JLabel label9 = new JLabel("Fuel Type :");
  label9.setBounds(40,570,100,40);
  label9.setFont(new Font("Calibri", Font.PLAIN, 18));
  
  
  JLabel label10 = new JLabel("Body Type :");
  label10.setBounds(40,600,100,40);
  label10.setFont(new Font("Calibri", Font.PLAIN, 18));
  
  

  

  

  

  

  

  
  
  more= new JButton("MOREINFO");
  more.setBounds(355,700,100,30);frame.add(more);
  more.addActionListener(this);
  
  prev= new JButton("previous");
  prev.setBounds(40,700,85,30);frame.add(prev);
  prev.addActionListener(this);
  
  
  next= new JButton("next");
  next.setBounds(680,700,85,30);frame.add(next);
  next.addActionListener(this);
  
  JLabel label17 = new JLabel("Price(Delhi Ex-Showroom) :");            
  label17.setBounds(40,630,230,40);
  label17.setFont(new Font("Calibri", Font.PLAIN, 18));
  
  reviews = new JButton("reviews");
  reviews.setBounds(680,450,85,30);
frame.add(reviews);
reviews.addActionListener(this);

 
  Icon icon = new ImageIcon("C:\\Users\\john\\Documents\\images\\fav.jpg");
  fav=new JButton(icon);
  
  fav.setBounds(720,100,45,45);
  frame.add(fav);
  fav.addActionListener(this);
  
  

	
  
 
  
  
  JLabel label4 = new JLabel("");
  
  
  frame.add(label17);

  frame.add(label10);
  frame.add(label6);
  frame.add(label7);
  frame.add(label9);
  frame.add(label8); 
  
  
  frame.add(label3);
  frame.add(label5);
 
 

 
  frame.add(label4);
 
  frame.setSize(800,800);

  frame.setVisible(true);
  

  
 
 
 }

public static void main(String args[]) {
	 new carimage();
	 

 }


public void actionPerformed(ActionEvent e) {
	
	
	if(e.getSource()==fav) {
		
		
		if(signin.signin) {
			

			try {
				statement =con.createStatement();
				String j = String.valueOf(a[r]);
				String sql="SELECT * FROM favourites WHERE (mobileno='"+signin.mobileno+"' and id='"+j+"')";
				resultSet = statement.executeQuery(sql);
				if(resultSet.next()) {
					
					int result = JOptionPane.showConfirmDialog(frame, "This item already exists in your favourites\n"
						    + "Do you want to delete it instead", "Confirm",
				               JOptionPane.YES_NO_OPTION,
				               JOptionPane.QUESTION_MESSAGE);
				            if(result == JOptionPane.YES_OPTION){
				            	Connection con=databasecnct.con();
			        			try{
			        				String j1 = String.valueOf(a[r]);
			        				fa=r;
			        				String mobileno1=signin.mobileno;
			        				 PreparedStatement p=con.prepareStatement("delete from favourites where id='"+j1+"' and mobileno='"+mobileno1+"'");
			        				 int i=p.executeUpdate();  
			        				 System.out.println(i+" record removed from fav"); 
			        				 con.close();
			        				 JOptionPane.showMessageDialog(frame, "Item successfully removed from favourites");
			        				 
			        				 
			        				 } catch (Exception e1) {
			        				 e1.printStackTrace();
			        				 }
					
					
					
					
					
				}}
				
				
				
				else {
					int result = JOptionPane.showConfirmDialog(frame,"Add to favorites", "Confirm",
				               JOptionPane.YES_NO_OPTION,
				               JOptionPane.QUESTION_MESSAGE);
				            if(result == JOptionPane.YES_OPTION){
					Connection con=databasecnct.con();
					try{
						String j1 = String.valueOf(a[r]);
						
						fa=r;
						String mobileno1=signin.mobileno;
						 PreparedStatement p=con.prepareStatement("insert into favourites(mobileno,id)values(?,?)");
						 
						 p.setString(1,mobileno1);
						 p.setString(2,j1);

						 
						 int i=p.executeUpdate();  
						 System.out.println(i+" records inserted to fav"); 
						 JOptionPane.showMessageDialog(frame, "Item successfully added to favourites");
						 
						 con.close();

						 } catch (Exception e1) {
						 e1.printStackTrace();
						 }
					
					
				}
				}
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
			
			
			
			
			
			
			
			
			
			
			
			

}
		else {
			System.out.print("user not signed in");
			JOptionPane.showMessageDialog(frame, "You should signin to to use this feature");
		}
   		
	}
	
	
	
	
	
	
	
	
	if(e.getSource()==next) {
	
	
	
try{


		r++;
		if (r+1>specprocessing.f)
		{
			JOptionPane.showMessageDialog(frame, "End of cars");
			r--;
		}
		else 
		{
		statement=con.createStatement();
		
		String sql ="select * from cardata where id=" +a[r] ;
		fa=r;
		System.out.println(a[r]+"2nd iteration value");
		
		
		 
		 resultSet = statement.executeQuery(sql);
		 
			
			if(resultSet.next()) {
			
		 
		 
			String carname = resultSet.getString("car"); 
			System.out.print(carname);                                           //carname
			label2.setText(carname);
			
			
			String cc=resultSet.getString("cc");
			System.out.print(cc);
			label14.setText(cc);                                                      //cc
			 
			
			String mileage=resultSet.getString("arai_milage");
			System.out.print(mileage);                                                    //mileage
			label11.setText(mileage);
			  
			String s_cap=resultSet.getString("seating_cap");
			System.out.print(s_cap);                                                    //mileage
			label12.setText(s_cap);
			
			String bootspace=resultSet.getString("bootspace");
			System.out.print(bootspace);                                                    //mileage
			label13.setText(bootspace);
			
			String fuel=resultSet.getString("fuel");
			System.out.print(fuel);                                                    //fuel
			label15.setText(fuel);
			
			String btype=resultSet.getString("btype");
			System.out.print(btype);                                                    //btype
			label16.setText(btype);
			
			String cost=resultSet.getString("cost");
			System.out.print(cost);                                                    //cost
			label18.setText(cost);
			
			String imagepath=resultSet.getString("imagepath");
			                                                    
			
			
			icon = new ImageIcon(imagepath);
		    label.setIcon(icon);
		    
		    
		    
		}
	
		  
	
}	} catch (Exception e1) {
		 e1.printStackTrace();
		 }      }
	
	
	
	
	
	if(e.getSource()==prev) {
		
		
		
		try{
			
				
				r--;
				if (r<0)
				{
					JOptionPane.showMessageDialog(frame, "Starting of cars");
					r++;
				}
				statement=con.createStatement();
				
				String sql ="select * from cardata where id=" +a[r] ;
				fa=r;
				
				 
				 resultSet = statement.executeQuery(sql);
				 
					
					if(resultSet.next()) {
					
				 
				 
					String carname = resultSet.getString("car"); 
					System.out.print(carname);                                           //carname
					label2.setText(carname);
					
					
					String cc=resultSet.getString("cc");
					System.out.print(cc);
					label14.setText(cc);                                                      //cc
					 
					
					String mileage=resultSet.getString("arai_milage");
					System.out.print(mileage);                                                    //mileage
					label11.setText(mileage);
					  
					String s_cap=resultSet.getString("seating_cap");
					System.out.print(s_cap);                                                    //mileage
					label12.setText(s_cap);
					
					String bootspace=resultSet.getString("bootspace");
					System.out.print(bootspace);                                                    //mileage
					label13.setText(bootspace);
					
					String fuel=resultSet.getString("fuel");
					System.out.print(fuel);                                                    //fuel
					label15.setText(fuel);
					
					String btype=resultSet.getString("btype");
					System.out.print(btype);                                                    //btype
					label16.setText(btype);
					
					String cost=resultSet.getString("cost");
					System.out.print(cost);                                                    //cost
					label18.setText(cost);
					
					String imagepath=resultSet.getString("imagepath");
					                                                    
					
					
					icon = new ImageIcon(imagepath);
				    label.setIcon(icon);
					 
					}
			
				  
			
			} catch (Exception e1) {
				 e1.printStackTrace();
				 }      }

	
	if(e.getSource()==more) {
		try {
			statement=con.createStatement();
			String sql ="select * from cardata where id=" +a[r] ;
			fa=r;
			 
			 resultSet = statement.executeQuery(sql);
			 
				
				if(resultSet.next()) {
					String link = resultSet.getString("more_info");
					if (java.awt.Desktop.isDesktopSupported ())
					{
						java.awt.Desktop desktop = java.awt.Desktop.getDesktop ();
						if (desktop.isSupported (java.awt.Desktop.Action.BROWSE))
						{
							try
							{
								desktop.browse (new java.net.URI (link));
							}
							catch (java.io.IOException e1)
							{
								e1.printStackTrace ();
							}
							catch (java.net.URISyntaxException e1)
							{
								e1.printStackTrace ();
							}
						}
					}
					
					
					
				}
			
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		
		
		
		
		

	}
	if(e.getSource()==reviews) {
		new reviews();
	}
	

}

@Override
public void mouseClicked(MouseEvent e) {
	// TODO Auto-generated method stub
	frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
	if(signin.signin) {
		signin.signin=true;
	        new home();}
	else {
		new home();
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