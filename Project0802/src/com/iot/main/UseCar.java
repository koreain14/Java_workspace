package com.iot.main;
class UseCar{
	public static void main(String[] args){
		//자동차 한대를 메모리에 올리고 그 차의 모든 부품의 메서드를 호출해보세요!!
		Car c=new Car();
		// 객체를 메모리에 올리지 않고 사용하려고 하면 NullPointerException 에러가 발생한다!
		c.go();
	}
}
