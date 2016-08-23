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
	Socket client; // ��ȭ�� ����(������, ��ȭ��)
	
	String ip="70.12.112.92";
	int port = 7776;
	
	BufferedReader buffr; // �Է¿�
	BufferedWriter buffw; // ��¿�
	
	public ChatClient() {
		area = new JTextArea();
		scroll = new JScrollPane(area);
		
		p_south = new JPanel();
		txt = new JTextField(15);
		bt = new JButton("����");
		
		p_south.add(txt);
		p_south.add(bt);
		
		add(scroll);
		add(p_south, BorderLayout.SOUTH);
		
		// ��ư�� ����!!
		bt.addActionListener(this);
		
		// �ؽ�Ʈ �ʵ�� ������ ����
		txt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				int key =e.getKeyCode();
				
				if(key==KeyEvent.VK_ENTER){
					// ������ �޼��� ������!!
					sendMsg();
				}
			}
		});
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300, 400);
		setVisible(true);
	}
	
	// ������ �����ϴ� �޼���
	
	public void connect(){
		// ip�� ��Ʈ��ȣ�� �̿��Ͽ� ������ ����!!
		try {
			client = new Socket(ip, port); // ������ �߻�!!
			buffr = new BufferedReader(new InputStreamReader(client.getInputStream()));
			buffw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
			System.out.println("ip�� Ȯ�����ּ���");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("��Ʈ��ũ ������ �߻��߽��ϴ�.");
		}
	}
	
	// ������ �޼��� ���� �޼���
	public void sendMsg(){
		String msg=txt.getText();
		try {
			// ������
			buffw.write(msg+"\n");
			buffw.flush();
			
			// �ް�
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
