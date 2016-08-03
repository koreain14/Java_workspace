/*
String 클래스의 특징
1. 불변이다. 따라서 String을 많이 사용하면 메모리 효율성이 떨어진다.
--> 따라서 이 문제를 Constant Pool에 객체를 생성시켜 중복된 스트링이 있다면
	재활용한다!
*/

/*
자바의 모든 클래스는(개발자가 정의한 클래스이건) sun이 제공하는  api 이건 모두 object라는
상위객체를 상속 받는다!!
*/
package main;

class StringTest{
	public void test(){
		boolean b=this.equals("대한민국");
	}
	public static void main(String[] args) {
		String a="대한민국";
		String b="대한민국";
		System.out.println(a.equals(b));	
	}
}
