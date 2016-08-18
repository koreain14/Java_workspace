package com.sds.game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyBoard extends KeyAdapter{
	ObjectManager objectManager; //메서드의인수로 넘겨받자.
	
	public KeyBoard(ObjectManager objectManager) {
		this.objectManager=objectManager;
	}
	
	public void keyPressed(KeyEvent e) {
		int key=e.getKeyCode();
		
		for(int i=0;i<objectManager.objectList.size();i++){
			GameObject obj=objectManager.objectList.get(i);
			if(obj.name.equals("mario")){
				switch(key){
					case KeyEvent.VK_LEFT:	obj.velX=-2;break;
					case KeyEvent.VK_RIGHT:	obj.velX=2;break;
					case KeyEvent.VK_UP:		obj.velY=-2;break;
					case KeyEvent.VK_DOWN:	obj.velY=2;break;
					case KeyEvent.VK_SPACE:	((Ship)obj).fire();break;
				}
			}
		}
	}
	
	public void keyReleased(KeyEvent e) {
		int key=e.getKeyCode();
		
		for(int i=0;i<objectManager.objectList.size();i++){
			GameObject obj=objectManager.objectList.get(i);
			if(obj.name.equals("mario")){
				switch(key){
					case KeyEvent.VK_LEFT:	obj.velX=0;break;
					case KeyEvent.VK_RIGHT:	obj.velX=0;break;
					case KeyEvent.VK_UP:		obj.velY=0;break;
					case KeyEvent.VK_DOWN:	obj.velY=0;break;
				}
			}
		}
	}
}
