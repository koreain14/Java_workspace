class Bird2{
   String name="��";
   boolean fly;
   public Bird(Boolean f){
       fly=f;
	}
}
class Duck extends Bird{
    String sound=��quack��;

	public Duck(){
		// ���� �¾�� �����̱� ������
		// �θ� �¾��
		// �θ��� ź������ �ռ��� �ڽ� �ʱ�ȭ�� ������ �� ����!
		super(true);
	}
}
class  UseTest{
	public static void main(String[] args){
        Bird b=new Bird(); (��) // �ʱ�ȭ ���� �־��־�� ��!
        b.sound="JJack JJack"; (��)
        Duck d=new Duck(); (��)
	}
}
