/*
회원 1명을 포함하는 아이템 클래스 정의
*/

package com.sds.client.chatting;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.sds.client.AppMain;

public class Item extends JPanel implements ActionListener{
	JLabel la_profile;
	JLabel la_status;
	ImageIcon icon;
	JButton bt;
	int you;
	
	// 객체 생성시 이미지 경로와 상태메세지를 넘겨 받자!!
	public Item(String path, String status, int you) {
		this.you=you;
		
		URL url = this.getClass().getClassLoader().getResource(path);
		icon = new ImageIcon(url);
		la_profile = new JLabel(icon);
		la_status = new JLabel(status);
		bt = new JButton("친구맺기");
		
		setLayout(new BorderLayout());
		add(la_profile, BorderLayout.WEST); // 서쪽에 부착
		add(la_status); // 센터에 부착
		add(bt, BorderLayout.EAST);
		
		la_profile.setPreferredSize(new Dimension(100, 100));
		setPreferredSize(new Dimension(400, 60));
		
		bt.addActionListener(this);
	}
	
	public void makeFriend(){
		System.out.println(AppMain.me+"와"+you+"친구를 맺었습니다.");
	}
	
	public void actionPerformed(ActionEvent e) {
		makeFriend();
	}
}
