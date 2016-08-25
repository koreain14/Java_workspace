package com.sds.client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginForm extends JFrame implements ActionListener{
	JTextField tf;
	JTextField tf2;
	JButton bt;
	JButton bt2;
	JPanel pl;
	JPanel pl_ct;
	JPanel pl_ct2;
	JPanel pl_ct3;
	JLabel lb;
	JLabel lb2;
	JLabel lb3;
	
	// �α��� ������ �̹� ���� ������ Ȯ���� ����!!
	String ip="70.12.112.121";
	int port=7777;
	Socket client;
	
	public LoginForm() {
		super("LOGIN");
		lb = new JLabel("�α���",0);
		lb2 = new JLabel("ID");
		lb3 = new JLabel("PW");
		bt = new JButton("Login");
		bt2 = new JButton("Sign");
		tf = new JTextField(15);
		tf2 = new JTextField(15);
		pl = new JPanel();
		pl_ct = new JPanel();
		pl_ct2 = new JPanel();
		pl_ct3 = new JPanel();
		
		tf.setBackground(Color.yellow);
		tf2.setBackground(Color.yellow);
		
		pl.add(bt);
		pl.add(bt2);		
		
		pl_ct.add(lb2);
		pl_ct.add(tf);
		pl_ct2.add(lb3);
		pl_ct2.add(tf2);
		pl_ct3.add(pl_ct);
		pl_ct3.add(pl_ct2);
		
		lb.setPreferredSize(new Dimension(130, 20));
		lb2.setPreferredSize(new Dimension(70, 20));
		lb3.setPreferredSize(new Dimension(70, 20));
		bt.setPreferredSize(new Dimension(80, 20));
		bt2.setPreferredSize(new Dimension(80, 20));
				
		add(lb,BorderLayout.NORTH);
		add(pl_ct3,BorderLayout.CENTER);
		//add(pl_ct2,BorderLayout.CENTER);
		//add(lb2,BorderLayout.CENTER);
		//add(lb3,BorderLayout.CENTER);
		//add(tf,BorderLayout.CENTER);
		//add(tf2,BorderLayout.CENTER);
		add(pl,BorderLayout.SOUTH);
		
		bt.addActionListener(this);
				
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(350,180);
		setVisible(true);
		
		connect();
		
	}
	
	
	// ���α׷��� �����Ǹ� ������ ���Ͽ����� �õ�����
	
	public void connect(){
		try {
			client = new Socket(ip, port);
			System.out.println(client);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void loginCheck(){
		// ���ϼ����� ������ ��û�Ѵ�!!
	}
	
	public void actionPerformed(ActionEvent e) {
		loginCheck();
	}
	
	public static void main(String[] args) {
		new LoginForm();

	}

}
