/*
���ΰ��� �����Ѵ�!!
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

	// ������ �������� ��ȭ���� �����ϴ� �޼���!!
	public void tick() {
		x += velX;
		y += velY;
	}

	// �ڽ��� ��� �׷����� ������ �����ϴ� �޼���!!
	public void render(Graphics g) {
		// ���������� ������ �׷��� �׸��� ���������.
		g.setColor(Color.black);
		g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);

		//g.setColor(Color.YELLOW);
		//g.drawRect(x, y, 50, 50);
		g.drawImage(img, 0, 0, 100, 100, this);
	}
}
