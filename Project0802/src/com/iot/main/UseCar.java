package com.iot.main;
class UseCar{
	public static void main(String[] args){
		//�ڵ��� �Ѵ븦 �޸𸮿� �ø��� �� ���� ��� ��ǰ�� �޼��带 ȣ���غ�����!!
		Car c=new Car();
		// ��ü�� �޸𸮿� �ø��� �ʰ� ����Ϸ��� �ϸ� NullPointerException ������ �߻��Ѵ�!
		c.go();
	}
}
