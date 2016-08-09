/*

배열은 데이터를 메모리에 순서있게 올려놓는 용도로는 훌륭하다. 하지만  대부분의 응용프로그램에서
배열은 생성시 반드시 그 크기를 명시해야한다. 때로는 이 규칙은 유연하지 못하다!

자바 언어에서는 객체를 모아서 처리할 때 보다 효율적으로 처리하기 위한 패키지가 지원되며 이 패키지를
가리켜 컬렉션 프레임워크라고 한다. 오늘의 메인 이벤트!!

컬렉션프레임웤의 유형!
순서 있는 유형 List계열 / 순서 없는 유형 Set계열 의 자식을 사용하면 된다 / key_value 의 쌍으로 이루어진 : Map 계열

컬렉션 프레임워크는 java.util 패키지에서 지원!!

List_순서있는 모습
: 배열과 거의 같다.
차이점: 배열은 기본자료형까지도 지원가능하지만 List를 포함한 컬렉션 프레임웍의 대상은 객체만으로 한정된다!
배열은 생성 시, 그 크기를 명시해야하지만 컬렉션 프레임웍은 동적으로 늘어난다! 또한 생성 시 그 크기를 명시할 필요가 없다!

*/
package com.sds.collection;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CollectionTest extends JFrame {
	ArrayList<JButton> list;
	JPanel p_north, p_center;
	JButton bt_create, bt_color;

	public CollectionTest() {
		list = new ArrayList<JButton>(); // 리스트 생성
		p_north = new JPanel();
		p_center = new JPanel();
		p_center.setBackground(Color.YELLOW);
		bt_create = new JButton("생성");
		bt_color = new JButton("색상");

		p_north.add(bt_create);
		p_north.add(bt_color);

		add(p_north, BorderLayout.NORTH);
		add(p_center);

		bt_create.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 버튼 생성
				JButton bt = new JButton("나버튼");
				p_center.add(bt);
				p_center.updateUI();

				// 생성된 버튼을 리스트에 담자
				list.add(bt);
				System.out.println("리스트의 크기는?" + list.size());
			}
		});

		bt_color.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < list.size(); i++) {
					JButton bt = list.get(i);
					bt.setBackground(Color.GREEN);
				}
			}
		});

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600, 600);
		setVisible(true);

	}

	public static void main(String[] args) {
		new CollectionTest();
	}

}
