package com.sds.thread;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JProgressBar;

public class Bar extends JProgressBar{
	Thread thread;
	int n;
	
	public Bar() {
		this.setPreferredSize(new Dimension(300, 80));
		this.setBackground(Color.GREEN);
		
		thread = new Thread();
	}
	
	public void run() {
		while(true){
		try {
			Thread.sleep();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fill();
		}
	}
	
	public void fill(){
		n++;
		this.setValue(n);
	}
}
