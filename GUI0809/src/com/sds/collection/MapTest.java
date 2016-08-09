/*
�÷��� �����ӿ� �� key�� value�� ������ �����͸� �����ϴ� Map�� �˾ƺ���!!
Ű���� ���ݸ�, ���� �ް� �ִٰ� ����!!
��ü�� ��Ƽ� ó���ϴµ� ���� �����ӿ�
*/

package com.sds.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class MapTest {
	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<String, String>();

		map.put("m1", "���");
		map.put("m2", "����");
		map.put("m3", "������");
		map.put("m4", "���");

		Set<String> set = map.keySet();
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			String key = it.next();
			String fruit = map.get(key);

			System.out.println(fruit);
		}
	}

}
