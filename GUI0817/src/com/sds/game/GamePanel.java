/*
������ stage�ν� ���������� ��� �׷����� ó���Ǵ� ����!
*/
package com.sds.game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {
	public static final int WIDTH = 1024;
	public static final int HEIGHT = 768;
	Thread gameThread; // ������ ����!!
	boolean flag = true;
	
	ObjectManager objectManager;

	// ���ΰ� ����
	Hero hero;
	
	// ���� ����
	Enemy[] enemy = new Enemy[5];

	public GamePanel() {
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		objectManager = new ObjectManager();
		createHero();
		createEnemy();
	}

	// ���ΰ� ���� �޼��� ����
	public void createHero() {
		hero = new Hero(100,100,50,50,"Hero");
		// ������Ʈ ����Ʈ ���(�����ͺ��̽� ���)
		objectManager.addObject(hero);
		
	}
	
	// ���� ���� �޼���
	public void createEnemy(){
		enemy[0] = new Enemy(600,100,30,30,"Enemy");
		enemy[1] = new Enemy(650,150,30,30,"Enemy");
		enemy[2] = new Enemy(500,250,30,30,"Enemy");
		enemy[3] = new Enemy(300,400,30,30,"Enemy");
		enemy[4] = new Enemy(200,120,30,30,"Enemy");
		
		objectManager.addObject(enemy[0]);
		objectManager.addObject(enemy[1]);
		objectManager.addObject(enemy[2]);
		objectManager.addObject(enemy[3]);
		objectManager.addObject(enemy[4]);
	}

	public void paint(Graphics g) {
		// �׸��� �׸� �� �ִ�!
		// ��� ���� ������Ʈ���� ����� �̿��Ͽ� ��� ���� ������Ʈ�� tick �� render�� ȣ������!
		for(int i=0;i<objectManager.objectList.size();i++){
			GameObject obj=objectManager.objectList.get(i);
			obj.tick(); // ������!!
			obj.render(g);
		}

	}

	// ���� ���� �޼���
	public void startGame() {
		if (gameThread != null) {// �̹� ���� ���̶��!
			return;
		}
		flag = true;
		gameThread = new Thread(this);
		gameThread.start();
	}

	// ���� �Ͻ����� �޼���
	public void pauseGame() {
		flag = false;
		gameThread = null;
	}

	// ���� ���� �޼���
	public void exitGame() {
		System.exit(-1); // ���μ��� ����, ���� �ڹ� ���α׷� ����!
	}

	public void run() {
		// run�� ����� ��!! os������ ��� ����� ��!!
		while (flag) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//System.out.println("���� �����۵���");
			repaint();
		}
	}
}
