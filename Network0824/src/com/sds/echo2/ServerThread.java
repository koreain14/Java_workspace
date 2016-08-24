/*
 서버측에 듣고용 쓰레드!!
*/
package com.sds.echo2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Vector;

import javax.swing.JTextArea;

public class ServerThread extends Thread {
	Socket client;
	BufferedReader buffr;
	BufferedWriter buffw;
	JTextArea area;
	Vector<ServerThread> list;
	boolean flag=true; // 접속이 끊기면 쓰레드를 데드상태로 놓기위한 변수 즉!! while문을 멈출 것이다.

	public ServerThread(Socket client, JTextArea area, Vector list) {
		this.client = client;
		this.area = area;
		this.list = list;
		
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
			while(flag){
				String msg=buffr.readLine();
				// 모니터링 area에 출력!!
				area.append(msg+"\n");
				
				// 서버에 접속해 있는 모든 ServerThread 인스턴스의 sendMsg 메서드 호출!
				for(int i=0;i<list.size();i++){
					ServerThread st=list.get(i);
					st.sendMsg(msg);// 앞에 this가 생략되어 있다!!
				}
			}
		} catch (IOException e) {
			//e.printStackTrace();
			flag=false; // 무한루프에서 빠져나오자
			// 유저가 빠져나간 처리....
			list.remove(this);
			// 명단에서 제거...
			area.append("대화방을 나갔습니다, 남은 대화 참여자"+list.size()+"명");
		}
	}

	// 말하고
	public void sendMsg(String msg) {
		try {
			buffw.write(msg+"\n");
			buffw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 독립적으로 수행할 코드는 run에서 작성!!
	public void run() {
		listen();
	}
}
