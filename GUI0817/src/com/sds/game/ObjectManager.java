/*
���� �����忡�� ȭ�鿡 ������ ������Ʈ���� ������ ó���ϴٺ��� ������������ �������� ������ 
�ϰ����̸鼭 ü�輺�ִ� ��ü�� ������ ���簡 �ʿ��ϰ� �� ��ü�� �̸��� ObjectManager�� �ϰڴ�.
*/
package com.sds.game;

import java.util.ArrayList;

public class ObjectManager {
	//���ӿ� �����ϰ� �� ��� ��ü�� ��� �� �÷���!
	ArrayList<GameObject> objectList =new ArrayList<GameObject>();
	
	// ȭ�鿡 ���� ��Ű�� = �÷��� �����ӿ��� �߰�
	public void addObject(GameObject gameObject){
		// �� �޼��带 ȣ���� ����� objectList�� �߰�!
		objectList.add(gameObject);
	}
	
	// ȭ�鿡�� �����ϱ� = �÷��� �����ӿ����� ����
	public void removeObject(GameObject gameObject){
		objectList.remove(gameObject);
	}
	
}
