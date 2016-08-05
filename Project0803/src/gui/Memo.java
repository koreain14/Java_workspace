/*
메모장의 디자인만 따라하자!! 첫날이니깐!!
*/
package gui;
import java.awt.Frame;
import java.awt.MenuBar;
import java.awt.Menu;
import java.awt.TextArea;
import java.awt.MenuItem;


class  Memo{
	public static void main(String[] args) {
		//메모장 윈도우 선언
		Frame frame=new Frame();
		
		//메뉴바 선언
		MenuBar bar = new MenuBar();
		
		//메뉴들
		String[] menuTitle={"파일","편집","서식","보기","도움말"};
		Menu[] menu = new Menu[5];
		for(int i=0;i<menu.length;i++){
			menu[i]=new Menu(menuTitle[i]);
			bar.add(menu[i]); // 메뉴바에 부착!!
		}
		// 윈도우에 메뉴바 부착
		frame.setMenuBar(bar);

		//메뉴아이템들...
		String[] mi_file_title={"새로만들기","열기","저장"};
		MenuItem[] mi_file = new MenuItem[3];
		for(int i=0;i<mi_file.length;i++){
			mi_file[i]=new MenuItem(mi_file_title[i]);			
			menu[0].add(mi_file[i]);
		}

	
		//텍스트 부착
		TextArea area = new TextArea(30,40);
		frame.add(area);
		

		//윈도우 크기, 보이게하기!!
		frame.setSize(600,500);
		frame.setVisible(true);
	}
}
