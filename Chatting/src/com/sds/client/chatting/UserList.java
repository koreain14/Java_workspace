package com.sds.client.chatting;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.sql.PreparedStatement;

import javax.swing.JPanel;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.sds.client.AppMain;

public class UserList extends JPanel{
	
	String[] path = {"profile.png","profile.png","profile_default.png","profile_default.png"};
	String[] status = {"오늘 비온다","춥다","배고프다","하하하"};
	
	public UserList() {
		setPreferredSize(new Dimension(400, 450));
		
		getList();
	}
	
	// 전체 회원목록 가져오기!!
	public void getList(){
		// 소켓을 통해 userlist요청하자!!
		StringBuffer sb = new StringBuffer();
		sb.append("{");
		sb.append("\"request\" :\"userlist\"");
		sb.append("}");
		
		try {
			AppMain.buffw.write(sb.toString()+"\n");
			AppMain.buffw.flush();
			
			// 서버로 부터 결과 받기!!
			String data=AppMain.buffr.readLine();
			System.out.println(data);
			
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject)jsonParser.parse(data);
			
			String result=(String)jsonObject.get("result"); // result가 ok일 때만 결과를 보여줘야 하므로
			
			if(result.equals("ok")){
				JSONArray jsonArray=(JSONArray)jsonObject.get("data"); // 데이터가 집단 형이기 때문에[]!!
			
				for(int i=0;i<jsonArray.size();i++){
					JSONObject obj=(JSONObject)jsonArray.get(i);
					Item item = new Item((String)obj.get("profile"), (String)obj.get("status"), (Long)obj.get("chatmember_id"));
					add(item);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
