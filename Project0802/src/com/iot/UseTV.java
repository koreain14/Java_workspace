package com.iot.main;

class UseTV{

	public void getInfo(TV tv, int k){
		// 매개변수 tv의 인스턴스 하나를 넘겨서 해당 tv의 가격을 출력해보세요
		// getInfo를 호출 하세요!!
		tv.printPrice();
	}
	public void test(boolean b, int k){
		System.out.println(b+","+k);
	}
	
	// 아래의 메서드에서 tv가격을 출력!!
	public void showPrice(){
		TV tv=new TV();
		tv.printPrice();
	}
	public static void main(String[] args) {
		UseTV ut=new UseTV();
		ut.showPrice();
		ut.test(true,3);

		TV t=new TV();
		t.price=2000;

		ut.getInfo(t,0);
	}
}
