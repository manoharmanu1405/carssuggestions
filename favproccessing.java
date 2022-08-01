package miniproject;

import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JLabel;
import miniproject.*;
public class favproccessing {
	public static int[] intArray = new int[1000];
public static String mobileno=signin.mobileno;
	int s;int k2;public static int l,f;
	Statement statement=null;ResultSet resultSet=null;
	public favproccessing() {
		Connection con=databasecnct.con();

		
			l=0;
			try {
	
				
				statement=con.createStatement();
				
				Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
				String sql="select * from favourites where mobileno ='"+mobileno+"'";
				resultSet = statement.executeQuery(sql);
				 
					 if(resultSet.next()) {
				 resultSet.previous();
				while(resultSet.next()) {
					String id=resultSet.getString("id");
					s=Integer.parseInt(id);

					

		
	

					intArray[l]=s;
					System.out.println(s+"carids");
				
					
				//	System.out.println(intArray[l]);
					l++;
					
				}	
					
				
					
				
				f=l;
				System.out.println(f+"f value");
				
		//	System.out.println(f+"f-value");
				new favourites();
			//	new user();
				
				
				
				 
				 
				

	             
			}
					 else {
						 new nofav();
					 }
					 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}    
			
		 
		 
			
			
	}  
 
}

