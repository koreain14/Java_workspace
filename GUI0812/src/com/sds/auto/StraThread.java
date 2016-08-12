package com.sds.auto;

public class StraThread extends Thread{
	@Override
	public void run() {
		while(true){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("¡Ú");
		}
	}
}
