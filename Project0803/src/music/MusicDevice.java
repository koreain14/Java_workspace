/*
PM입장에서 사원들을 구속하기 위한 클래스 정의
*/
package music;
abstract public class MusicDevice{
	abstract public void setVolume();
    abstract public void playMP3(); // 미완성으로 남겨 놓아야 자식클래스에게 구현강제를 가할 수 있다.
}
