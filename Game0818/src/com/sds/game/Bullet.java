package com.sds.game;

import java.awt.Graphics;
import java.awt.Image;

public class Bullet extends GameObject{
	Image img;

	public Bullet(int x, int y, int width, int height, String name, ObjectManager objectManager) {
		super(x, y, width, height, name, objectManager);
		img=getImage("b1.png");
		velX=5;
	}

	public void tick() {
		x+=velX;
		rect.setBounds(x, y, width, height);
		
		// �Ѿ˰� ������� �浹�˻�!!
		hitTest();
	}
	
	public boolean hitTest(){
		for(int i=0;i<objectManager.objectList.size();i++){
			GameObject obj=objectManager.objectList.get(i);
			if(obj.name.equals("enemy")){
				// ������ ���� �浹�˻�!!
				boolean result=rect.intersects(obj.rect);
				if(result){
					//System.out.println("�浹�߾�Ф�");
					objectManager.removeObject(this); // �� �װ�
					objectManager.removeObject(obj); // �� �װ�
				}
			}
		}
		return false;
	}

	public void render(Graphics g) {
		g.drawImage(img, x, y, width, height, null);
		
		showRect(g);
	}
}
