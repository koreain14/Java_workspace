/*
스트림의 종류
방향성 - 입력, 출력
문자지원 여부 - 문자기반(2byte씩 묶어서 이해할 수 있는 스트림)
				- 바이트기반(1byte 씩만 이해할 수 있는 스트림)

*/
package com.sds.stream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DocumentReader {
	FileInputStream fis;
	FileOutputStream fos;
	FileReader reader;
	FileWriter writer;
	BufferedReader buffr; // 버퍼 처리된 문자기반의 입력스트림
	BufferedWriter buffw; // 버퍼 처리된 문자기반의 출력스트림

	String ori = "C:/Java_workspace/GUI0811/res/memo.txt";
	String dest = "C:/Java_workspace/GUI0811/res/memo2.txt";

	public DocumentReader() {
		try {
			reader = new FileReader(ori);
			writer = new FileWriter(dest);

			buffr = new BufferedReader(reader);
			buffw = new BufferedWriter(writer);

			String data = null;
			while ((data = buffr.readLine()) != null) {
				System.out.print(data);
				buffw.write(data);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new DocumentReader();
	}

}
