package com.sds.gallery;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Gallery extends JFrame implements ActionListener {
	JPanel panel;
	XCanvas can;
	JTextField txt;
	JButton bt_left, bt_right;

	public Gallery() {
		panel = new JPanel();
		can = new XCanvas();
		txt = new JTextField(30);
		bt_left = new JButton("이전");
		bt_right = new JButton("다음");

		add(can);
		panel.add(bt_left);
		panel.add(txt);
		panel.add(bt_right);

		add(panel, BorderLayout.SOUTH);

		// 리스너와 버튼 연결
		bt_left.addActionListener(this);
		bt_right.addActionListener(this);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(700, 650);
		setVisible(true);

	}

	// 이전 그림 보여주기 메서드
	public void prev() {
		if(can.count>0){
			//JOptionPane.showMessageDialog(this, "이전이미지");
			can.count--;
			can.repaint();				
		}else{
			JOptionPane.showMessageDialog(this, "처음사진입니다.");
		}
		
	}

	// 다음 그림 보여주기 메서드
	public void next() {
		// JOptionPane.showMessageDialog(this, "다음이미지");
		// xCanvas가 보유한 count 변수를 1증가!
		if (can.count < can.imgs.length) {
			can.count++;
			// 다시 그려지기 요청!!repaint() 호출 --> update() --> paint() 다시 그림!! 개발자는
			// 요청만 가능
			can.repaint();
		} else {
			JOptionPane.showMessageDialog(this, "더이상 사진이 없습니다.");
		}

	}

	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource(); // 이벤트를 일으킨 컴포넌트 반환
		if (obj.equals(bt_left)) { // 이전 버튼이라면
			prev();
		} else if (obj == bt_right) { // 다음버튼 이라면
			next();
		}
	}

	public static void main(String[] args) {
		new Gallery();
	}
}
