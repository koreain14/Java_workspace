/* 
���־� ������Ʈ���� sun���� �����ϰ� ������ �� ���ұ� ������ �����ڰ� �ֵ��Ͽ� �׷���
ó���� �� �ʿ䰡 ����. ������ ������Ʈ �� �����ڰ� �׷��� ó���� �ֵ��Ͽ� �� �� �ֵ���
�����ϴ� ������Ʈ�� �ִ�.
���� �� �� ����! Canvas, JPanel, JFrame ���
                       �� ĵ������ �����̳ʷ��� ��� ����!!
java awt���� imageŬ������ �Ϲ��� �ƴ� �߻�Ŭ�����̴�!
���� new �� �� ����.
�ذ�å) ��Ģ�� �߻�Ŭ������ �ڽĿ� ���� �ϼ��ǹǷ�, Image�� ��ӹ޾� �޼��带 ������
�� �� �ڽ� Ŭ������ �ν��Ͻ��� �ø� ��, �θ� �ö������ �ַ� sun���� �����ϴ� ��ü��
�߻��� ��� �ݵ�� �� ��Ģ��� ������ �ʿ�� ���� �س��� ��찡 ����!
�ַ�, �̹� �߻�Ŭ������ �ν��Ͻ��� ���������� ���ϰ� ���� �� �ִ� ����� �������ش�!
awt������ Toolkit�� �̿��Ͽ� �̹����� ������ش�!
*/
package com.sds.gallery;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class MyCanvas extends Canvas {
	Toolkit kit=Toolkit.getDefaultToolkit();
	
	// ������ ���� Toolkit�� �̿��Ͽ� �̹����� ���� �� �ִ�!
	Image img;
	public MyCanvas() {
		setBackground(Color.YELLOW);
		img=kit.getImage("C:/Java_workspace/GUI0808/res/go2.jpg");
	}

	public void paint(Graphics g) {
		g.drawRect(100, 100, 50, 50);
		g.drawString("�� �׸� ��Ʈ��", 100, 80);
		g.drawOval(100, 200, 50, 50);
		g.drawImage(img, 100, 300, this);
	}
}
