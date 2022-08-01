package miniproject;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class databasecnct {
 final static String DB_URL = "jdbc:mysql://localhost:3306/minipj";
 final static String USER = "root";
 final static String PASS = "12345678@r";

 public static Connection con() {
	Connection con;
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(DB_URL,USER,PASS);
		return con;
		
	}
	
	catch(Exception e) {
		System.out.println(e);
		return null;
	}
	
	 
 }
 

 
}