/*
����Ͽ� ���� ĵ�����̸�, ����� ���� �ν��Ͻ��� ����ǹǷ� �� ���뼺�� �����Ƿ� �����͸�
���ٴ� .java �ҽ��� ������ �����Ű��!
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
		
		// ���� ĵ���� ��ü�� ���콺 ������ ����
		this.addMouseListener(this);
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawImage(img, 0, 0, 50, 50, this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// �����찡 ������� ū �̹����� ���� ĵ������ �̹����� ��ü����!!
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
