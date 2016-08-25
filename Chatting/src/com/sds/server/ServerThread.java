/*
�����ڸ��� 1:1�� ��û�� ó���ϱ� ���� �������� ������!!
������ �����Ѵ� ��? ��ȭ�� ��������, �׸��� ���� ��ûó���� ���ؼ�!!
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

	// ���

	public void listen() {
		try {
			String msg = buffr.readLine();

			sendMsg(msg); // �ٽ� �����ϱ�!!
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// ���ϰ�
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
