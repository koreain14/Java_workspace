package com.iot.main;

class MainTest{
	public void test(String[] k){
		System.out.println(k.length);
		for(int i=0;i<k.length;i++){
			System.out.println(k[i]);
		} 
	}
	public static void main(String[] args){
		MainTest mt=new MainTest();
		
		// �ڹٿ����� �迭 ������ �ݵ�� �� ũ�⸦ ����ؾ� �Ѵ�!!
		// �ڹٿ����� �迭�� ��ü��� �ϹǷ� �迭�� ����Ű�� ������ ���۷��� ������ ����!!!!!!!!!

		String[] arr=new String[3];
		arr[0]="���";
		arr[1]="����";
		arr[2]="������";
		mt.test(arr);
		
		//System.out.println("���� �� �迭�� ũ���"+ args.length);
	}
}