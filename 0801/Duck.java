class Duck{
	/*
	눈에 보이지는 않지만
	*/
	// 오리가 탄생할 때, 무언가 초기화 할 작업이 있다면 생성자 메서드의 기회를 놓치지말자!!
	String name;
	String color;

	/*
	this란 현재 디자인 타임의 클래스 기준이 아니라, 이 클래스 원본으로 부터 태어나는 인스턴스가
	자기 자신을 가리킬 수 있는 대명사!!
	*/ 	
		public Duck(){
		this.name="도날드";
		this.color="흰색";
		System.out.println(name+color +"가 태어나요!!");
	}
}