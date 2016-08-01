public class Book {
	int price; //A 멤버변수!!, 개발자가 그 값을 초기화하지 않으면 컴파일러에 의해
	// 디폴트값으로 매꿔진다!! --> 0으로, 최소한으로 관여하기 위해!!
	int page=300; 
	boolean onSale; //B
	
	public void test(){
		int price;// 지역변수: 지역변수는 반드시 초기화 해야한다!!
	}

	public static void main(String[] args) {
		price=500; //C
		Book b1 = new Book(); //D
		Book b2 = new Book(); //E
		
		b1.page=200; //
		System.out.println(b2.page);//F
	}
}
