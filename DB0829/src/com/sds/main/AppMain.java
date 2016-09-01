/*
��ȭ ���� ���ø����̼�
*/

package com.sds.main;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.sds.movie.list.MovieList;
import com.sds.movie.regist.MovieRegist;
import com.sds.movie.reservation.Reservation;
import com.sds.movie.seat.SeatChoice;

public class AppMain extends JFrame implements ActionListener{
	String[] menuTitle = {"�󿵿�ȭ��","��ȭ���","���ų���","�¼�����"};
	JButton[] menu;
	JPanel p_north;
	JPanel[] content;
	JPanel center;
	Color[] bg={Color.red,Color.pink, Color.blue, Color.green};	
	
	// �����ͺ��̽� ���� ����....
	String driver="oracle.jdbc.driver.OracleDriver"; // ����̹� ����!!
	
	String url="jdbc:oracle:thin:@localhost:1521:XE";
	String user="java0819";
	String password="java0819";
	private static Connection con; // ����ȭ
	
	public AppMain() {
		connectDB();
		
		menu = new JButton[4];
		content = new JPanel[menu.length];
		
		p_north = new JPanel();
		p_north.setLayout(new GridLayout(1, menu.length));
		
		for(int i=0;i<menu.length; i++){
			menu[i] = new JButton(menuTitle[i]);
			p_north.add(menu[i]);
			menu[i].addActionListener(this);
		}
		// Ŭ�������� Ʋ������ ��� jpanel�� �ڽ��̴�!!
		content[0] = new MovieList();
		content[1] = new MovieRegist();
		content[2] = new Reservation();
		content[3] = new SeatChoice();
		
		// ������ ���� ��ü�� ���Ϳ���
		center = new JPanel();
		
		add(p_north,BorderLayout.NORTH);
		
		// ��� ������ ������ �гε��� �̸� �ٿ�����!!
		for(int i=0;i<menu.length;i++){
			center.add(content[i]);
			content[i].setPreferredSize(new Dimension(600, 500));
			//content[i].setBackground(bg[i]);
			content[i].setVisible(false);
			
		}
		add(center);
		
		// ù��° ����Ʈ ���̱�
		showContent(0);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if(con!=null){
					try {
						con.close(); // db ����
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
				System.exit(0);
			}
		});
		
		setSize(600, 500);
		setVisible(true);
	

	}
	
	public void connectDB(){
		try {
			Class.forName(driver); // ����̹� ȣ��!!
			con=DriverManager.getConnection(url,user,password); // ����!!
			if(con!=null){
				setTitle("���ӵ�");
			}else{
				setTitle("���� ����");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// ���ϴ� ������ ���̱�
	public void showContent(int current){
		for(int i=0;i<menu.length;i++){
			if(i==current){
				content[i].setVisible(true);
			}else{
				content[i].setVisible(false);
			}
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		Object obj=e.getSource();
		for(int i=0;i<menu.length;i++){
			if(obj==menu[i]){
				showContent(i);
			}
		}
	}
	
	public static Connection getConnection(){
		return con;
	}
	
	public static void main(String[] args) {
		new AppMain();
	}
}