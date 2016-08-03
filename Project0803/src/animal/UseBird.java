package animal;
class UseBird{
	public static void main(String[] args){
		//Duck d=new Duck();

		// 현실의 개념과 마찬가지로 자바에서도 상위 객체로 하위객체를 가리키는 것이 가능하다.
		//	Bird bird=new Sparrow();

		Bird b=new Sparrow();
		System.out.println(b.name);

		b.wing();
	}
}
