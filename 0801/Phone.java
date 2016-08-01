/*
	일반적인 프로그래밍 언어에서, 개발자가 변수명과 메서드 명을 정할 때, 상당한 고민을 하게된다!
	직광성을 부여해야 유지보수가 쉬워지기 때문에! (나 아닌 타 개발자가 소스를 같이 개발할 수 있기 때문에)

	이 경우 문제점, 기능이 상당히 유사함에도 불구하고 메서명을 무조건 다르게 주어야 한다면 개발자는
	명명규칙을 정하느라 상당한 시간을 낭비하게 될 것이아. 또한 개발의 효율성이 떨어질 것이다!

	해결책) 기능이 상당히 유사하다면 메서드명을 동일하게 정의 할 수 있는 기법이 허용된다!!

	C# 및 자바언어의 이러한 메서드 정의기법을 가리켜서 메서드 오버로딩(method overloading) - 메서드 중첩

	주의) 메서드 명 뿐만 아니라 메서드 선언자체가 완전 동일하면 그것은 에러사항이다!!
	따라서 컴파일러가 적어도 구분할 수 있는 방법을 제공해야 하는데 메서드의 매개변수의 갯수와 자료형을 
	틀리게 해야함!!
*/

class Phone{
	//전화를 걸다!
	
	public void call(){
		System.out.println("전화를 겁니다");
	}
	// 해외로 전화를 걸다
	public void call(){
		System.out.println("해외로 전화를 겁니다");

	}
	public static void main(String[] args){
		Phone p = new Phone();
		p.call();
	}

}
