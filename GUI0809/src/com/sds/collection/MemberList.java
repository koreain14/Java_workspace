package com.sds.collection;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

public class MemberList extends JFrame implements ActionListener {
	JLabel lb_id, lb_name, lb_pwd;
	TextField txt_id, txt_name, txt_pwd;
	JButton bt_left, bt_right;
	JPanel p;
	JTable table;
	JScrollPane scroll;
	Dimension d;
	TableModel model;
	TableData td;
	
	public MemberList() {
		lb_id = new JLabel("ID");
		lb_name = new JLabel("이름");
		lb_pwd = new JLabel("비번");

		txt_id = new TextField(15);
		txt_name = new TextField(15);
		txt_pwd = new TextField(15);

		bt_left = new JButton("등록");
		bt_right = new JButton("목록");

		p = new JPanel();
		table = new JTable(model = new TableData());
		scroll = new JScrollPane(table);

		p.add(lb_id);
		p.add(txt_id);
		p.add(lb_name);
		p.add(txt_name);
		p.add(lb_pwd);
		p.add(txt_pwd);
		p.add(bt_left);
		p.add(bt_right);
		
		bt_left.addActionListener(this);

		p.setPreferredSize(new Dimension(170, 600));

		add(p, BorderLayout.WEST);
		add(scroll);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800, 600);
		setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {
		String msg=txt_id.getText();
		
		String[] txt= {id,name,pwd };
		((TableData)model).list.add(txt);
	}

	public static void main(String[] args) {
		new MemberList();
	}

}
