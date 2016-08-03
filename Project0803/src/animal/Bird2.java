class Bird2{
   String name="새";
   boolean fly;
   public Bird(Boolean f){
       fly=f;
	}
}
class Duck extends Bird{
    String sound=”quack”;

	public Duck(){
		// 덕이 태어나는 찰나이기 때문에
		// 부모가 태어나라
		// 부모의 탄생보다 앞서는 자식 초기화는 존재할 수 없다!
		super(true);
	}
}
class  UseTest{
	public static void main(String[] args){
        Bird b=new Bird(); (가) // 초기화 값을 넣어주어야 함!
        b.sound="JJack JJack"; (나)
        Duck d=new Duck(); (다)
	}
}
