package com.sds.thread;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Fire extends JFrame {
	Canvas can;
	Toolkit kit = Toolkit.getDefaultToolkit();
	int x = 0;

	public Fire() {
		can = new Canvas() {
			@Override
			public void paint(Graphics g) {
				g.drawOval(x, 300, 50, 50);
			}
		};
		

		can.setBackground(Color.white);

		add(can);

		this.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					Thread th = new Thread(){
						public void run() {
							while(true){
								try {
									Thread.sleep(10);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								x+=5;
								can.repaint();
							}
						}
					};
					th.start();
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {

			}
		});

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// 윈도우를 모니터 크기와 상관없이 항상 가운데로 띄우는 방법
		setLocationRelativeTo(null);
		setSize(800, 600);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Fire();
	}

}
