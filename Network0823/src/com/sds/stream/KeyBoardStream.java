/*
1.Stream 이란? 데이터의 흐름!

2.분류
	1) 방향성(실행중인 프로그램을 기준=프로세스)
		- 입력(Input)
		- 출력(Output)
	2) 데이터처리 방법	
		- 바이트 기반 스트림
		: 기본 스트림이며 1byte 씩 이해
		
		- 문자기반 스트림
		: 2byte씩 이해하는 스트림 / 비영어권 문자도 표현할 수 있다.
		
		- 버퍼기반 스트림
		: 데이터 단위의 끝을 발견할 때만 버퍼에 모아둔 데이터를 읽어들이도록 처리된 스트림!

*/
package com.sds.stream;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class KeyBoardStream {
	InputStream is;
	InputStreamReader reader;
	BufferedReader buffr;
	
	
	public KeyBoardStream() {
		// Keyboard, 바코드스캐너 등 시스템이 제어하는 스트림은 개발자가 원하는 시기에 마음대로 생성할 수 없다!
		// 따라서 시스템으로부터 얻어와야 한다!!
		is = System.in;
		reader = new InputStreamReader(is);
		buffr = new BufferedReader(reader);

		String data=null;
		int count=0;

		try {
			
			while(true){
				data=buffr.readLine();
				System.out.println(data);
				count++;
				System.out.print("읽혀진 횟수"+count);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new KeyBoardStream();
	}

}
