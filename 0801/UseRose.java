class  UseRose{
	public static void main(){
		/*
		클래스의 인스턴스 생성 시, new 연산자 뒤에 오게되는 메서드를 가리켜 생성자 메서드라고 한다!!
		
		new 연산자 뒤에 왜 생성자 메서드를 무조건 호출하고 있는가?
		- 메모리에 올릴 대상이 단순한 기본데이터가 아니라 객체 자료형일 경우 생성 시 복잡한 과정이 요구될
		수 있으므로 이 복잡한 과정을 처리할 메서드를 제공하려고!!
		즉 개발자로 하여금 객체 초기화의 기회를 주기 위해!!

		*/
	      Rose  r1=new Rose();   // (가)
	      r1.fall();   //(나) 
	      r1.bloom(); //(다)
	}
} 