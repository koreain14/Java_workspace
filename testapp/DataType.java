/*----------------------------------------------------------------------------------------------
	변수에 데이터를 담아서 선언할 때는 반드시 변수가 담게 될 데이터의 용량을 표시해야 하는데
	이 용량 표시를 자료형이라고 한다.
	자료형의 종류!! 
	불편하기는 하지만 개발자가 메모리의 용량을 결정할 수 있다!

	1. 문자 : char(2byte) 16bit 2^16가지의 일
	2. 숫자 : byte(1byte) 
				<short(2byte)
				<int(4byte)
				<long(8byte)
	--> 1 byte= 8bit / 자바 자체에서 int로 바꾼다. 속도 때문에, 하지만 저장 개념에서는 필요!
	3. 논리값: boolean(1byte)

	mm(최소) ------cm
	g    (최소)-------kg
	bit(전기가 들어가고 안들어가고! 깜빡(0,1))-----byte

----------------------------------------------------------------------------------------------*/
class DataType{
	public static void main(String[] args){
		//문자 자료형!!(케릭터형)
		char c='대'; // 문자열이 아닌 하나의 문자는 홑따옴표

		//2byte 짜리 데이터가 총 네개 확보 = 8byte
		char[] arr=new char[4];
		arr[0]='대';
		arr[1]='한';
		arr[2]='민';
		arr[3]='국';

		char[] arr2={'아','메','리','카','노'};

		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]);
		}
		
		for(int i=0;i<arr2.length;i++){
			System.out.print(arr2[i]);
		}
		
		boolean m=true;
	}
}
