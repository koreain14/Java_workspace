class Computer{
	int memory=256;

	public void turnOn(){
		System.out.println("��ǻ�͸� �մϴ�");
	}
	public static void main(String[] args){
		int k=5;
		Computer c=new Computer();
		System.out.println("k�� ����?"+k);
		System.out.println("c�� ����?"+c);

		// c�� k�ʹ� �ٸ��� �����͸� ���� ���� �ʰ�,
		// ��ü �������� �޸𸮻��� ��ġ �� �ּҰ�����
		// �����ϰ� �ִٰ� �Ͽ� reference(����) ������� �Ѵ�!!
	}

}