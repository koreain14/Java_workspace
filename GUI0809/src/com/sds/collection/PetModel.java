//JTable�� ������ ������ ��, �ְ� ���� �����͸� ó���ϴ� TableModel
package com.sds.collection;

import javax.swing.table.AbstractTableModel;

public class PetModel extends AbstractTableModel {
	// �Ʒ��� ��� �޼���� JTable�� ȣ���ϴ� �޼����̴�!!
	
	String[] column={"�̸�","����","����"};
	String[][] data={
			{"�ٷ���","�߹���","�ϳ�"},
			{"�ǻ�","�����","�ϳ�"},
			{"����","��Ʈ����","����"},
	};
	
	public String getColumnName(int col) {
		return column[col];
	}
	
	public int getColumnCount() {
		return column.length;
	}

	public int getRowCount() {
		return data.length;
	}

	public Object getValueAt(int row, int col) {
		return data[row][col];
	}
	

	
}
