package com.sds.chatting;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatB extends JFrame implements KeyListener{
	JTextArea area;
	JPanel p;
	JTextField txt;
	JScrollPane scroll;
	ChatA chatA;

	// �����ڵ� �޼����̹Ƿ� �Ʒ��� �ڵ尪�� ����� �����ϴ�! �ּҰ��� �ҷ����� ���� �Լ�!!
	// �� �����ڸ� ȣ���ϴ� �ڴ� ChatA�� �ν��Ͻ��� �Ѱܾ� �Ѵ�.
	public ChatB(ChatA chatA) {
		this.chatA=chatA;
		area = new JTextArea();
		p = new JPanel();
		txt = new JTextField(15);
		scroll = new JScrollPane(area);

		// ���Ϳ� area����
		add(area);
		// �гο� ��ư, txt ����
		p.add(txt);

		add(p, BorderLayout.SOUTH);
		
		// txt�� �����ʿ��� ����
		txt.addKeyListener(this);

		setBounds(400, 200, 300, 400);
		setVisible(true);
				
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_ENTER){
			String msg=txt.getText();
			area.append(msg+"\n");
			chatA.area.append(msg+"\n");
			txt.setText("");
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	

}
