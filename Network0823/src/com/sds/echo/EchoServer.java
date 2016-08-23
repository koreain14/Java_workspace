package com.sds.echo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
	ServerSocket server; // 대화용 아니고, 접속 감지용
	BufferedReader buffr;
	BufferedWriter buffw;

	public EchoServer() {
		try {
			server = new ServerSocket(7776); // 서버생성
			System.out.println("서버생성");
			// 접속자 감지!!(전화받기)
			// 소켓이란? 네트워크의 전반적인 기능을 추상화한 객체!
			// 따라서 개발자는 네트워크적 지식이 없어도 되며
			// 어떠한 플랫폼에서도 동작을 할 수 있다!!

			Socket client = server.accept();

			String ip = client.getInetAddress().getHostAddress();
			System.out.println(ip + "님 접속");

			// 입력과 출력을 무한루프처리

			buffr = new BufferedReader(new InputStreamReader(client.getInputStream()));
			buffw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));

			String data = null;
			while (true) {
				data = buffr.readLine(); // 클라이언트의 메세지 받기(입력)
				System.out.println(data); // 서버 콘솔에 출력하기!!

				// 클라이언트에 다시 보내기!!
				buffw.write(data + "\n"); // 한 줄의 끝을 알려줘야 함!!
				buffw.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new EchoServer();
	}
}
