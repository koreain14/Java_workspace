package com.sds.json;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ProfileApp2 {
	FileReader reader;
	BufferedReader buffr;

	public ProfileApp2() {
		String path = "C:/Java_workspace/GUI0811/res/member.json";
		try {
			reader = new FileReader(path);
			buffr = new BufferedReader(reader);

			String data = null;
			StringBuffer sb = new StringBuffer(); // 스트링을 누적!!
			while ((data = buffr.readLine()) != null) {
				// System.out.println(data);
				sb.append(data); // sb에 누적!! sb는 스트링이 아니다. 형변환 필요!
			}
			System.out.println(sb.toString());
			// 파싱시작
			
			JSONParser jsonParser = new JSONParser();
			try{
			JSONObject jsonObject = (JSONObject) jsonParser.parse(sb.toString());

			JSONArray jsonArray = (JSONArray) jsonObject.get("member");
			
			System.out.println(jsonArray.size());
			
		}catch(FileNotFoundException e){
			
		} catch (ParseException e) {
			System.out.println("Json문법 좀 공부해");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new ProfileApp();
	}
}
