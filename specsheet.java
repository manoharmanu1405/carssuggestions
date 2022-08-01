package miniproject;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class specsheet implements ActionListener { 
	public static String btype,fuel,brand,scap;
JFrame f;JComboBox cb,cb1,cb2,cb3;    
public specsheet(){    
    f=new JFrame("ComboBox Example");    
    String brand[] ={"Brand","All","Kia","Hyundai","Nissan","Renault","Tata","Maruti","Mahindra","Skoda","Honda","MG","Toyota"};        
    cb=new JComboBox(brand);    
    cb.setBounds(70, 100,90,30);    
    f.add(cb);
    String btype[] ={"Body Type","All","SUV","MUV","Hatchback","Sedan"};        
    cb1=new JComboBox(btype);    
    cb1.setBounds(240,100,90,30);    
    f.add(cb1); 
    String fuel[] ={"Fuel","All","Petrol","Diesel","CNG"};        
    cb2=new JComboBox(fuel);    
    cb2.setBounds(70, 200,90,30);    
    f.add(cb2); 
    String scap[] ={"Seating","All","4","5","6"};        
    cb3=new JComboBox(scap);    
    cb3.setBounds(250, 200,90,30);    
    f.add(cb3); 
    
    JButton b=new JButton("done");
    b.setBounds(160,340,80,30);
    b.addActionListener(this);
    f.add(b);
    
    
    
    
    
    f.setLayout(null);    
    f.setSize(400,500);    
    f.setVisible(true);         
}    
public static void main(String[] args) {    
    new specsheet();         
}

public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	f.dispatchEvent(new WindowEvent(f, WindowEvent.WINDOW_CLOSING));
	brand = (String)cb.getSelectedItem();
	btype=  (String)cb1.getSelectedItem();
	fuel=  (String)cb2.getSelectedItem();
	scap=  (String)cb3.getSelectedItem();
	
	
	System.out.println(brand+btype+fuel+scap);
	f.dispatchEvent(new WindowEvent(f, WindowEvent.WINDOW_CLOSING));
	new specprocessing();
	
}    
}
