package com.sds.thread;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

// 쓰레드를 상속받아 사용하려고 할 때 이미 누군가의 자식 클래스라면 Runnable 인터페이스를 이용할 수 있다!!
// Runnable은 Run메서드를 추상메서드로 보유한 인터페이스이다!!
public class CounterApp extends JFrame implements Runnable {
	JButton bt;
	JLabel lb;
	int count;
	MyThread th;
	CounterApp app;
	Thread th2; // 내부 입력으로 가보자!!
	Thread th3; // Runnable은 Thread가 아니므로, run 메서드를 재정의 하였다 하더라도 쓰레드가 존재해야 한다!

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

	// 이 run메서드는 Runnable 인터페이스꺼다!!
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
