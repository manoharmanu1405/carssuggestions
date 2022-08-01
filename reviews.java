package miniproject;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.font.TextAttribute;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;





public class reviews implements MouseListener {
    Statement statement = null;String dummy1,dummy2;
    int j=carimage.fa;JLabel next,prev;
    int[] re=specprocessing.intArray;
    JLabel label1,labelr;JTextArea label2;
	ResultSet resultSet=null;ResultSet resultSet1=null;JFrame f;ResultSet resultSet2=null;
	public static JLabel b;public static String finalreview;public static String myreview;
	public reviews() {
		f=new JFrame("Car Reviews");
		b=new JLabel("Add review");
        label1 = new JLabel();
        label1.setAlignmentX(JLabel.LEFT_ALIGNMENT);
        label2 = new JTextArea("Label2");
        label2.setPreferredSize(new Dimension(300,80));
        label2.setEditable(false);  
        label2.setCursor(null);  
        label2.setOpaque(false);  
        label2.setFocusable(false);  
            
        label2.setWrapStyleWord(true);  
        label2.setLineWrap(true);
        //According to Mariana this might improve it
        b.setBounds(200,120,100,20);  
        b.addMouseListener(this);
        label2.setAlignmentY(JLabel.CENTER_ALIGNMENT);
        labelr = new JLabel("",JLabel.CENTER);
        JPanel jpanel = new JPanel();
        jpanel.setLayout(new BoxLayout(jpanel, BoxLayout.PAGE_AXIS));
        
        jpanel.add(labelr);
        labelr.setText("Ratings and Reviews");
        jpanel.add( Box.createRigidArea(new Dimension(10, 15)) );
        jpanel.add(label1);
        jpanel.add( Box.createRigidArea(new Dimension(0, 10)) );
        jpanel.add(label2);
        f.add(jpanel);
        f.pack();
        f.setVisible(true);
        f.setSize(500,200);
        next=new JLabel("next...");
		Font font = next.getFont();
		Map<TextAttribute, Object> attributes = new HashMap<>(font.getAttributes());
		attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		next.setFont(font.deriveFont(attributes));
        prev=new JLabel("previous...");
		Font font1 = prev.getFont();
		Map<TextAttribute, Object> attributes1 = new HashMap<>(font1.getAttributes());
		attributes1.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		prev.setFont(font1.deriveFont(attributes1));
		prev.addMouseListener(this);
        next.addMouseListener(this);
        next.setBounds(395,120,40,20);
        prev.setBounds(40,120,60,20);
        f.add(next);
        f.add(prev);
        f.add(b);
        JLabel l=new JLabel("");
        f.add(l);
        
        
        
        
        
        Connection con=databasecnct.con();
        
	try {
		Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			
	
			String sql ="select `"+re[j]+"`,mobileno from reviews where `"+re[j]+"` is not null";
			resultSet = statement.executeQuery(sql);
			resultSet.next(); 
			String mo=resultSet.getString("mobileno");
			finalreview=resultSet.getString(""+re[j]+"");
			Connection con1=databasecnct.con();
			Statement statement1 = con1.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql1="select firstname from signup where mobileno='"+mo+"'";
			resultSet1 = statement1.executeQuery(sql1);
			resultSet1.next();
			String user=resultSet1.getString("firstname");
			Connection con2=databasecnct.con();
			Statement statement2 = con2.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql2="select `"+re[j]+"`,mobileno from reviews where `"+re[j]+"` is not null and mobileno ='"+signin.mobileno+"'";
			resultSet2 = statement2.executeQuery(sql2);
			if(resultSet2.next()) {
				b.setText("update review");
				myreview=resultSet2.getString(""+re[j]+"");
			}
			
			label1.setText(user);
			label2.setText(finalreview);
			
			
			
			
	        
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}               

        
        
        


	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==next) {
			try {
				
				if(resultSet.next()) {
					
				String mo=resultSet.getString("mobileno");
				finalreview=resultSet.getString(""+re[j]+"");
				
				Connection con=databasecnct.con();
				Statement statement1 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
				String sql="select firstname from signup where mobileno='"+mo+"'";
				resultSet1 = statement1.executeQuery(sql);
				resultSet1.next();
				String user=resultSet1.getString("firstname");
				
				label1.setText(user);
				label2.setText(finalreview);
				
				}
				else {
					JOptionPane.showMessageDialog(f, "End of reviews");
					resultSet.previous();
				}
				
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
		
		}
		if(e.getSource()==b) {
			if(signin.signin) {
			new addreviews();
			f.dispatchEvent(new WindowEvent(f, WindowEvent.WINDOW_CLOSING));}
			else
			{
				JOptionPane.showMessageDialog(f, "You should signin to add reviews");
			}
			
		}
		if(e.getSource()==prev) {
		try {
				
				if(resultSet.previous()) {
				String mo=resultSet.getString("mobileno");
				finalreview=resultSet.getString(""+re[j]+"");
				Connection con=databasecnct.con();
				Statement statement1 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
				String sql="select firstname from signup where mobileno='"+mo+"'";
				resultSet1 = statement1.executeQuery(sql);
				resultSet1.next();
				String user=resultSet1.getString("firstname");
				label1.setText(user);
				label2.setText(finalreview);}
				else {
					JOptionPane.showMessageDialog(f, "First Review");
					resultSet.next();
				}
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
		
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
	
