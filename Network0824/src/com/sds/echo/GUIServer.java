/*
1. Echo 시스템
	단점 - 오직 1인의 접속자만 처리할 수 있다!!
	
2. Unicasting
3. MultiCasting

main 실행부는 어플리케이션 가동!!

*/

package com.sds.echo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

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

			Socket client = server.accept(); // 무한대기에 빠진다!!
			String ip = client.getInetAddress().getHostAddress();

			area.append(ip + "님 접속\n");

			// 접속한 이유는 대화를 하기 위함이므로 스트림을 곧바로 얻어내자!!

			buffr = new BufferedReader(new InputStreamReader(client.getInputStream()));
			buffw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));

			// 듣고 보내기!!

			while (true) {
				String msg = buffr.readLine(); // 클라이언트의 메세지!!
				area.append(msg + "\n"); // 대화 모니터링

				buffw.write(msg + "\n"); // 문자열의 끝 표시를 해줘야 한다!!
				buffw.flush();
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
