package com.iot.main;

class UseString3{
	public static void main(String[] args){
		String s1=new String("apple");
		String s2="apple";
		String s3="apple";
		String s4=new String("apple");
		
		// String�� ��ü�̹Ƿ� s2, s3�� ���۷��� �����̴�
		// ���� �Ʒ��� �ڵ�� ����񱳰� �ƴ� �ּ� ���̴�!!
		// �Ʒ��� �ڵ尡 true�� ������ ������ ���Ǯ�̶�� ������ �����Ǳ� ������!
		// ���Ǯ�� Ư¡�� �ߺ��� ����� �ִٸ� �� �������� �ʴ´�!!

		System.out.println(s2==s3);

		// ��Ʈ����ü�� �Һ��� Ư¡���� ���Ͽ� �ڹ��� String���� �����̶�� ������ �������� �ʴ´�.
		// immutal�̶� ������ �Ұ���!!
		// �ذ�å? ���������� ��ü�� �̿��Ѵ�!!
		// ����)String Ŭ���� �ƴ�

		StringBuffer b=new StringBuffer();
		b.append("korea");
		b.append("fighting");

		// String�� �ƴϱ� ������ toString() �޼���� ��ȯ��Ų �� , �������!!
		System.out.println(b.toString());

		
	}
}
