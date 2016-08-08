package com.sds.gui;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class EventTest2 extends JFrame{
	JButton bt;
	JTextField txt;
	MyListener ms;
	
	public EventTest2(){
		bt = new JButton("버튼");	
		txt = new JTextField(15);
		
		setLayout(new FlowLayout());
		add(bt);
		add(txt);
		
		bt.addActionListener(ms=new MyListener());
		
		System.out.println("setEt() 메서드 호출 전 내 주소값"+ this);
		ms.setEt(this);
				
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300, 400);
		setVisible(true);
		
	}
		
	public static void main(String[] args) {
		new EventTest2();
	}

}
