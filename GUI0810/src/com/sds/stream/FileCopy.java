/*
사진을 실행중인 자바 프로그램으로 읽어들여 원하는 디렉토리에 복원시키자 = 복사

자바에서는 입출력과 관련된 기능을 java.io 패키지에서 지원하면 이 예제에서는 여러 입출력 관련 기능 중 파일을
대상으로 한 io 처리를 실습해보자!!
*/

package com.sds.stream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


class  FileCopy{
	FileInputStream fis; // 파일을 대상으로 한 입력 스트림
	FileOutputStream fos; // 파일을 대상으로 한 출력 스트림
	String name = "C:/Java_workspace/GUI0810/res/mj.jpg";
	String dest = "C:/Java_workspace/GUI0810/res/mj_copy.jpg";

	public FileCopy(){
		// 아래의 코드는 실행 시 에러의 가능성을 안고 있는 코드이다.
		// 따라서 올바르지 않은 경로를 실수로 넣을 경우, 프로그램은 아무런 대책이 없다!
		// 그래서 프로그램은 비정상종료가 되어버린다! 절대 비정상종료를 시켜서는 안된다!!!
		// 예외처리의 목적은 무엇인가? 비정상종료의 방지!!

		try{
			fis = new FileInputStream(name);
			fos = new FileOutputStream(dest);
			int data; // 읽어드린 알갱이 1알을 받기 위한 변수!!
			while((data=fis.read()) !=-1){
				System.out.println(data);
				// 읽어들인 데이터를 빈 파일에 출력하자!
				fos.write(data); // 1byte 출력!!
			}
		}catch(FileNotFoundException e){
			e.printStackTrace();
			System.out.println("존재하지 않는 경로네요");
		}catch(IOException e){
			System.out.println("파일을 읽기 에러");
		}finally{
			/*
			 예외처리 시 try문이건, catch문이건 수행된 이후 무조건 처리해야 할 로직이 있다면
			 finally에서 작업해줘야 한다!! try, catch문을 지난 실행문은 반드시 finally를 지나가야함!!
			 반드시 처리해야 할 작업에 사용될 수 있다!
			 사실 상 거의 대부분 db닫는 작업, 스트림 닫는 작업에 압도적으로 많이 사용됨!!
			*/
			if(fos!=null){
				try{
					fos.close(); // 스트림 닫기
				}catch(IOException e){
				}
			}
			if(fis!=null){
				try{
					fis.close(); // 스트림 닫기
				}catch(IOException e){
				}
			}
		}
	}
	
	public static void main(String[] args){
		new FileCopy();
	}
}
