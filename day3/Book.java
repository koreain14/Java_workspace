public class Book {
	int price; //A �������!!, �����ڰ� �� ���� �ʱ�ȭ���� ������ �����Ϸ��� ����
	// ����Ʈ������ �Ų�����!! --> 0����, �ּ������� �����ϱ� ����!!
	int page=300; 
	boolean onSale; //B
	
	public void test(){
		int price;// ��������: ���������� �ݵ�� �ʱ�ȭ �ؾ��Ѵ�!!
	}

	public static void main(String[] args) {
		price=500; //C
		Book b1 = new Book(); //D
		Book b2 = new Book(); //E
		
		b1.page=200; //
		System.out.println(b2.page);//F
	}
}
