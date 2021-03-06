package com.sds.client;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.sds.client.chatting.UserList;

public class AppMain extends JFrame {
	public static BufferedReader buffr;
	public static BufferedWriter buffw;
	public static int me;
	
	
	JPanel p_north;
	JButton[] btn = new JButton[4];
	JPanel[] p_content = new JPanel[4];
	String[] iconPath ={"chat.png","game.png","profile.png","inventory.png"};	
	URL url; // 자원의 위치를 나타내는 객체!!
	Color[] bg = {Color.RED,Color.yellow,Color.green,Color.blue};
	JPanel p_center; // 보더레이아웃을 적용할 패널
	JScrollPane scroll;
	
	public AppMain(BufferedReader buffr, BufferedWriter buffw, Long me) {
		this.buffr = buffr;
		this.buffw = buffw;
		this.me = me;
		
		p_north = new JPanel();
		p_north.setPreferredSize(new Dimension(500, 50));
		p_north.setLayout(new GridLayout(1, 4));
		p_center = new JPanel();
		p_center.setLayout(new BorderLayout());
		p_center.setPreferredSize(new Dimension(400, 450));
		
		for(int i=0;i<btn.length;i++){
			URL url=this.getClass().getClassLoader().getResource(iconPath[i]);
			ImageIcon icon = new ImageIcon(url); // 아이콘이미지 갖고오기!!
			Image img=icon.getImage(); // 이미지로 변경!!
			img=img.getScaledInstance(50, 50, Image.SCALE_SMOOTH); // 반환형이 이미지, 크기가 변경된 이미지!!
			icon.setImage(img);
			
			btn[i] = new JButton(icon);
			p_north.add(btn[i]);
			
			/*
			p_content[i] = new JPanel();
			p_content[i].setBackground(bg[i]);
			p_content[i].setPreferredSize(new Dimension(500, 450));
			p_content[i].setVisible(false);
			p_center.add(p_content[0]);
			*/
		}
		
		// 채팅목록 나오기!!!
		UserList friendList = new UserList();
		scroll = new JScrollPane(friendList);
		p_center.add(scroll);
		
		add(p_center);
		
		add(p_center);
		add(p_north, BorderLayout.NORTH);
		setSize(500, 500);
		setVisible(true);
	}
	/*
	public static void main(String[] args) {
		new AppMain();
	}
	*/
}
