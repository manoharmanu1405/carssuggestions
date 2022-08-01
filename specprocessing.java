package miniproject;


import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JLabel;
import miniproject.*;
public class specprocessing {
	public static int[] intArray = new int[1000];
	String fuel=specsheet.fuel;
	String brand=specsheet.brand;
	String scap=specsheet.scap;
	String btype=specsheet.btype;String petrol,diesel,cng,sql;
	int s;int k2;public static int l,f;
	Statement statement=null;ResultSet resultSet=null;
	public specprocessing() {
		Connection con=databasecnct.con();

		
			l=0;
			try {

				statement=con.createStatement();
				
				
				//all-body-seating
			//	if(brand.equals("All"))
			//	sql="select * from cardata where seating_cap like '"+scap+"' and btype like '"+btype+"'";

				if(fuel.equals("Petrol")) {
				sql ="select * from cardata where brand like '"+brand+"' and petrol like 'yes' and seating_cap like '"+scap+"' and btype like '"+btype+"'";}
				else if(fuel.equals("Diesel")) {
					sql ="select * from cardata where brand like '"+brand+"' and diesel like 'yes' and seating_cap like '"+scap+"' and btype like '"+btype+"'";}
				else if(fuel.equals("CNG")) {
					sql ="select * from cardata where brand like '"+brand+"' and cng like 'yes' and seating_cap like '"+scap+"' and btype like '"+btype+"'";}
				else {
					sql ="select * from cardata where brand like '"+brand+"' and seating_cap like '"+scap+"' and btype like '"+btype+"'";
				}
				 resultSet = statement.executeQuery(sql);
				 
				while(resultSet.next()) {
                    
					String id=resultSet.getString("id"); 
					
					s=Integer.parseInt(id);
					String costrange = resultSet.getString("cost");
					String costdb = (costrange.substring(7,12));
					
					System.out.println(costdb);
					float f = Float.parseFloat(costdb);
					System.out.print(f);
					
	if(f<slider.cost) {
		
	

					intArray[l]=s;}
					
				//	System.out.println(intArray[l]);
					l++;
					
					
				
					
					
						
				}
				f=l;
				
				if(l==0) {
					System.out.println("No models found");
					new nocarsfound();
				}
				else {
				new carimage();
				}
		//	System.out.println(f+"f-value");
				
				
			//	new user();
				
				
				
				 
				 
				

	             
		} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}    
			
		 
		 
			
			
	}  
 
}
