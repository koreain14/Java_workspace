package com.sds.thread;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class TotalThread extends JFrame implements Runnable {
	JButton bt;
	JPanel p_north, p_center;
	JLabel lb;
	JProgressBar bar1, bar2;
	Thread th1;
	int count;
	MyThread2 th2;
	TotalThread tt;
	Thread th3;
	int n;

	public TotalThread() {
		tt = this;
		bt = new JButton("start");
		p_north = new JPanel();
		p_center = new JPanel();
		lb = new JLabel("0");
		bar1 = new JProgressBar();
		bar2 = new JProgressBar();
		
		th3 = new Thread(this);


		th1 = new Thread() {
			public void run() {
				while (true) {
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					count++;
					lb.setText(Integer.toString(count));
				}
			}
		};
	
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				th1.start();
				th2 = new MyThread2(tt);
				th2.start();
				th3.start();
			}
		});

		lb.setFont(new Font("arial black", Font.BOLD, 50));

		bar1.setPreferredSize(new Dimension(350, 50));
		bar1.setBackground(Color.pink);
		bar2.setPreferredSize(new Dimension(350, 50));
		bar2.setBackground(Color.yellow);

		p_north.add(bt);
		p_center.add(lb);
		p_center.add(bar1);
		p_center.add(bar2);

		add(p_north, BorderLayout.NORTH);
		add(p_center, BorderLayout.CENTER);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400, 300);
		setVisible(true);

	}

	public void run() {
		while (true) {
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			fill();
		}
	}
	
	public void fill(){
		n++;
		bar2.setValue(n);
	}

	public static void main(String[] args) {
		new TotalThread();
	}

}
