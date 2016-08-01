class Duck{
	// 이름, 나이

	String name="도날드";
	static int age=3; // 클래스 변수!! 클래스 소속!!

	public void test(){
		System.out.println("오리의 나이는"+age);
	}
	
	public static void test2(){
		System.out.println("오리의 이름은"+name);
	}

	public static void main(String[] args){
	
		Duck d= new Duck();
		d.test();
	
	}
	
}