package com.sds.file;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

class ProfileApp1 extends JFrame {
	JButton bt;
	JTextField txt;
	JPanel p;
	Canvas can;
	Toolkit kit;
	Image img;

	public ProfileApp1() {
		kit = Toolkit.getDefaultToolkit();
		img = kit.getImage("C:/Java_workspace/GUI0810/res/basic.png");

		can = new Canvas() {
			public void paint(Graphics g) {
				g.drawImage(img, 128, 128, this);
			}
		};

		p = new JPanel();
		bt = new JButton("Ã£±â");
		txt = new JTextField(15);

		can.setPreferredSize(new Dimension(400, 600));
		can.setBackground(Color.YELLOW);

		p.add(bt);
		p.add(txt);

		add(can, BorderLayout.WEST);
		add(p);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800, 600);
		setVisible(true);

	}

	public static void main(String[] args) {
		new ProfileApp1();
	}
}
