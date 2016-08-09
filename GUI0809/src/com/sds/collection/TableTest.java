/*
 * 스윙에서 데이터를 출력 및 관리하기 위한 용도로 지원되는 컴포넌트는 JTable이다!
 * 
 * JTable은 유지보수성을 높이기 위해 디자인과 모델(로직과 데이터)을 분리시킨 모델을 추가한다.
 * 따라서 JTable은 단지 데이터를 보여주는 창 역할만 하고 실제 보여줄 데이터를 결정할 데이터는 TableModel이다!
 * 
*/
package com.sds.collection;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

public class TableTest extends JFrame{
	JTable table;
	JScrollPane scroll;
	TableModel model; // 다형성!! ?? TableModel은 PetModel, MemberModel을 갖고 있음!
	
	public TableTest() {
		table = new JTable(model=new PetModel());
		scroll = new JScrollPane(table);
		
		add(scroll);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400, 300);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new TableTest();
	}

}
