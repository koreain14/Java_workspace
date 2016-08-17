package com.sds.thread;

public class MyThread2 extends Thread {
	int n;
	TotalThread tt;
	
	public MyThread2(TotalThread tt) {
		this.tt = tt;
	}
	
	public void run() {
		while(true){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			fill();
		}
	}
	public void fill(){
		n++;
		tt.bar1.setValue(n);
	}
}
