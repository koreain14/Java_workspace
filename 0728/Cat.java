/*
Cat이라는 이름의 고양이 클래스를 정의하되,
이름, 나이, 종류를 멤버로 보유하시오..

특히 종류의 경우엔 static으로 선언하시오!

현재 클래스에 메인 실행부를 두되, 고양이의 이름, 나이, 종류를 출력하시오!

*/

class Cat{

	String name="Tom";
	int age=20;
	static String type="고양이과";

	public static void main(String[] args){
		int age=3;
		Cat c=new Cat();
		System.out.println(age);
		Cat.type="파충류";
	}
}