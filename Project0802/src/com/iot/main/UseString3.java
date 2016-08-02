package com.iot.main;

class UseString3{
	public static void main(String[] args){
		String s1=new String("apple");
		String s2="apple";
		String s3="apple";
		String s4=new String("apple");
		
		// String은 객체이므로 s2, s3는 레퍼런스 변수이다
		// 따라서 아래의 코드는 내용비교가 아닌 주소 비교이다!!
		// 아래의 코드가 true가 나오는 이유는 상수풀이라는 영역이 생성되기 때문에!
		// 상수풀의 특징은 중복된 상수가 있다면 재 생성하지 않는다!!

		System.out.println(s2==s3);

		// 스트링객체의 불변의 특징으로 인하여 자바의 String에는 누적이라는 개념은 존재하지 않는다.
		// immutal이라서 편집이 불가함!!
		// 해결책? 편집가능한 객체를 이용한다!!
		// 주의)String 클래스 아님

		StringBuffer b=new StringBuffer();
		b.append("korea");
		b.append("fighting");

		// String이 아니기 때문에 toString() 메서드로 변환시킨 후 , 출력하자!!
		System.out.println(b.toString());

		
	}
}
