package com.sds.stream;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Editor extends JFrame {
	JPanel p_main;
	JPanel p_west;
	JTextArea area;
	JScrollPane scroll;
	JLabel lb;
	JMenuBar bar;
	JMenu m1, m2, m3, m4, m5, m6, m7, m8, m9, m10, m11;
	JMenuItem mi1,mi2,mi3,mi4,mi5,mi6;
	JFileChooser chooser;
	FileReader reader;
	BufferedReader buffr;

	public Editor() {
		p_west = new JPanel();
		p_main = new JPanel();
		chooser = new JFileChooser();
		
		scroll = new JScrollPane(p_main);
		
		//메뉴설정
		bar = new JMenuBar();

		m1 = new JMenu("파일(F)");
		m2 = new JMenu("편집(E)");
		m3 = new JMenu("보기(V)");
		m4 = new JMenu("검색(S)");
		m5 = new JMenu("문서(D)");
		m6 = new JMenu("프로젝트(P)");
		m7 = new JMenu("도구(T)");
		m8 = new JMenu("브라우저(B)");
		m9 = new JMenu("값");
		m10 = new JMenu("창(W)");
		m11 = new JMenu("도움말(H)");
		
		mi1 = new JMenuItem("새파일");
		mi2 = new JMenuItem("열기");
		mi3 = new JMenuItem("닫기");
		mi4 = new JMenuItem("저장");
		mi5 = new JMenuItem("새 이름으로 저장");
		mi6 = new JMenuItem("종료");
		
		//mi1 이벤트 구현
		mi1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				newFile();
			}
		});
		
		
		// mi2 이벤트 구현
		mi2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				openNewFile();
			}
		});
		
		m1.add(mi1);
		m1.add(mi2);
		m1.add(mi3);
		m1.add(mi4);
		m1.add(mi5);
		m1.add(mi6);
		
		m1.insertSeparator(3);
		m1.insertSeparator(6);
		
		bar.add(m1);
		bar.add(m2);
		bar.add(m3);
		bar.add(m4);
		bar.add(m5);
		bar.add(m6);
		bar.add(m7);
		bar.add(m8);
		bar.add(m9);
		bar.add(m10);
		bar.add(m11);
		
		lb = new JLabel("1");
		area = new JTextArea();
		
		p_west.add(lb);
	
		add(bar, BorderLayout.NORTH);
		add(scroll);
		
		p_main.setLayout(new BorderLayout());
		p_main.add(p_west, BorderLayout.WEST);
		p_main.add(area);
		
		
		setSize(800, 600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}
	public void newFile(){
		area.setText("");
	}
	
	public void openNewFile(){
		if(chooser.showOpenDialog(this)==JFileChooser.APPROVE_OPTION){
			File file=chooser.getSelectedFile();
			try {
				reader = new FileReader(file);
				buffr = new BufferedReader(reader);
				buffr.readLine();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		
		}
	}

	public static void main(String[] args) {
		new Editor();
	}
}
