package com.sds.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MakeButton extends JFrame {
	JButton bt1, bt2, bt3;
	JPanel p_north, p_center;

	public MakeButton() {
		bt1 = new JButton("생성");
		bt2 = new JButton("색상");
		
		p_north = new JPanel();
		p_center = new JPanel();

		p_north.add(bt1);
		p_north.add(bt2);

		bt1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
				JButton b = (JButton)obj;
				if(obj.equals(bt1)){
					createButton();
				}
			}
		});

		add(p_north, BorderLayout.NORTH);
		add(p_center, BorderLayout.CENTER);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600, 600);
		setVisible(true);
	}
	
	public void createButton(){
		bt3=new JButton("new");
		p_center.add(bt3);
		p_center.updateUI();

	}

	public static void main(String[] args) {
		new MakeButton();
	}

}
