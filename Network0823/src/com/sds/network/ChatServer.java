/*
�ڹ� ���� ��Ʈ��ũ ���α׷��� �ۼ��� �� ������
java.net ��Ű������ ��κ� �����Ѵ�.
*/
package com.sds.network;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
	ServerSocket server;
	InputStreamReader reader;
	BufferedReader buffr;
	
	OutputStreamWriter writer;
	BufferedWriter buffw;
	
	int port = 7777;//1~1024 ������ �̹� �ý����� �����ϴ� ��Ʈ�̹Ƿ� ����ؼ��� �ȵȴ�.	
	// �׸��� ����Ŭ, mysql �� �� �˷��� ����Ʈ������ ��Ʈ ��ȣ�� ���ذ����Ѵ�!!
	
	public ChatServer() {
		// server ����
		try {
			server = new ServerSocket(port);
			System.out.println("������Ĺ ����");
			
			// Ŭ���̾�Ʈ�� ������ �޾Ƶ��̴� �޼���
			// ����, �� �޼���� ������ ���� �� ���� �����¿� ������!
			Socket client=server.accept();
			String ip=client.getInetAddress().getHostAddress();
			
			System.out.println(ip+ "������ �߰�");
			
			//socket���� ���� Ŭ���̾�Ʈ�� ���õ� �������� ����ִ�. Ŭ���̾�Ʈ�� ip ����!!
			
			// ������ �ޱ�� ��Ʈ��
			InputStream is= client.getInputStream();
			reader = new InputStreamReader(is);
			buffr = new BufferedReader(reader);
			
			
			
			// ������ ��¿� ��Ʈ��
			OutputStream os=client.getOutputStream();
			writer = new OutputStreamWriter(os);
			buffw = new BufferedWriter(writer);
			
			String data=null;
			
			//****�����Ͱ� �Էµ� ������ ����(���Ѵ��)�� ������****//
			while(true){
				// û��
				data=buffr.readLine();
				System.out.println(data+"\n");
				
				// ����
				buffw.write(data);
				// ��½�Ʈ�� �迭�� ���� �� ��½�Ʈ�� ���� �����ϴ� �����͸� ��� ������Ѵ�!
				buffw.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new ChatServer();
	}
}
