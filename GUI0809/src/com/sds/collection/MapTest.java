/*
컬렉션 프레임웍 중 key와 value의 쌍으로 데이터를 관리하는 Map을 알아보자!!
키세스 초콜릿, 라벨을 달고 있다고 생각!!
객체를 모아서 처리하는데 편한 프레임웍
*/

package com.sds.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class MapTest {
	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<String, String>();

		map.put("m1", "사과");
		map.put("m2", "딸기");
		map.put("m3", "오렌지");
		map.put("m4", "멜론");

		Set<String> set = map.keySet();
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			String key = it.next();
			String fruit = map.get(key);

			System.out.println(fruit);
		}
	}

}
