package com.sds.movie.list;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import com.sds.main.AppMain;

public class MovieModel extends AbstractTableModel {
	ArrayList<String[]> list = new ArrayList<String[]>();
	
	String[] columnName = {"장르","영화제목","영화코드","개봉일","상영시간","이미지"};
	
	public MovieModel() {
		selectAll();
	}
	
	public int getColumnCount() {
		return columnName.length;
	}
	
	public String getColumnName(int col) {
		return columnName[col];
	}

	public int getRowCount() {
		return list.size();
	}

	public Object getValueAt(int row, int col) {
		String[] record=list.get(row);
		return record[col];
	}
	
	// 영화목록 가져오기
	public void selectAll(){
		Connection con=AppMain.getConnection(); // 공유된 메서드!!
		PreparedStatement pstmt=null; // 지역변수로 두는 이유, 쿼리문 마다 필요한 것이기 때문에!!
		ResultSet rs=null; // 메서드 내에서만 의미가 있기때문에!!
		
		String sql="select g.title as genre_title, m.title as movie_title, movie_id, open_day, showtime, img from movie m, genre g";
		sql = sql + " where m.genre_id=g.genre_id";
		
		try {
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			// 기존에 list 안에 들어있는 데이터를 비우고*****
			list.removeAll(list);
			
			while(rs.next()){
				// 레코드 1건 당 일차원 배열 1개로 담아야한다!
				// while 문 한번 돌 때 레코드 한건 들어감!!
				String[] record = new String[6];
				record[0]=rs.getString("genre_title");
				record[1]=rs.getString("movie_title");
				record[2]=Integer.toString(rs.getInt("movie_id"));
				record[3]=rs.getString("open_day");
				record[4]=Integer.toString(rs.getInt("showtime"));
				record[5]=rs.getString("img");
				
				list.add(record);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt!=null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		
		// 조인시 주의할 점, 조인 대상 테이블에 컬럼명이 동일할 경우 반드시 그 소유권을 명시해야한다.
		
		System.out.println(sql);

		// 모든 레코드 가져오기!!
		
	}
}
