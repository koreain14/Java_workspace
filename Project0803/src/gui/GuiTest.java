
package gui;
import java.awt.Frame;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.FlowLayout;
import java.awt.TextField;
import java.awt.TextArea;
import java.awt.Choice;



class  GuiTest{
	public static void main(String[] args) {

		// 모든 GUI 컴포넌트가 올려질 윈도우 창!
		// 자바에서 프레임은 디폴트속성이 존재하는데,
		// 기본이 안보이는 속성이다!! 따라서 보이게 하자!!
		Frame win = new Frame();
		win.setVisible(true); // 보이게 하기!!
		win.setSize(300, 400);
		win.setTitle("박성수");
		
		Button button = new Button("버튼");
	
		//버튼을 프레임에 부착!!
		win.add(button);


		// 자바 언어도 html처럼 각 컴포넌트를 부착하기에 앞서 어디에 어떻게 붙일지에 대한 디자인 기능이 지원된다.
		// 이 예제에서는 무시하고 가겠다!!
		FlowLayout flow=new FlowLayout();
		win.setLayout(flow);

		Checkbox[] ch = new Checkbox[20];
		for(int i=0;i<20;i++){
			Checkbox c= new Checkbox(i+"번째박스");
			ch[i]=c;
			win.add(ch[i]);
		}

		TextField tf = new TextField(10);
		win.add(tf);

		TextArea ta = new TextArea("박성수",20,50);
		win.add(ta);
		
		/*
			Choice[] cho = new Choice[12];
			for(int i=0;i<12;i++){
				Choice c2 = new Choice((i+1)+"월");
				cho[i]=c2;
				win.add(cho[i]);
			}
		*/

		Choice choice = new Choice();
		for(int i=1;i<=12;i++){
			choice.add(Integer.toString(i)); // i가 스트링이길 바란다!
		}
		win.add(choice);	
	}
}
