/*�ڹ��� GUI���� API���� java.awt ��Ű������ �����Ѵ�. Ư�� ������� ����
 * �ٸ� ������Ʈ���� ������ �� �ִ� ��ü�� ��ġ�� ������ ����ؾ� �ϸ� */
package gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;

public class BorderTest {

	public static void main(String[] args) {
		Frame frame=new Frame();
		
		Button bt_north=new Button("����");
		Button bt_west=new Button("����");
		Button bt_center=new Button("����");
		Button bt_east=new Button("����");
		Button bt_south=new Button("����");
		
		
		bt_north.setPreferredSize(new Dimension(200,400));
		
		// BorderLayout �� �����ϱ�
		BorderLayout layout = new BorderLayout();
		
		// Frame�� ���̾ƿ��� ��������!!
		// �����ڰ� ���̾ƿ��� ������ ������, �ش簴ü�� ����Ʈ ��ġ�����ڰ� ����ǰ�
		// Frame�� ��� ����Ʈ ��ġ�����۴�  BorderLayout�̴�! ���� BorderLayout�� ���
		// �����ڰ� ������ �������� ������ center �̴�!!
		
		//frame.setLayout(layout);
		frame.add(bt_north,BorderLayout.NORTH);
		frame.add(bt_west,BorderLayout.WEST);
		frame.add(bt_center);
		frame.add(bt_east,BorderLayout.EAST);
		frame.add(bt_south,BorderLayout.SOUTH);
		
		frame.setVisible(true);
		frame.setSize(300, 400);
		
	}

}
