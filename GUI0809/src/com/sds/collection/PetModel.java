//JTable에 보여질 데이터 중, 애견 관련 데이터를 처리하는 TableModel
package com.sds.collection;

import javax.swing.table.AbstractTableModel;

public class PetModel extends AbstractTableModel {
	// 아래의 모든 메서드는 JTable이 호출하는 메서드이다!!
	
	String[] column={"이름","종류","성별"};
	String[][] data={
			{"다롱이","발발이","암놈"},
			{"뽀삐","삽살이","암놈"},
			{"웅이","리트리버","숫놈"},
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
