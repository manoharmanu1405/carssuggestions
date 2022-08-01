package miniproject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class CreateDialogFromOptionPane implements ActionListener {
JFrame frame;
    public  CreateDialogFromOptionPane(){
        frame= new JFrame();
        JButton button = new JButton();

        button.setText("Click me to show dialog!");
        frame.add(button);
        frame.pack();
       frame.setVisible(true);
        button.addActionListener(this);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		 String name = JOptionPane.showInputDialog(frame,
                 "What is your name?", null);
		 
		 System.out.println(name);
		 
		
	}

        
}