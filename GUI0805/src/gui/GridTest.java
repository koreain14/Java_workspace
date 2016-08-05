/*�ټ����� ��ġ������ �� GridLayout�� �н��Ѵ�.
 * grid : ����(����������) 
 * 			row(����ĭ��)=����, column(����ĭ��)=ȣ��
 * 
 * 		java.awt ��Ű���� os �÷����� ���� �������� �������̶� �̸� ������
 * 		GUI ��Ű���� ����Ѵ�.
 * */

package gui;
import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
public class GridTest {

	public static void main(String[] args) {
		Frame frame = new Frame();
		GridLayout layout=null;
		frame.setLayout(layout=new GridLayout(5,4));
		
		// ��ư 20���� �����Ͽ� ������ ��ư1, 2, 3.. �Ͻÿ�
		Button[] btn = new Button[20];
		for(int i=0;i<btn.length;i++){
			btn[i] = new Button("��ư"+i);
			frame.add(btn[i]);// �����ӿ� ��ư ����
		}		
		frame.setSize(300, 400);
		frame.setVisible(true);
	}	
}	
