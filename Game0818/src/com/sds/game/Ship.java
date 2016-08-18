package com.sds.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

public class Ship extends GameObject {
	Image img;

	public Ship(int x, int y, int width, int height, String name, ObjectManager objectManager) {
		super(x, y, width, height, name, objectManager);

		// URL�̶� �ڿ��� ��ġ�� �ǹ��Ѵ�!
		img = getImage("mario.png");
	}

	public void tick() {
		x += velX;
		y += velY;

		// �ǽð� �簢���� ��ġ�� �ٲ���Ѵ�.
		// �׷��� ���ΰ��� ����ٴϰ� �浹�˻簡 �����ϴ�!!
		
		rect.setBounds(x, y, width, height);
	}

	public void render(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawImage(img, x, y, width, height, null); // null ������ �����̳� ����!!
		
		showRect(g);
		//g.translate(x, y);
	}
	
	// �Ѿ� �߻�
	public void fire(){
		Bullet bullet = new Bullet(x+width, y+(height/2), 30, 30, "bullet", objectManager);
		objectManager.addObject(bullet);
	}
}
