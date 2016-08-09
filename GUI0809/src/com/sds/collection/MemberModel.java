//JTable�� ������ ������ ��, ȸ�����õ� �����͸� ó���ϴ� TableModel
package com.sds.collection;

import javax.swing.table.AbstractTableModel;

public class MemberModel extends AbstractTableModel {
	String[] column={"��ȣ","�̸�","��й�ȣ","�̸���"};
	String[][] data={
			{"1��","ȫ�浿","0000","hong@naver.com"},
			{"2��","��浿","1111","kim@naver.com"},
			{"3��","�̱浿","2222","lee@naver.com"},
	};
	
	/* 
	 * tableModel�� ������ ��� �޼���� ��� JTable�� ���� ���̴�. �����ڰ� ȣ�� �ϴ� ���� �ƴ϶� JTable��
		ȭ�鿡 ������ �� ������ ȣ�� �Ѵ�.
	*/	

	public String getColumnName(int col) {
		System.out.println(col +"��° ������"+column[col]);
		return column[col];
	}
	
	// �� �÷��� ����
	public int getColumnCount() {
		return column.length;
	}

	// �� ���ڵ� ��
	public int getRowCount() {
		return data.length;
	}

	// �� �׸� ������ ������
	public Object getValueAt(int row, int col) {
		System.out.println(row+","+col);
		return data[row][col];
	}

}
