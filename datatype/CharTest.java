/*
	문자 자료형에 대한 학습
	ocjp 시험!
*/
class CharTest{
	public static void main(String[] args){
		// 문자 자료형이란 사실상 존재하지 않는다. 어치피 문자는 숫자로 바뀌니까!!
		// 단 이 숫자의 목적은 연산수행의 목적이 아닌 키코드값과 매핑목적으로 사용해야 한다!

		char x='a';
		char y=3; //가장 좋아함!!
		char k=9;
		char z=-1; // 키코드 매핑이 목적이므로 음수는 지원하지 않는다.

		System.out.println(y+k);
	}
}