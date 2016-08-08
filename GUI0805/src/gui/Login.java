package gui;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Login extends JFrame{
	JButton bt,bt2;
	JTextField txt;
	JPanel panel_south;
	JLabel label;
	
	
	public Login(){
		bt=new JButton("Login");
		bt2=new JButton("Signin");
		txt=new JTextField(20);
		label=new JLabel("·Î±×ÀÎ");
		
		panel_south=new JPanel();
		
		panel_south.add(bt);
		panel_south.add(bt2);
						
		setLayout(new BorderLayout());
		add(label,BorderLayout.NORTH);
		add(panel_south,BorderLayout.SOUTH);
		
		label.setHorizontalAlignment(JLabel.CENTER);
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
			
		setSize(500, 300);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new Login();
	}

}
