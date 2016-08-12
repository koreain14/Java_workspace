package com.sds.thread;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class AnimationApp extends JFrame {
	JButton bt;
	Canvas can;
	Toolkit kit = Toolkit.getDefaultToolkit();
	Image img;
	int x;
	Thread thread;

	public AnimationApp() {
		bt = new JButton("발사");
		img=kit.getImage("C:/Java_workspace/GUI0812/res/bullet.png");
		can = new Canvas() {
			public void paint(Graphics g) {
				g.drawImage(img, x, 0, 50, 50, this);
			}
		};
		// 쓰레드 생성
		thread = new Thread(){
			public void run() {
				while(true){
					try {
						thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					moveBullet();
				}
			}
		};
		
		bt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				thread.start();
			}
		});
		
		can.setBackground(Color.white);

		add(bt, BorderLayout.NORTH);
		add(can);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(900, 800);
		setVisible(true);

	}
	
	public void moveBullet(){
		x+=10;
		can.repaint();
	}
	
	public static void main(String[] args) {
		new AnimationApp();
	}

}
