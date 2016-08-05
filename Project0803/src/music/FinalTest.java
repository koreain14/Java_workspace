package music;
class  FinalTest{
	static int a=3;
	int c=5;

	public static void main(String[] args) {
		final int b=5; // 이후의 문장에서는 더이상 변수의 값을 수정할 수 없습니다.
		// 데이터를 수정의 목적이 아닌 참조의 경우 많이 사용한다!!
		b=10;
	}
}
