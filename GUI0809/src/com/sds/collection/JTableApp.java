package com.sds.collection;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.event.ItemListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class JTableApp extends JFrame implements ItemListener{
	JPanel p;
	Choice ch;
	JTable table;
	JScrollPane scroll;
	
	public JTableApp() {
		p= new JPanel();
		ch = new Choice();
		
		ch.add("애완동물");
		ch.add("회원정도");
		
		table = new JTable();
		scroll = new JScrollPane(table);
		
		add(p, BorderLayout.WEST);
		add(scroll);
		
		
		
		
	}
	
	public static void main(String[] args) {
		new JTableApp();
	}

}
