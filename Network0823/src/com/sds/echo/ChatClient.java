package com.sds.echo;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClient extends JFrame implements ActionListener {
	JScrollPane scroll;
	JTextArea area;
	
	JPanel p_south;
	JTextField txt;
	JButton bt;
	Socket client; // 대화용 소켓(종이컵, 전화기)
	
	String ip="70.12.112.92";
	int port = 7776;
	
	BufferedReader buffr; // 입력용
	BufferedWriter buffw; // 출력용
	
	public ChatClient() {
		area = new JTextArea();
		scroll = new JScrollPane(area);
		
		p_south = new JPanel();
		txt = new JTextField(15);
		bt = new JButton("접속");
		
		p_south.add(txt);
		p_south.add(bt);
		
		add(scroll);
		add(p_south, BorderLayout.SOUTH);
		
		// 버튼과 연결!!
		bt.addActionListener(this);
		
		// 텍스트 필드와 리스너 연결
		txt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				int key =e.getKeyCode();
				
				if(key==KeyEvent.VK_ENTER){
					// 서버에 메세지 보내기!!
					sendMsg();
				}
			}
		});
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300, 400);
		setVisible(true);
	}
	
	// 서버에 접속하는 메서드
	
	public void connect(){
		// ip와 포트번호를 이용하여 서버에 접속!!
		try {
			client = new Socket(ip, port); // 접속이 발생!!
			buffr = new BufferedReader(new InputStreamReader(client.getInputStream()));
			buffw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
			System.out.println("ip를 확인해주세요");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("네트워크 문제가 발생했습니다.");
		}
	}
	
	// 서버에 메세지 전송 메서드
	public void sendMsg(){
		String msg=txt.getText();
		try {
			// 보내고
			buffw.write(msg+"\n");
			buffw.flush();
			
			// 받고
			String data =buffr.readLine();
			area.append(data+"\n");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		connect();
	}
	
	public static void main(String[] args) {
		new ChatClient();
	}

}
