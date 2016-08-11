/*
썸네일에 사용될 캔버스이며, 상당히 많은 인스턴스가 예상되므로 즉 재사용성이 높으므로 내부익명
보다는 .java 소스로 별도로 존재시키자!
*/
package com.sds.graphic;
 
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class MyCanvas extends Canvas implements MouseListener{
	Toolkit kit;
	Image img;
	ThumbnailGallery tg;
	
	public MyCanvas(String url, ThumbnailGallery tg) {
		this.tg=tg;
		
		kit=Toolkit.getDefaultToolkit();
		img=kit.getImage(url);
		
		// 현재 캔버스 자체에 마우스 리스너 장착
		this.addMouseListener(this);
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawImage(img, 0, 0, 50, 50, this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// 윈도우가 사용중인 큰 이미지를 나인 캔버스의 이미지로 대체하자!!
		tg.currentImg=img;
		tg.p_right.repaint();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
