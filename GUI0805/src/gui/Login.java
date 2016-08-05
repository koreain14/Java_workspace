package gui;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Login extends JFrame{
	JButton bt,bt2;
	JTextField txt;
	JPanel panel_south;
	
	public Login(){
		bt=new JButton("Login");
		bt2=new JButton("Signin");
		txt=new JTextField(20);
		
		panel_south=new JPanel();
		
		panel_south.add(bt);
		panel_south.add(bt2);
						
		setLayout(new BorderLayout());
		add(panel_south,BorderLayout.SOUTH);
		
		setSize(500, 300);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new Login();
	}

}
