package com.sds.game;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class GameWindow extends JFrame implements ActionListener{
	// 게임옵션(게임시작, 멈춤, 종료) 
	// 도움말
	GamePanel gamePanel;
	JMenuBar bar;
	JMenu[] menu;
	JMenuItem[] item;
	KeyBoard keyBoard;
	
	public GameWindow() {
		bar = new JMenuBar();
		menu = new JMenu[2];
		item = new JMenuItem[3];
		
		menu[0] = new JMenu("게임옵션");
		menu[1] = new JMenu("도움말");
		
		item[0] = new JMenuItem("게임시작");
		item[1] = new JMenuItem("멈춤");
		item[2] = new JMenuItem("종료");
		
		menu[0].add(item[0]);
		menu[0].add(item[1]);
		menu[0].add(item[2]);
		
		bar.add(menu[0]);
		bar.add(menu[1]);
		
		setJMenuBar(bar);
		
		gamePanel = new GamePanel();
		keyBoard = new KeyBoard(gamePanel.objectManager);
		
		// 리스너와 윈도우 연결
		this.addKeyListener(keyBoard);
		
		add(gamePanel);
		
		pack();
		// 리스너와 메뉴와 연결!
		for(int i=0;i<item.length;i++){
			item[i].addActionListener(this);
		}
		
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent e) {
		Object obj=e.getSource();
		if(obj==item[0]){
			gamePanel.startGame();
		}else if(obj==item[1]){
			gamePanel.pauseGame();
		}else if(obj==item[2]){
			gamePanel.exitGame();
		}
	}
	
	public static void main(String[] args) {
		new GameWindow();
	}
}
