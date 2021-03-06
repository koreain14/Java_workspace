/*
게임 쓰레드에서 화면에 등장할 오브젝트들을 일일이 처리하다보면 유지보수성이 떨어지기 때문에 
일괄적이면서 체계성있는 객체를 관리할 존재가 필요하고 이 객체의 이름을 ObjectManager라 하겠다.
*/
package com.sds.game;

import java.util.ArrayList;

public class ObjectManager {
	//게임에 등장하게 될 모든 객체를 담게 될 컬렉션!
	ArrayList<GameObject> objectList =new ArrayList<GameObject>();
	
	// 화면에 등장 시키기 = 컬렉션 프레임웍에 추가
	public void addObject(GameObject gameObject){
		// 이 메서드를 호출한 사람은 objectList에 추가!
		objectList.add(gameObject);
	}
	
	// 화면에서 제거하기 = 컬렉션 프레임웍에서 제거
	public void removeObject(GameObject gameObject){
		objectList.remove(gameObject);
	}
	
}
