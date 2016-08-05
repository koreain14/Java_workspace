
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

		// ��� GUI ������Ʈ�� �÷��� ������ â!
		// �ڹٿ��� �������� ����Ʈ�Ӽ��� �����ϴµ�,
		// �⺻�� �Ⱥ��̴� �Ӽ��̴�!! ���� ���̰� ����!!
		Frame win = new Frame();
		win.setVisible(true); // ���̰� �ϱ�!!
		win.setSize(300, 400);
		win.setTitle("�ڼ���");
		
		Button button = new Button("��ư");
	
		//��ư�� �����ӿ� ����!!
		win.add(button);


		// �ڹ� �� htmló�� �� ������Ʈ�� �����ϱ⿡ �ռ� ��� ��� �������� ���� ������ ����� �����ȴ�.
		// �� ���������� �����ϰ� ���ڴ�!!
		FlowLayout flow=new FlowLayout();
		win.setLayout(flow);

		Checkbox[] ch = new Checkbox[20];
		for(int i=0;i<20;i++){
			Checkbox c= new Checkbox(i+"��°�ڽ�");
			ch[i]=c;
			win.add(ch[i]);
		}

		TextField tf = new TextField(10);
		win.add(tf);

		TextArea ta = new TextArea("�ڼ���",20,50);
		win.add(ta);
		
		/*
			Choice[] cho = new Choice[12];
			for(int i=0;i<12;i++){
				Choice c2 = new Choice((i+1)+"��");
				cho[i]=c2;
				win.add(cho[i]);
			}
		*/

		Choice choice = new Choice();
		for(int i=1;i<=12;i++){
			choice.add(Integer.toString(i)); // i�� ��Ʈ���̱� �ٶ���!
		}
		win.add(choice);	
	}
}
