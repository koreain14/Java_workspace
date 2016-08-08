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
	ChatB chatB; // ����� chatB�� ���� null�̴�! ������ new �ϸ� �ȵȴ�! ��ü�Ѵ�!!

	public ChatA() {
		area = new JTextArea();
		p = new JPanel();
		txt = new JTextField(15);
		bt = new JButton("��â");
		scroll = new JScrollPane(area);

		// ���Ϳ� area����
		add(scroll);
		// �гο� ��ư, txt ����
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
		// ��ư�� ������ �ּҰ��� ���� ��������!!
		chatB = new ChatB(this);
		bt.setEnabled(false);
	}

	public void keyPressed(KeyEvent e) {

	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_ENTER) {
			// area �� ������ ���
			String msg = txt.getText();
			area.append(msg + "\n");
			// �Է� �޼��� �ʱ�ȭ
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
