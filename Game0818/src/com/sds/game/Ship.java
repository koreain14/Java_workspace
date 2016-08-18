package com.sds.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

public class Ship extends GameObject {
	Image img;

	public Ship(int x, int y, int width, int height, String name, ObjectManager objectManager) {
		super(x, y, width, height, name, objectManager);

		// URL이란 자원의 위치를 의미한다!
		img = getImage("mario.png");
	}

	public void tick() {
		x += velX;
		y += velY;

		// 실시간 사각형의 위치를 바꿔야한다.
		// 그래야 주인공을 따라다니고 충돌검사가 가능하다!!
		
		rect.setBounds(x, y, width, height);
	}

	public void render(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawImage(img, x, y, width, height, null); // null 나한테 컨테이너 없다!!
		
		showRect(g);
		//g.translate(x, y);
	}
	
	// 총알 발사
	public void fire(){
		Bullet bullet = new Bullet(x+width, y+(height/2), 30, 30, "bullet", objectManager);
		objectManager.addObject(bullet);
	}
}
