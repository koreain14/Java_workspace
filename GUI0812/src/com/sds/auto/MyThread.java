/*
�ϳ��� ���μ��� ������ ���������� ����Ǵ� ���ν��� ������ ������� �ϸ�
Thread Ŭ������ �����Ѵ�.
����) ������� �ڹ��� ������ �ƴϴ�! �����ϴ� ��κ��� �������α׷��� �����尡 �����Ѵ�.
	 c, c#, javascript(=setTimeout)
*/
package com.sds.auto;

public class MyThread extends Thread{
	/*
	 * �����ڴ� ���������� �����ϰ� ���� �ڵ尡 �ִٸ� run() �޼��带 �������ϸ� �ȴ�.
	 * */ 
	int count;

	public void run() {
		while(true){
			try {
				Thread.sleep(1000);
				// 1�ʵ��� non-runnable ���·� �־��. 1�� ������ �ٽ� runnable�� ����
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
			count++;
			System.out.println(count);
		}
	}
}
