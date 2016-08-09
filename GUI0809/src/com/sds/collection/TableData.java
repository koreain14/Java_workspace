package com.sds.collection;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class TableData extends AbstractTableModel {
	
	String[] column={"ID","이름","비번"};
	String[] data;
	
	public TableData() {
		data = new String[3];
		
	}
	
	public String getColumnName(int col) {
		return column[col];
	}
	
	public int getColumnCount() {
		return 3;
	}

	public int getRowCount() {
		return 0;
	}

	public Object getValueAt(int arg0, int arg1) {
		return null;
	}

}
