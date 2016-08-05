/*
 * 자바기반의 어플리케이션의 이벤트 구현순서
 * 1단계 알맞은 리스너를 선택하기
 * 2단계 리스너의 메서드 재정의하기(불완전한 메서드 완성하기)
 * 3단계 이벤트소스와 리스너와의 연결!!
 * */

package gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class KeyTest extends JFrame implements KeyListener, ActionListener{
	JButton bt;
	JTextField txt;
		
	public KeyTest(){
		txt=new JTextField(20);
		bt=new JButton("버튼");
		
		setLayout(new FlowLayout());
		add(txt);
		add(bt);
		
		// 현재 클래스는 프레임이자 곧 key리스너이므로...
		txt.addKeyListener(this);
		bt.addActionListener(this);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
				
		setSize(300,400);
		setVisible(true);
		
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("눌렀다 눌렀어?");
	}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("눌렀다 떼었어?");
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("눌렀니?");
	}
	public static void main(String[] args) {
		new KeyTest();
	}
}
