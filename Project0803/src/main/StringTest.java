/*
String Ŭ������ Ư¡
1. �Һ��̴�. ���� String�� ���� ����ϸ� �޸� ȿ������ ��������.
--> ���� �� ������ Constant Pool�� ��ü�� �������� �ߺ��� ��Ʈ���� �ִٸ�
	��Ȱ���Ѵ�!
*/

/*
�ڹ��� ��� Ŭ������(�����ڰ� ������ Ŭ�����̰�) sun�� �����ϴ�  api �̰� ��� object���
������ü�� ��� �޴´�!!
*/
package main;

class StringTest{
	public void test(){
		boolean b=this.equals("���ѹα�");
	}
	public static void main(String[] args) {
		String a="���ѹα�";
		String b="���ѹα�";
		System.out.println(a.equals(b));	
	}
}
