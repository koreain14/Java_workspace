package com.sds.client;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class AppMain extends JFrame {
	JPanel p_north;
	JButton[] btn = new JButton[4];
	JPanel[] p_content = new JPanel[4];
	String[] iconPath ={"chat.png","game.png","profile.png","inventory.png"};	
	URL url; // �ڿ��� ��ġ�� ��Ÿ���� ��ü!!
	Color[] bg = {Color.RED,Color.yellow,Color.green,Color.blue};
	JPanel p_center; // ī�� ���̾ƿ��� ������ �г�

	public AppMain() {
		p_north = new JPanel();
		p_north.setPreferredSize(new Dimension(500, 50));
		p_north.setLayout(new GridLayout(1, 4));
		p_center = new JPanel();
		p_center.setLayout(new CardLayout());
		
		for(int i=0;i<btn.length;i++){
			URL url=this.getClass().getClassLoader().getResource(iconPath[i]);
			ImageIcon icon = new ImageIcon(url); // �������̹��� �������!!
			Image img=icon.getImage(); // �̹����� ����!!
			img=img.getScaledInstance(50, 50, Image.SCALE_SMOOTH); // ��ȯ���� �̹���, ũ�Ⱑ ����� �̹���!!
			icon.setImage(img);
			
			btn[i] = new JButton(icon);
			p_north.add(btn[i]);
			
			p_content[i] = new JPanel();
			p_content[i].setBackground(bg[i]);
			p_content[i].setPreferredSize(new Dimension(500, 450));
			p_content[i].setVisible(false);
			
		}
		p_center.add(p_content[0]);
		
		add(p_center);
		add(p_north, BorderLayout.NORTH);
		setSize(500, 500);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new AppMain();
	}
}
