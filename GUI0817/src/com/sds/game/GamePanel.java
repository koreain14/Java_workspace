/*
게임의 stage로써 실제적으로 모든 그래픽이 처리되는 영역!
*/
package com.sds.game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {
	public static final int WIDTH = 1024;
	public static final int HEIGHT = 768;
	Thread gameThread; // 게임의 심장!!
	boolean flag = true;
	
	ObjectManager objectManager;

	// 주인공 선언
	Hero hero;
	
	// 적군 선언
	Enemy[] enemy = new Enemy[5];

	public GamePanel() {
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		objectManager = new ObjectManager();
		createHero();
		createEnemy();
	}

	// 주인공 등장 메서드 정의
	public void createHero() {
		hero = new Hero(100,100,50,50,"Hero");
		// 오브젝트 리스트 등록(데이터베이스 등록)
		objectManager.addObject(hero);
		
	}
	
	// 적군 등장 메서드
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
		// 그림을 그릴 수 있다!
		// 모든 게임 오프젝트들이 명단을 이용하여 모든 게임 오브젝트의 tick 과 render를 호출하자!
		for(int i=0;i<objectManager.objectList.size();i++){
			GameObject obj=objectManager.objectList.get(i);
			obj.tick(); // 다형성!!
			obj.render(g);
		}

	}

	// 게임 시작 메서드
	public void startGame() {
		if (gameThread != null) {// 이미 가동 중이라면!
			return;
		}
		flag = true;
		gameThread = new Thread(this);
		gameThread.start();
	}

	// 게임 일시정지 메서드
	public void pauseGame() {
		flag = false;
		gameThread = null;
	}

	// 게임 종료 메서드
	public void exitGame() {
		System.exit(-1); // 프로세스 종료, 현재 자바 프로그램 종료!
	}

	public void run() {
		// run은 빨라야 함!! os역할을 대신 해줘야 함!!
		while (flag) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//System.out.println("게임 엔진작동중");
			repaint();
		}
	}
}
