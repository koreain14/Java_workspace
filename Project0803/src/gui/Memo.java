/*
�޸����� �����θ� ��������!! ù���̴ϱ�!!
*/
package gui;
import java.awt.Frame;
import java.awt.MenuBar;
import java.awt.Menu;
import java.awt.TextArea;
import java.awt.MenuItem;


class  Memo{
	public static void main(String[] args) {
		//�޸��� ������ ����
		Frame frame=new Frame();
		
		//�޴��� ����
		MenuBar bar = new MenuBar();
		
		//�޴���
		String[] menuTitle={"����","����","����","����","����"};
		Menu[] menu = new Menu[5];
		for(int i=0;i<menu.length;i++){
			menu[i]=new Menu(menuTitle[i]);
			bar.add(menu[i]); // �޴��ٿ� ����!!
		}
		// �����쿡 �޴��� ����
		frame.setMenuBar(bar);

		//�޴������۵�...
		String[] mi_file_title={"���θ����","����","����"};
		MenuItem[] mi_file = new MenuItem[3];
		for(int i=0;i<mi_file.length;i++){
			mi_file[i]=new MenuItem(mi_file_title[i]);			
			menu[0].add(mi_file[i]);
		}

	
		//�ؽ�Ʈ ����
		TextArea area = new TextArea(30,40);
		frame.add(area);
		

		//������ ũ��, ���̰��ϱ�!!
		frame.setSize(600,500);
		frame.setVisible(true);
	}
}
