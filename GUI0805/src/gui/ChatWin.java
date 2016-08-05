/*java.awt는 os플랫폼마다 (Linux, Mac, Window) 디자인이 다르다.
 * 따라서 이를 보완한 api인 Swing을 사용해 본다.
 * 
 * Swing 특징
 * - javax.swing 패키지에서 지원
 * - 컴포넌트가 awt 거의 동일 Button -->JButton
 * 
 * 주의!! awt를 욕해서는 안된다!
 * 			디자인적인 것 이외에는 아직도 사용된다!!
 *			GUI 프로그램 개발시 swing + awt 조합  
 *
 *	자바의 GUI 컴포넌트의 종류 크게 2가지가 있다.
 *1. (Container)남을 포함하는 컴포넌트 
 *		- JFrame(default BorderLayout)
 *		  JPanel(default FlowLayout) 
 *			- 단독으로 존재할 수 없고 반드시 프레임 안에 소속되어야 한다.
 *			  특징, 눈에 보이지 않는다. ( div와 흡사)
 *			  주용도 frame 내에서 별도의 개별적 레이아웃을 적용시키고 싶을 때
 *       Applet(FlowLayout) 
 *
 *2. (Visual Component)포함 당하는 컴포넌트 
 *		- JButton, JCheckbox, JTextArea 등등
 */

package gui;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatWin extends JFrame {
		JTextArea area;
		JTextField txt;
		JButton bt;
		JPanel panel; // 판자생성
		// 패널에  txt와 bt를 부착!
			
		public ChatWin(){
			super("채팅클라이언트");
			area=new JTextArea();
			txt=new JTextField(20);
			bt=new JButton("전송");
			panel=new JPanel();

				
			// area를 센터에 부착!!
			add(area, BorderLayout.CENTER);
			add(panel, BorderLayout.SOUTH);
			
			// 윈도우 창을 닫으면, 프로세스도 죽이기!!	
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			
			setSize(300, 400);
			setVisible(true);

		}
		public static void main(String[] args) {
			new ChatWin();
	}
}
