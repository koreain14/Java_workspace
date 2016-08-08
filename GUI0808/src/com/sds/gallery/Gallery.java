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
		bt_left = new JButton("����");
		bt_right = new JButton("����");

		add(can);
		panel.add(bt_left);
		panel.add(txt);
		panel.add(bt_right);

		add(panel, BorderLayout.SOUTH);

		// �����ʿ� ��ư ����
		bt_left.addActionListener(this);
		bt_right.addActionListener(this);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(700, 650);
		setVisible(true);

	}

	// ���� �׸� �����ֱ� �޼���
	public void prev() {
		if(can.count>0){
			//JOptionPane.showMessageDialog(this, "�����̹���");
			can.count--;
			can.repaint();				
		}else{
			JOptionPane.showMessageDialog(this, "ó�������Դϴ�.");
		}
		
	}

	// ���� �׸� �����ֱ� �޼���
	public void next() {
		// JOptionPane.showMessageDialog(this, "�����̹���");
		// xCanvas�� ������ count ������ 1����!
		if (can.count < can.imgs.length) {
			can.count++;
			// �ٽ� �׷����� ��û!!repaint() ȣ�� --> update() --> paint() �ٽ� �׸�!! �����ڴ�
			// ��û�� ����
			can.repaint();
		} else {
			JOptionPane.showMessageDialog(this, "���̻� ������ �����ϴ�.");
		}

	}

	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource(); // �̺�Ʈ�� ����Ų ������Ʈ ��ȯ
		if (obj.equals(bt_left)) { // ���� ��ư�̶��
			prev();
		} else if (obj == bt_right) { // ������ư �̶��
			next();
		}
	}

	public static void main(String[] args) {
		new Gallery();
	}
}
