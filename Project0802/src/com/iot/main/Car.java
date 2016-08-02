/*
현실의 자동차를 만들되 제대로 만들자
*/
package com.iot.main;
// 클래스가 보유한 변수가 객체자료형일 경우 Car has a Wheel: has a 관계!!
public class Car{
	//바퀴;
	private Wheel w;
	private Engine e;
	private Handle h;
	private int price=100;
	
	//생성자를 정의하여 초기화 작업을 진행해보자!!
	public Car(){
		w=new Wheel();
		e=new Engine();
		h=new Handle();
		price=200;
	}
	public void go(){
		w.roll();
	}
}
