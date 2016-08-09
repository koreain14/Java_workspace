/*
 순서없이 모여있는 객체를 표현한 Set에 대하여 공부한다!
 Set의 하위 객체 중 HashSet을 학습하자!!
*/

package com.sds.collection;

import java.util.HashSet;
import java.util.Iterator;

import javax.swing.JButton;

public class SetTest {
	public static void main(String[] args) {
		//Generic Type: 컬렉션 프레임웍에 채워질 데이터형을 결정지을 수 있다.
		HashSet<JButton> set = new HashSet<JButton>();
		// JButton만 넣을 수 있는 HashSet!! 꺽쇠까지 통으로 자료형으로 보아라!!
		
		// auto boxing
		int x=3;
		// Integer i = new Integer(3); set은 객체를 좋아한다! 원래는 이 형태여야 함!!
		//set.add(x); // 원래 에러나야 한다! 근데 왜 안나나?
		// 컬렉션프레임웍의 메서드의 인수로 int를 포함한 기본자료형을 명시하면 자동으로 Wrapper
		// 객체로 변환되어진다. 왜? 개발자의 의도를 파악하여 번거롭지 않게 봐준거!! 3이라는 객체를
		// 넣은 꼴이다!!
		
		//set.add("사과"); // String 객체가 들어감
		set.add(new JButton("나버튼"));
		set.add(new JButton("너버튼"));
		set.add(new JButton("요버튼"));
		
		// 모든 객체의 배경색을 바꾸시오!
		Iterator it=set.iterator();
		
		// 반복문을 꼭 수치화시킬 필요는 없다!!
		while(it.hasNext()){
			JButton bt = (JButton)it.next();
			System.out.println(bt.getText());
		}
	}

}
