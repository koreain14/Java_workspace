class  Rose{
    int leaf=0;
    String color="red";
    
    public void fall(){
       leaf=0;
    }
	// 개발자가 생성자를 정의하면, 컴파일러에 의해 정의되는 디폴트 생성자는 존재하지 않는다.
	public Rose(){
	}

	/*
	개발자가 생성자 메서드를 정의하지 않으면 컴파일시 에러가 발생할 수 있으므로,
	컴파일러에 의해 디폴트 생성자를 sun에서 삽입한다.
	public Rose(){}
	*/
}