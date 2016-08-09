/*
 디자인 --> 필요한 것 호출 --> add --> canvas --> ActionEvent(내부클래스) --> 움직임메서드 --> 메서드호출 
 */

package com.sds.gui;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CircleMove extends JFrame {
	JPanel p_north;
	JButton bt_up, bt_down, bt_left, bt_right;
	Canvas can;
	JButton[] btn = new JButton[4];
	int x = 100; // 멤버면수는 내부익명 클래스가 접근 가능
	int y = 100;

	public CircleMove() {
		p_north = new JPanel();

		bt_up = new JButton("up");
		bt_down = new JButton("down");
		bt_left = new JButton("left");
		bt_right = new JButton("right");

		btn[0] = bt_left;
		btn[1] = bt_right;
		btn[2] = bt_up;
		btn[3] = bt_down;

		can = new Canvas() {
			public void paint(Graphics g) {
				// 개발자가 주도하에 그래픽 처리하자
				g.drawOval(x, y, 40, 40);
			}
		};

		add(can);

		p_north.add(bt_left);
		p_north.add(bt_right);
		p_north.add(bt_up);
		p_north.add(bt_down);

		add(p_north, BorderLayout.NORTH);

		// 버튼과 리스너와의 연결!!
		final int k = 9; // 내부익명 클래스는 지역변수를 접근 할 수 없으나 final 선언한 경우는 가능!
		for (int i = 0; i < btn.length; i++) {
			btn[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Object obj = e.getSource();
					JButton b = (JButton) obj;
					System.out.println(b.getText() + "누름");
					
					switch(b.getText()){
						case "left":moveHorizon(-5);break;
						case "right":moveHorizon(5);break;
						case "up":moveVertical(-5);break;
						case "down":moveVertical(5);break;
					
					}
				}
			});
		}

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600, 600);
		setVisible(true);

	}
	
	// 좌우 이동 메서드
	public void moveHorizon(int x){
		this.x+=x;
		can.repaint();
	}
	
	// 위아래 이동 메서드
	public void moveVertical(int y){
		this.y+=y;		
		can.repaint();
	}

	public static void main(String[] args) {
		new CircleMove();
	}

}
