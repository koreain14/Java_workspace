//JTable에 보여질 데이터 중, 회원관련된 데이터를 처리하는 TableModel
package com.sds.collection;

import javax.swing.table.AbstractTableModel;

public class MemberModel extends AbstractTableModel {
	String[] column={"번호","이름","비밀번호","이메일"};
	String[][] data={
			{"1번","홍길동","0000","hong@naver.com"},
			{"2번","김길동","1111","kim@naver.com"},
			{"3번","이길동","2222","lee@naver.com"},
	};
	
	/* 
	 * tableModel이 보유한 모든 메서드는 모두 JTable을 위한 것이다. 개발자가 호출 하는 것이 아니라 JTable이
		화면에 보여질 때 스스로 호출 한다.
	*/	

	public String getColumnName(int col) {
		System.out.println(col +"번째 제목은"+column[col]);
		return column[col];
	}
	
	// 총 컬럼의 갯수
	public int getColumnCount() {
		return column.length;
	}

	// 총 레코드 수
	public int getRowCount() {
		return data.length;
	}

	// 각 항목에 보여질 데이터
	public Object getValueAt(int row, int col) {
		System.out.println(row+","+col);
		return data[row][col];
	}

}
