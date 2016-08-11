package com.sds.graphic;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ThumbnailGallery extends JFrame {
	JPanel p_left, p_right;
	Image currentImg; // 유저가 지금 선택한 썸네일의 이미지!!
	String[] url = { "C:/Java_workspace/GUI0811/res/go.jpg", "C:/Java_workspace/GUI0811/res/go2.jpg",
			"C:/Java_workspace/GUI0811/res/go3.jpg", "C:/Java_workspace/GUI0811/res/go4.jpg",
			"C:/Java_workspace/GUI0811/res/go5.jpg", "C:/Java_workspace/GUI0811/res/go6.jpg",
			"C:/Java_workspace/GUI0811/res/go7.jpg", "C:/Java_workspace/GUI0811/res/go8.jpg",
			"C:/Java_workspace/GUI0811/res/gold.jpg", "C:/Java_workspace/GUI0811/res/haha.jpg" };

	MyCanvas[] can = new MyCanvas[url.length];

	public ThumbnailGallery() {
		p_left = new JPanel();

		for (int i = 0; i < can.length; i++) {
			can[i] = new MyCanvas(url[i], this);
			can[i].setPreferredSize(new Dimension(50, 50));
			p_left.add(can[i]);
		}

		// 큰 이미지 적용!!
		currentImg = can[0].img;
		
		p_right = new JPanel() {
			public void paint(Graphics g) {
				g.drawImage(currentImg, 0, 0, 400, 350, this);
			}
		};
		p_right.setPreferredSize(new Dimension(350, 350));

		// 배경 적용
		p_left.setBackground(Color.black);
		p_right.setBackground(Color.black);

		// 그리드 레이아웃 적용
		setLayout(new GridLayout(1, 2));

		add(p_left);
		add(p_right);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800, 600);
		setVisible(true);
	}

	public static void main(String[] args) {
		new ThumbnailGallery();
	}

}
