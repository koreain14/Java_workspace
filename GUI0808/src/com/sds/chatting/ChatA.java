package com.sds.chatting;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatA extends JFrame implements ActionListener, KeyListener {
	JTextArea area;
	JPanel p;
	JTextField txt;
	JButton bt;
	JScrollPane scroll;
	ChatB chatB; // 현재는 chatB의 값은 null이다! 무조건 new 하면 안된다! 대체한다!!

	public ChatA() {
		area = new JTextArea();
		p = new JPanel();
		txt = new JTextField(15);
		bt = new JButton("새창");
		scroll = new JScrollPane(area);

		// 센터에 area부착
		add(scroll);
		// 패널에 버튼, txt 부착
		p.add(txt);
		p.add(bt);

		add(p, BorderLayout.SOUTH);

		bt.addActionListener(this);
		txt.addKeyListener(this);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100, 200, 300, 400);
		setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {
		// 버튼을 누르면 주소값도 같이 보관하자!!
		chatB = new ChatB(this);
		bt.setEnabled(false);
	}

	public void keyPressed(KeyEvent e) {

	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_ENTER) {
			// area 에 데이터 출력
			String msg = txt.getText();
			area.append(msg + "\n");
			// 입력 메세지 초기화
			txt.setText("");
			chatB.area.append(msg + "\n");

		}
	}

	public void keyTyped(KeyEvent e) {

	}

	public static void main(String[] args) {
		new ChatA();
	}
}
