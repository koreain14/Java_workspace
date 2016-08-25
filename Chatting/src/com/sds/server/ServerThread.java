/*
접속자마다 1:1로 요청을 처리하기 위한 서버측의 쓰레드!!
소켓을 보관한다 왜? 대화를 나누려고, 그리고 각종 요청처리를 위해서!!
*/
package com.sds.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ServerThread extends Thread{
	Socket client;
	BufferedReader buffr;
	BufferedWriter buffw;

	public ServerThread(Socket client) {
		this.client = client;
		try {
			buffr = new BufferedReader(new InputStreamReader(client.getInputStream()));
			buffw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 듣고

	public void listen() {
		try {
			String msg = buffr.readLine();

			sendMsg(msg); // 다시 전송하기!!
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 말하고
	public void sendMsg(String msg) {
		try {
			buffw.write(msg + "\n");
			buffw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		while(true){
			listen();	
		}
	}
}
