/*
주인공을 정의한다!!
*/
package com.sds.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class Hero extends GameObject {
	Toolkit kit=Toolkit.getDefaultToolkit();
	Image img;
	
	public Hero(int x, int y, int width, int height, String name) {
		super(x, y, width, height, name);
	}

	// 일정한 물리량의 변화값을 결정하는 메서드!!
	public void tick() {
		x += velX;
		y += velY;
	}

	// 자신이 어떻게 그려져야 할지를 결정하는 메서드!!
	public void render(Graphics g) {
		// 검정색으로 기존에 그려진 그림을 덮어버린다.
		g.setColor(Color.black);
		g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);

		//g.setColor(Color.YELLOW);
		//g.drawRect(x, y, 50, 50);
		g.drawImage(img, 0, 0, 100, 100, this);
	}
}
