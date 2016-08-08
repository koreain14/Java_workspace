/*
컴포넌트 중 Canvas를 상속받아 개발자가 주도하여 그림을 그려보도록 한다.
paint 메서드를 재정의해보자!!
*/
package com.sds.gallery;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class XCanvas extends Canvas {
	Toolkit kit = Toolkit.getDefaultToolkit(); // 추상클래스
	Image[] imgs; // 추상클래스
	String[] path = { "C:/Java_workspace/GUI0808/res/go.jpg", "C:/Java_workspace/GUI0808/res/go2.jpg",
			"C:/Java_workspace/GUI0808/res/go3.jpg", "C:/Java_workspace/GUI0808/res/go4.jpg",
			"C:/Java_workspace/GUI0808/res/go5.jpg", "C:/Java_workspace/GUI0808/res/go6.jpg",
			"C:/Java_workspace/GUI0808/res/go7.jpg", "C:/Java_workspace/GUI0808/res/go8.jpg",
			"C:/Java_workspace/GUI0808/res/gold.jpg", "C:/Java_workspace/GUI0808/res/haha.jpg"

	};
	int count=0;

	public XCanvas() {
		imgs = new Image[path.length];

		for (int i = 0; i < imgs.length; i++) {
			imgs[i] = kit.getImage(path[i]);
		}

	}

	public void paint(Graphics g) {
		g.drawImage(imgs[count], 0, 0, 700, 600, this);
	}
}
