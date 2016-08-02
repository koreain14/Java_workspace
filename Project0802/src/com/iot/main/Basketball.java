/*
1. 2개 이상의 멤버변수 정의
2. 2개 이상의 멤버 메서드 정의
3. package = com.iot.main;
4. main 메서드 없이 정의하기
5. class public으로 공개하기
6. 상대방의 .class를 넘겨받아 실행해보기
*/

package com.iot.main;

public class Basketball{
	private String name="Chicago Bulls";
	private String player="Jordan";
	
	public String getName(){
		return name;
	}

	public String getPlayer(){
		return player;
	}

}


