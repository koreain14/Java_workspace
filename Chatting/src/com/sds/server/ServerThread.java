/*
접속자마다 1:1로 요청을 처리하기 위한 서버측의 쓰레드!!
소켓을 보관한다 왜? 대화를 나누려고, 그리고 각종 요청처리를 위해서!!
*/
package com.sds.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.spi.DirStateFactory.Result;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ServerThread extends Thread{
	Socket client;
	BufferedReader buffr;
	BufferedWriter buffw;
	ServerMain serverMain;
	
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	StringBuffer sb = new StringBuffer();
	
	public ServerThread(ServerMain serverMain, Socket client) {
		this.serverMain = serverMain;
		this.client = client;
		con=serverMain.con;
		
		try {
			buffr = new BufferedReader(new InputStreamReader(client.getInputStream()));
			buffw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 듣고

	public void listen() {
		try {
			String msg = buffr.readLine(); // 규칙을 만들자! 로그인인지, 대화인지, 구매인지를 구분하기 위한!! 이것을 프로토콜!!
			// 로그인에서 보낸거 모니터링
			serverMain.area.append(msg+"\n");
			
			// msg는 클라이언트 요청 타입에 따라 서버측에 업무내용은 달라질 수 있다(즉 언제나 채팅은 아니다.)
			
			JSONParser jsonParser = new JSONParser();
			
			// 파싱한 이후 시점 부터는 문자열에 불과했던 json형식의 데이터를 마치 객체처럼 사용할 수 있다!!
			JSONObject jsonObject=(JSONObject)jsonParser.parse(msg);
			
			// 클라이언트의 요청이 로그인이라면...
			if(jsonObject.get("request").equals("login")){
				serverMain.area.append("로그인을 원하는군요?");
				
				// 쿼리문 수행
				String sql = "select * from chatmember where id=? and password=?";
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, (String)jsonObject.get("id"));
				pstmt.setString(2, (String)jsonObject.get("password"));
				
				rs=pstmt.executeQuery(); // 쿼리문이 select문일 경우!
				
				// StringBuffer 사용 전 비우기!
				sb.delete(0, sb.length()); // 데이터를 삭 지우는 것!! ?? 잘 모르겠다!!
				
				// rs를 문자열로 가공하여 보내주자!!
					sb.append("{");
					sb.append("\"response\":\"login\",");
				
				if(rs.next()){
					String name=rs.getString("name");
						sb.append("\"result\" : \"ok\",");
						sb.append("\"data\" : {");
						sb.append("\"name\" : \""+name+"\"");
						sb.append("}");
					}else{
						sb.append("\"result\" : \"fail\",");
						sb.append("\"data\" : {");
						sb.append("}");
					}
					sb.append("}");
					
					release(pstmt,rs);

				// 클라이언트의 요청이 대화라면...
			}else if(jsonObject.get("request").equals("chat")){
				
				// 클라이언트의 요청이 회원가입이라면....
			}else if(jsonObject.get("request").equals("regist")){
				
				
			}
			
			sendMsg(sb.toString()); // 다시 전송하기!!
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 말하고
	public void sendMsg(String msg) {
		try {
			buffw.write(msg + "\n");
			buffw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		while(true){
			listen();	
		}
	}
	
	// 데이터베이스 관련 객체 닫는 메서드!!
	// DML(insert, update, delete)
	public void release(PreparedStatement pstmt){
		if(pstmt!=null){
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	// select 문일 경우
	public void release(PreparedStatement pstmt, ResultSet rs){
		if(pstmt!=null){
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
