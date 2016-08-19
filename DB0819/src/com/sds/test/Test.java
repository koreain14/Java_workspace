package com.sds.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test {

	public static void main(String[] args) {
		// ������ ��ģ��!(�������� ����Ŭ ���ӽÿ� ��Ʈ��ũ�� ����Ǿ� �־�� �Ѵ�.)
		// java.sql ��Ű������ �����ͺ��̽� ���� Ŭ������ �����Ѵ�.

		// �����ͺ��̽��� ����
		String url = "jdbc:oracle:thin:@localhost:1521:XE";// �ϱ����
		String user = "java0819";
		String password = "java0819";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// � ������ ���̽� ��ǰ�� ������� �� ����̹��� �ε��ؾ��Ѵ�. �ϱ����
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("����̹� �ε� ����"); // ����̹� �ε�

			// ���ӽõ�!!
			// Connection �������̽��� ���� �õ� ��, ������ ��츸 �޸𸮿� �ö�´�!
			con = DriverManager.getConnection(url, user, password);
			if (con != null) {
				System.out.println("���Ӽ���");

				// ���ϴ� ������ ����!!
				// ���� ���� �������̽� ����Ͽ� �������� ��Ʈ��ũ�� �����Ѵ�!!
				String sql = "select * from topcategory";
				pstmt = con.prepareStatement(sql);

				// ���� ���� �޼���
				rs = pstmt.executeQuery();

				// ResultSet�� Ŀ����� ����Ʈ�� �����ϹǷ� ���ϴ� ���ڵ带 �����Ϸ��� Ŀ���� �Űܰ��� ����ؾ��Ѵ�.
				rs.next(); // �� row ����!
				rs.next(); // �� row ����!
				rs.next(); // �� row ����!
				rs.next(); // �� row ����!

				int id = rs.getInt("topcategory_id");
				String title = rs.getString("title");

				System.out.println(id + "," + title);

			} else {
				System.out.println("���ӽ���");
			}
		} catch (ClassNotFoundException e) {
			System.out.println("����̹� �ε� ����");
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// ���ѻ縦 �ݾƶ�!!
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
			if(con!=null){
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
