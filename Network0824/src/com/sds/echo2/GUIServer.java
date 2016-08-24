/*
1. Echo 시스템
	단점 - 오직 1인의 접속자만 처리할 수 있다!!
	
2. Unicasting
	메세지를 보내는 대상은 한명!

3. MultiCasting

main 실행부는 어플리케이션 가동!!

*/

package com.sds.echo2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GUIServer extends JFrame implements ActionListener, Runnable {
	JPanel p_north;
	JTextField t_port;
	JButton bt;
	JTextArea area;
	JScrollPane scroll;
	ServerSocket server; // 접속 감지용 소켓!! 대화용x!!
	Thread acceptTread; // 접속자 감지용 쓰레드!! 쓰레기!!
	BufferedReader buffr;
	BufferedWriter buffw;
	Vector<ServerThread> list=new Vector<ServerThread>(); // ArrayList와 기능은 동일하나 동시성 문제에 있어서는 동기화를 지원해 주므로 쓰레드에 안전하다!

	public GUIServer() {
		p_north = new JPanel();
		t_port = new JTextField("8888", 15);
		bt = new JButton("가동");
		area = new JTextArea();
		scroll = new JScrollPane(area);

		area.setBackground(Color.yellow);
		p_north.add(t_port);
		p_north.add(bt);
		add(p_north, BorderLayout.NORTH);
		add(scroll);

		// 버튼과 리스너 연결
		bt.addActionListener(this);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(600, 100, 300, 400);
		setVisible(true);

	}

	// 서버가동메서드
	public void startServer() {
		String port = t_port.getText();

		try {
			server = new ServerSocket(Integer.parseInt(port));
			area.append("서버생성완료\n");

			// 접속자 감지하기 위해 가동!!
			while (true) {
				Socket client = server.accept(); // 무한대기에 빠진다!!
				String ip = client.getInetAddress().getHostAddress();
	
				area.append(ip + "님 접속\n");
				
				// 클라이언트의 접속이 감지되면 소켓을 얻어서 보관해놓는다!
				ServerThread ct = new ServerThread(client,area,list);
				ct.start();
				
				// 생성된 쓰레드를 접속자 명단에 추가하자! 쓰레드가 생성된 시점!!
				list.add(ct);
				area.append("현재 접속자 수"+list.size()+"명...\n");
			}

		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "포트번호는 숫자로 입력해주세요");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		startServer();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		acceptTread = new Thread(this);
		acceptTread.start();

		// 버튼 비활성화
		bt.setEnabled(false);
	}

	public static void main(String[] args) {
		new GUIServer();
	}

}
