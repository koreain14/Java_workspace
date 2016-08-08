/*
 * 1. �˸´� ������ ����
 * 2. �������� �ż��� ������
 * 3. �̺�Ʈ �ҽ�(�̺�Ʈ�� ����Ų ������Ʈ)�� �����ʿ� ����
 */

package com.sds.gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;



public class EventTest extends JFrame implements ActionListener, KeyListener, WindowListener{
	JButton bt;
	JTextField txt;
	
	
	public EventTest(){
		bt=new JButton("��ư");
		txt=new JTextField(20);
		
		setLayout(new FlowLayout());
				
		add(txt);
		add(bt);
		
		//��ư�� �����ʿ� ����
		bt.addActionListener(this);
		//�ؽ�Ʈ�ʵ�� �����ʿ���
		txt.addKeyListener(this);
		//������� �����ʿ��� ����
		this.addWindowListener(this);	

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300, 400);
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		System.out.println("�� ������?");
	}
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		int key=e.getKeyCode();
		if(key==KeyEvent.VK_ENTER){
			System.out.println("�����ƾ�?");
		}
	}
	public void keyTyped(KeyEvent e) {

	}

	public void windowActivated(WindowEvent e) {
		System.out.println("windowActivated ȣ��");
	}

	public void windowClosed(WindowEvent e) {
		System.out.println("windowClosed ȣ��");
	}

	public void windowClosing(WindowEvent e) {
		System.out.println("windowClosing ȣ��");

	}

	public void windowDeactivated(WindowEvent e) {
		System.out.println("windowDeactivated ȣ��");

	}

	public void windowDeiconified(WindowEvent e) {
		System.out.println("windowDeiconified ȣ��");
	}

	public void windowIconified(WindowEvent e) {
		System.out.println("windowIconified ȣ��");
	}

	public void windowOpened(WindowEvent e) {
		System.out.println("windowOpened ȣ��");
	}
	
	public static void main(String[] args) {
		new EventTest();
	}
}
