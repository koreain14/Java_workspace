package com.sds.game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {
	// 페인트 메서드를 재정의 하기 위해서 상속받아야 한다.
	public static final int WIDTH = 1024;
	public static final int HEIGHT = 768;
	Thread gameThread;
	boolean running = true;
	Ship ship;
	ObjectManager objectManager;
	Enemy enemy;
	Random random;
	Image img;

	public GamePanel() {
		setPreferredSize(new Dimension(WIDTH, HEIGHT));

		objectManager = new ObjectManager();
		random = new Random();
		createShip();
		createEnemy();
		createBlock();
	}

	// 주인공 등장 메서드
	public void createShip() {
		ship = new Ship(50, 300, 70, 70, "mario", objectManager);
		objectManager.objectList.add(ship);
	}
	
	// 적군 등장 메서드
	public void createEnemy(){
		for(int i=0;i<7;i++){
			enemy = new Enemy(WIDTH-100, (i*70)+70, 50, 50, "enemy", objectManager);
			objectManager.objectList.add(enemy);
		}
	}
	
	// 블락 생성 메서드
	public void createBlock(){
		// 윗블럭
		for(int i=0;i<20;i++){
			Block block = new Block(i*50, 0, 50, 50, "block", objectManager);
			objectManager.addObject(block);
		}
		
		// 아랫블럭
		for(int i=0;i<20;i++){
			Block block = new Block(i*50, HEIGHT-50, 50, 50, "block", objectManager);
			objectManager.addObject(block);
		}
	}

	protected void paintComponent(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		
		// 모든 게임 오브젝트의 tick() render() 호출이 가능!
		// render에 g를 넘겨야 하기 때문에!!
		for (int i = 0; i < objectManager.objectList.size(); i++) {
			GameObject obj = objectManager.objectList.get(i);
			obj.tick();
			obj.render(g);
		}
	}

	// 게임시작(쓰레드 생성 및 시작)
	public void startGame() {
		if (gameThread != null) {
			return;
		}
		running = true;
		gameThread = new Thread(this);
		gameThread.start(); // Runnable 영역으로 진입시키기
	}

	// 게임멈춤(쓰레드 종료)
	public void pauseGame() {
		running = false;
		gameThread = null;
	}

	// 게임종료(프로세스 종료)
	public void exitGame() {
		System.exit(0);
	}

	public void run() {
		// 게임의 심장부, 게임 전체를 운영함!!
		while (running) {
			// 여기서 게임의 모든 객체를 작동!! tick(), ender()
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// 모든 오브젝트들을 대상으로 tick()과 render()호출
			repaint(); // 내부적으로 update를 호출하고 update는 paint()를 호출함!!
		}
	}
}
