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
	// ����Ʈ �޼��带 ������ �ϱ� ���ؼ� ��ӹ޾ƾ� �Ѵ�.
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

	// ���ΰ� ���� �޼���
	public void createShip() {
		ship = new Ship(50, 300, 70, 70, "mario", objectManager);
		objectManager.objectList.add(ship);
	}
	
	// ���� ���� �޼���
	public void createEnemy(){
		for(int i=0;i<7;i++){
			enemy = new Enemy(WIDTH-100, (i*70)+70, 50, 50, "enemy", objectManager);
			objectManager.objectList.add(enemy);
		}
	}
	
	// ��� ���� �޼���
	public void createBlock(){
		// ����
		for(int i=0;i<20;i++){
			Block block = new Block(i*50, 0, 50, 50, "block", objectManager);
			objectManager.addObject(block);
		}
		
		// �Ʒ���
		for(int i=0;i<20;i++){
			Block block = new Block(i*50, HEIGHT-50, 50, 50, "block", objectManager);
			objectManager.addObject(block);
		}
	}

	protected void paintComponent(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		
		// ��� ���� ������Ʈ�� tick() render() ȣ���� ����!
		// render�� g�� �Ѱܾ� �ϱ� ������!!
		for (int i = 0; i < objectManager.objectList.size(); i++) {
			GameObject obj = objectManager.objectList.get(i);
			obj.tick();
			obj.render(g);
		}
	}

	// ���ӽ���(������ ���� �� ����)
	public void startGame() {
		if (gameThread != null) {
			return;
		}
		running = true;
		gameThread = new Thread(this);
		gameThread.start(); // Runnable �������� ���Խ�Ű��
	}

	// ���Ӹ���(������ ����)
	public void pauseGame() {
		running = false;
		gameThread = null;
	}

	// ��������(���μ��� ����)
	public void exitGame() {
		System.exit(0);
	}

	public void run() {
		// ������ �����, ���� ��ü�� ���!!
		while (running) {
			// ���⼭ ������ ��� ��ü�� �۵�!! tick(), ender()
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// ��� ������Ʈ���� ������� tick()�� render()ȣ��
			repaint(); // ���������� update�� ȣ���ϰ� update�� paint()�� ȣ����!!
		}
	}
}
