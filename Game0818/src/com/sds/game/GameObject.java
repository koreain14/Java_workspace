/*
 * 화면에 등장할 모든 게임 오브젝트가 반드시 구현해야할 메서으돠 필요한 속성을 정의하기 위한 최상위 클래스
 * */

package com.sds.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

abstract public class GameObject {
	int x;
	int y;
	int width;
	int height;
	int velX;
	int velY;
	String name;
	ObjectManager objectManager;
	Rectangle rect;

	public GameObject(int x, int y, int width, int height, String name, ObjectManager objectManager) {
		// 태어날 때 정의!
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.name = name;
		this.objectManager = objectManager;
		rect = new Rectangle(x, y, width, height);
	}

	abstract public void tick();

	abstract public void render(Graphics g); // 패널에 그려지기로 함!! 그래픽스를 받아야 함

	// 클래스패스 상에 존재하는 이미지명만으로 Image객체를 반환해 주는 메서드!
	public Image getImage(String name) {
		Image img = null; // 지역변수는 컴파일러가 초기화 해주지 않는다. 반드시 개발자가 사용 전에 초기화 하자!!
		Class myClass = this.getClass();
		URL url = myClass.getClassLoader().getResource(name);
		try {
			img = ImageIO.read(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return img;
	}
	
	// Rectangle 객체가 생성은 되었지만 눈에 보여지지는 않으므로 개발시에만 시각화 시킬 수 있는 메서드 정의!
	public void showRect(Graphics g){
		// Graphics 객체의 기능에 2차원 그래픽 관련된 기능이 더 보강
		Graphics2D g2=(Graphics2D)g;
		g2.setColor(Color.yellow);
		g2.draw(rect);
		
	}
}
