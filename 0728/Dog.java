class Dog{

	String name="뽀미";

	/*
	인스턴스 초기화 블럭!!
	- 이 클래스로 부터 생성되는 인스턴스가 있을 때 마다 이 영역이 수행됨!
	*/
	
	/*
	클래스가 최초에 로드되어질 때 수행!!
	*/


	static{
		System.out.println("static 초기화 블럭수행");
	}
	
	// 클래스로부터 인스턴스가 생성될때마다 수행
	{
		System.out.println("인스턴스 초기화 블럭수행");
	}
	
	public static void main(String[] args){
		Dog d= new Dog(); 
		new Dog(); // 레퍼런스 변수가 없다! 저승사자가 올라오자마자 노려봄ㅡㅡ 이름이 없어 이후에 제어불가!!
	
	}
}