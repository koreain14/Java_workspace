package com.sds.thread;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

// �����带 ��ӹ޾� ����Ϸ��� �� �� �̹� �������� �ڽ� Ŭ������� Runnable �������̽��� �̿��� �� �ִ�!!
// Runnable�� Run�޼��带 �߻�޼���� ������ �������̽��̴�!!
public class CounterApp extends JFrame implements Runnable {
	JButton bt;
	JLabel lb;
	int count;
	MyThread th;
	CounterApp app;
	Thread th2; // ���� �Է����� ������!!
	Thread th3; // Runnable�� Thread�� �ƴϹǷ�, run �޼��带 ������ �Ͽ��� �ϴ��� �����尡 �����ؾ� �Ѵ�!

	public CounterApp() {
		app = this;
		bt = new JButton("start");
		lb = new JLabel("0");

		add(bt, BorderLayout.NORTH);
		add(lb, BorderLayout.CENTER);

		th2 = new Thread() {
			public void run() {
				while (true) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					count++;
					lb.setText(Integer.toString(count));
				}
			}
		};

		th3 = new Thread(this);

		lb.setFont(new Font("arial black", Font.BOLD, 100));

		bt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// th = new MyThread(app);
				// th.start();
				// th2.start();
				th3.start();
			}
		});

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300, 400);
		setVisible(true);
	}

	// �� run�޼���� Runnable �������̽�����!!
	public void run() {
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			count++;
			lb.setText(Integer.toString(count));
		}
	}

	public static void main(String[] args) {
		new CounterApp();
	}
}
