package gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/* �ڹٿ����� ���콺 ������ �̺�Ʈ�� click�̶�� �θ��� �ʴ´�. 
 * ActionEvent�� �Ѵ�!!
 * GUI ������Ʈ�󿡼� Ŭ���̺�Ʈ�� �߻��ϸ�, ���ϸ��� os�� �����Ͽ� �˸´�
 * ������ JVM�� �ѱ�� �������� JVM�� �ش� �̺�Ʈ�� �˸´� Event��ü��
 * �޸𸮿� �ø���.
 * ex) ���콺 Ŭ�� --> window ���� --> jvm���� --> ActionEvent ��ü �ν��Ͻ� ���� --> �����ʿ� ����
 * */
public class EventTest extends JFrame implements ActionListener{
	// has a ����� ��������� ������ �����Ͱ� ��ü���� ��
	JButton bt;
	JButton bt2;
		
	public EventTest(){
		bt=new JButton("����");
		bt2=new JButton("������");
		 		
		// ���� ���� layout ����
		setLayout(new FlowLayout());
		
		add(bt);
		add(bt2);
		
		//��ư�� �����ʿ��� ����!!
		bt.addActionListener(this);
		bt2.addActionListener(this);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300,400);
		setVisible(true);
	}
	@Override // jdk5���� �����ϴ� ������̼��̶�� �ּ�!!
	// �Ϲ��ּ��� Ʋ����, ���α׷� ����� ���� �� �ִ� �ּ�
	
	// �Ʒ��� �޼���� ����ڰ� ActionEvent�� ����ų ������ ȣ��ȴ�!
	// �׸��� �Ű������� �ش� ActionEvent �ν��Ͻ��� ���޵ȴ�!
	// �̺�Ʈ�� ����Ų ��ü ������Ʈ�� �ڹٿ����� �̺�Ʈ�ҽ���� �Ѵ�.
	// ���� ���� action �̺�Ʈ�� ����Ų ��ü�� ��ư�̹Ƿ�
	// ��ư�� �̺�Ʈ �ҽ��� �ȴ�.
	public void actionPerformed(ActionEvent e) {
		/*
		 * Action�̺�Ʈ�� �ݵ�� ��ư���� ������ �� �ִ� �̺�Ʈ�� �ƴմϴ�.
		�ٸ� ������Ʈ������ ActionEventƮ�� ����ų �� �ִ�.
		���� Sun������ ���� �߻��� �̺�Ʈ�� ��ư�� ���� ������ �ٸ� ������Ʈ�� ���� ������
		 ������ �� �����Ƿ� ���� ������ Object������ �޾ƹ�����.
		 */		
		Object obj=e.getSource();
		JButton btn=(JButton)obj; //Object --> JButton ����ȯ!!
		
		if(btn==bt){
			System.out.println("����������?");
		}else if(btn==bt2){
			System.out.println("���ഭ����?");
		}		
	}
		
	public static void main(String[] args) {
		new EventTest();
	}
}
