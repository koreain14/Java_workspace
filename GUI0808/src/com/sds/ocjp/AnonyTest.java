/*
 클래스 안에 클래스를 둘 수 있는가? 있다!! 내부입력!!
 재사용이 필요없을 때 사용함! 이벤트 구현을 목적으로 했을 때, 재사용성이 없으므로!
 */
package com.sds.ocjp;

import java.awt.Canvas;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class AnonyTest extends JFrame {
	Canvas can;
	JButton bt1, bt2;

	public AnonyTest() {
		// 생성자 안에 canvas를 정의!! 이름이 없다!! {} 브레이스가 클래스, 부모는 Canvas
		can = new Canvas() {
			public void paint(Graphics g) {
				g.drawLine(0, 0, 300, 400);
			}
		};
		/*
		 * add(can = new Canvas() { public void paint(Graphics g) {
		 * 
		 * } ); --> 이런 표현도 가능!!
		 */

		add(can); // 프레임의 센터에 캔버스 부착!!

		bt1 = new JButton("버튼1");
		bt2 = new JButton("버튼2");
		
		setLayout(new FlowLayout());
				
		add(bt1);
		add(bt2);
		
		
		bt1.addActionListener(new ActionListener() { // ActionListener는 인터페이스, new는 뒤에있는 {}객체!
			public void actionPerformed(ActionEvent e) {
				System.out.println("난 버튼1");
			}
		});
		bt2.addActionListener(new ActionListener() { // ActionListener는 인터페이스, new는 뒤에있는 {}객체!
			public void actionPerformed(ActionEvent e) {
				System.out.println("난 버튼2");
			}
		});
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300, 400);
		setVisible(true);

	}

	public static void main(String[] args) {
		new AnonyTest();
	}

}
