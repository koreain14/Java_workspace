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

	// 생성자도 메서드이므로 아래의 코드값도 충분히 가능하다! 주소값을 불러오는 것은 함수!!
	// 이 생성자를 호출하는 자는 ChatA의 인스턴스를 넘겨야 한다.
	public ChatB(ChatA chatA) {
		this.chatA=chatA;
		area = new JTextArea();
		p = new JPanel();
		txt = new JTextField(15);
		scroll = new JScrollPane(area);

		// 센터에 area부착
		add(area);
		// 패널에 버튼, txt 부착
		p.add(txt);

		add(p, BorderLayout.SOUTH);
		
		// txt와 리스너와의 연결
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
