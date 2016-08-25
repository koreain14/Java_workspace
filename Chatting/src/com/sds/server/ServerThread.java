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

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ServerThread extends Thread{
	Socket client;
	BufferedReader buffr;
	BufferedWriter buffw;
	ServerMain serverMain;

	public ServerThread(ServerMain serverMain, Socket client) {
		this.serverMain = serverMain;
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
			String msg = buffr.readLine(); // ��Ģ�� ������! �α�������, ��ȭ����, ���������� �����ϱ� ����!! �̰��� ��������!!
			// �α��ο��� ������ ����͸�
			serverMain.area.append(msg+"\n");
			
			// msg�� Ŭ���̾�Ʈ ��û Ÿ�Կ� ���� �������� ���������� �޶��� �� �ִ�(�� ������ ä���� �ƴϴ�.)
			
			JSONParser jsonParser = new JSONParser();
			
			// �Ľ��� ���� ���� ���ʹ� ���ڿ��� �Ұ��ߴ� json������ �����͸� ��ġ ��üó�� ����� �� �ִ�!!
			JSONObject jsonObject=(JSONObject)jsonParser.parse(msg);
			
			// Ŭ���̾�Ʈ�� ��û�� �α����̶��...
			if(jsonObject.get("request").equals("login")){
				serverMain.area.append("�α����� ���ϴ±���?");
				// Ŭ���̾�Ʈ�� ��û�� ��ȭ���...
			}else if(jsonObject.get("request").equals("chat")){
				
				// Ŭ���̾�Ʈ�� ��û�� ȸ�������̶��....
			}else if(jsonObject.get("request").equals("regist")){
				
				
			}
			
			sendMsg(msg); // �ٽ� �����ϱ�!!
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
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
