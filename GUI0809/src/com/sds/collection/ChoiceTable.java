package com.sds.collection;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

public class ChoiceTable extends JFrame implements ItemListener {
	Choice cho;
	JPanel p;
	JScrollPane scroll;
	JTable table;
	TableModel model;

	public ChoiceTable() {
		cho = new Choice();
		p = new JPanel();

		table = new JTable(model);
		scroll = new JScrollPane(table);

		cho.add("�ְ�");
		cho.add("���");
		
		cho.addItemListener(this); // �̺�Ʈ �߰�!!

		p.add(cho);

		add(p, BorderLayout.WEST);
		add(scroll);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(700, 600);
		setVisible(true);

	}

	public void itemStateChanged(ItemEvent e) {
		Object obj=e.getItem();
		
		if(obj.equals("�ְ�")){
			table.setModel(model=new PetModel());
		}else if(obj.equals("���")){
			table.setModel(model=new MemberModel());
		}
		table.updateUI(); //UI ����!!!!!
	}

	public static void main(String[] args) {
		new ChoiceTable();
	}

}
