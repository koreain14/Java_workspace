package com.sds.json;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class MyFrame extends JFrame {
	JButton bt;
	JPanel p_left, p_right;
	JScrollPane scroll;
	JLabel lb_name, lb_gender, lb_age;

	public MyFrame() {
		bt = new JButton("열기");
		p_left = new JPanel();
		p_right = new JPanel();
		
		lb_name = new JLabel("이름");
		lb_gender = new JLabel("성별");
		lb_age = new JLabel("나이");
		
		p_right.setBackground(Color.RED);
		p_left.setPreferredSize(new Dimension(100, 400));
		p_left.setBackground(Color.BLUE);

		p_left.add(bt);
		p_right.add(lb_name);
		p_right.add(lb_gender);
		p_right.add(lb_age);
		
		add(p_left, BorderLayout.WEST);
		add(p_right);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600, 400);
		setVisible(true);

	}

}
