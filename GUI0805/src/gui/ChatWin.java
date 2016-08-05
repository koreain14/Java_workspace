/*java.awt�� os�÷������� (Linux, Mac, Window) �������� �ٸ���.
 * ���� �̸� ������ api�� Swing�� ����� ����.
 * 
 * Swing Ư¡
 * - javax.swing ��Ű������ ����
 * - ������Ʈ�� awt ���� ���� Button -->JButton
 * 
 * ����!! awt�� ���ؼ��� �ȵȴ�!
 * 			���������� �� �̿ܿ��� ������ ���ȴ�!!
 *			GUI ���α׷� ���߽� swing + awt ����  
 *
 *	�ڹ��� GUI ������Ʈ�� ���� ũ�� 2������ �ִ�.
 *1. (Container)���� �����ϴ� ������Ʈ 
 *		- JFrame(default BorderLayout)
 *		  JPanel(default FlowLayout) 
 *			- �ܵ����� ������ �� ���� �ݵ�� ������ �ȿ� �ҼӵǾ�� �Ѵ�.
 *			  Ư¡, ���� ������ �ʴ´�. ( div�� ���)
 *			  �ֿ뵵 frame ������ ������ ������ ���̾ƿ��� �����Ű�� ���� ��
 *       Applet(FlowLayout) 
 *
 *2. (Visual Component)���� ���ϴ� ������Ʈ 
 *		- JButton, JCheckbox, JTextArea ���
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
		JPanel panel; // ���ڻ���
		// �гο�  txt�� bt�� ����!
			
		public ChatWin(){
			super("ä��Ŭ���̾�Ʈ");
			area=new JTextArea();
			txt=new JTextField(20);
			bt=new JButton("����");
			panel=new JPanel();

				
			// area�� ���Ϳ� ����!!
			add(area, BorderLayout.CENTER);
			add(panel, BorderLayout.SOUTH);
			
			// ������ â�� ������, ���μ����� ���̱�!!	
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			
			setSize(300, 400);
			setVisible(true);

		}
		public static void main(String[] args) {
			new ChatWin();
	}
}
