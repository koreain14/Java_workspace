/*자바를 포함해서 대부분의 응용프로그램에서는 GUI 컴포넌트를 윈도우에 
 * 올려 놓을 때 배치 방법을 결정지을 수 있는 기능을 지원한다.
 * 자바는 LayoutManager라는 객체를 지원하고 다음과 같이 유형에 알맞는
 * 배치관리자(LayoutManager)를 선택해서 사용하면 된다. 
 * 
 * 1. BorderLayout(동, 서, 남, 북 센터의 범위가 방위가 지원되는 배치관리자)
 * 2. FlowLayout(컴포넌트들을 윈도우의 크기 조절에 따라 흐르도록 처리하는 배치관리자)
 * 3. GridLayout(격자 모양으로 컴포넌트를 배치하는 배치관리자)
 * 4. GridBagLayout(GridLayout의 기능을 보다 세부적으로 처리하는 배치관리자)
 * 5. CardLayout (화면에 보여질 컴포넌트를 오직 하나만 노출시키는 배치관리자)
 * */

package study.gui;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;

public class WindowTest {

	public static void main(String[] args) {
		Frame f = new Frame();
		
		Label la_id = new Label("ID"); 
		Label la_pw = new Label("PW");
		TextField t_id = new TextField(15);
		TextField t_pw = new TextField(15); 
		Button bt = new Button("로그인");
		
		// 프레임에 FlowLayout을 적용하자!!
		FlowLayout flow = new FlowLayout();
		f.setLayout(flow);
		
		f.add(la_id);//윈도우에 ID제목 부착
		f.add(t_id);//윈도우에 ID텍스트 부착
		f.add(la_pw);//윈도우에 pw제목 부착
		f.add(t_pw);//윈도우에 pw텍스트 부착
		f.add(bt);
		
		// 윈도우의 크기 설정 및 보이게 하기
		
		f.setVisible(true);
		f.setSize(200, 120);
	}
}
