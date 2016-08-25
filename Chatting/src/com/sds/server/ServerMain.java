/*
서버관리자가 쉽게 모니터링 하기위해 GUI기반 서버로 구축하자!!
대신 개발자는 고생...

*/

package com.sds.server;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ServerMain extends JFrame implements Runnable, ActionListener{
	JPanel p_north;
	JTextField t_port;
	JButton bt;
	JTextArea area;
	JScrollPane scroll;
	
	// 메인 쓰레드는 프로세스를 운영하는 목적으로 사용되어야 하는 실행부이므로
	// 절대 무한루프나 대기상태로 빠지게하면 안된다.
	// 다수의 접속자를 실시간으로 받아들이기 위해서는 별도의 ##실행부##를 생성하여 while 돌리자!!
	
	Thread acceptThread;
	ServerSocket server;
	int port=7777;
	
	// 드라이버 경로 설정!!
	String driver
	
	public ServerMain() {
		p_north = new JPanel();
		t_port = new JTextField(Integer.toString(port),4);
		bt = new JButton("가동");
		area = new JTextArea();
		scroll = new JScrollPane(area);
		
		area.setBackground(Color.yellow);
		p_north.add(t_port);
		p_north.add(bt);
		
		add(p_north, BorderLayout.NORTH);
		add(scroll);
		
		bt.addActionListener(this);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(400, 100, 300, 400);
		setVisible(true);
		
	}
	
	// 접속자 감지!! (무한루프) , 대기상태에 빠지는 메서드가 있어서 부하가 걸리지 안흔다!
	public void run() {
		startServer();
	}
	
	// 서버가동 메서드
	public void startServer(){
		try {
			server = new ServerSocket(port);
			area.append("서버생성완료 \n");
			
			// 서버는 수많은 접속자를 받아야하기 때문에 무한루프!!
			while(true){
				Socket client=server.accept();
				ServerThread st = new ServerThread(this, client);
				st.start(); // 쓰레드한테 시작하라고 명령함!! 쓰레드는 분신 환영분신? 
				area.append("접속자 감지!!\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void actionPerformed(ActionEvent arg0) {
		// 쓰레드 스타트
		acceptThread = new Thread(this);
		acceptThread.start();
		bt.setEnabled(false);
	}
	
	public static void main(String[] args) {
		new ServerMain();
	}

}
