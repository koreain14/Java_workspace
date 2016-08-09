/*

�迭�� �����͸� �޸𸮿� �����ְ� �÷����� �뵵�δ� �Ǹ��ϴ�. ������  ��κ��� �������α׷�����
�迭�� ������ �ݵ�� �� ũ�⸦ ����ؾ��Ѵ�. ���δ� �� ��Ģ�� �������� ���ϴ�!

�ڹ� ������ ��ü�� ��Ƽ� ó���� �� ���� ȿ�������� ó���ϱ� ���� ��Ű���� �����Ǹ� �� ��Ű����
������ �÷��� �����ӿ�ũ��� �Ѵ�. ������ ���� �̺�Ʈ!!

�÷��������ӟp�� ����!
���� �ִ� ���� List�迭 / ���� ���� ���� Set�迭 �� �ڽ��� ����ϸ� �ȴ� / key_value �� ������ �̷���� : Map �迭

�÷��� �����ӿ�ũ�� java.util ��Ű������ ����!!

List_�����ִ� ���
: �迭�� ���� ����.
������: �迭�� �⺻�ڷ��������� �������������� List�� ������ �÷��� �����ӿ��� ����� ��ü������ �����ȴ�!
�迭�� ���� ��, �� ũ�⸦ ����ؾ������� �÷��� �����ӿ��� �������� �þ��! ���� ���� �� �� ũ�⸦ ����� �ʿ䰡 ����!

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
		list = new ArrayList<JButton>(); // ����Ʈ ����
		p_north = new JPanel();
		p_center = new JPanel();
		p_center.setBackground(Color.YELLOW);
		bt_create = new JButton("����");
		bt_color = new JButton("����");

		p_north.add(bt_create);
		p_north.add(bt_color);

		add(p_north, BorderLayout.NORTH);
		add(p_center);

		bt_create.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ��ư ����
				JButton bt = new JButton("����ư");
				p_center.add(bt);
				p_center.updateUI();

				// ������ ��ư�� ����Ʈ�� ����
				list.add(bt);
				System.out.println("����Ʈ�� ũ���?" + list.size());
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
