/*
	main() �޼����� �μ��� args�� ����غ���.
	��? �Ӹ� ��������!!
	main �����ڰ� ���� �� ������� ȣ���� �� �ִ� �޼��尡 �ƴ϶�,
	���ø����̼��� ���۵� �� ���� �ѹ� ȣ��Ǵ� �޼����̴�.
	java.exe ���Ͽ� ���� �ڵ� ȣ��!!
*/ 
package main;
class  MainTest{
	public static void main(String[] args){
		System.out.println("���α׷� ����� �Ѱܹ��� �μ��� ������" + args);
		for(int i=0;i<args.length;i++){
			System.out.println(args[i]);
		}
	}
}
