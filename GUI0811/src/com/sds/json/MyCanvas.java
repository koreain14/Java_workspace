package com.sds.json;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class MyCanvas extends Canvas{
	Toolkit kit;
	Image img;
	
	
	public MyCanvas() {
		
	}
		
	@Override
	public void paint(Graphics g) {
		g.drawImage(img, 0, 0, 300, 400, this);
	}
	
}
