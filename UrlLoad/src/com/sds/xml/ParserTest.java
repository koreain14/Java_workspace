/*
�̱����� (�ý��� ����� �ٸ�) ������ ��ȯ�� ���� ���Ǵ� ������ �ؽ�Ʈ ��� �����ͺ��̽���
xml�� �ڹٿ��� ����غ���

�Ϲ����� ���α׷����� �Ľ��ϴ� ����� ũ�� �ΰ����� �ִ�.
1. DOM - html�� ������ �� �ִ� �������̽�!
			����: ��üȭ���� ������ �� �־ ��ü���� ��� ������� ���α׷��� �����ϴ�.
			����: �޸𸮸� ���� ����ϹǷ� Ư��, ����ϱ��� �Ҹ��ϴ�!
			
2. SAX - �� ����ΰ� �� �±׸� �߰��� �� ���� ������ �̺�Ʈ�� �߻��ϴ� ���.
 			���� �ڴ� �� �̺�Ʈ Ÿ�̹��� ��Ƴ��� ���ϴ� ó���� �������� ���!
 			����: �ӵ��� ������(�޸𸮸� �� ��� �Դ´�)
 			����: ���α׷��� ��ٷӴ�
*/
package com.sds.xml;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class ParserTest {
	// saxParser�� �߻�Ŭ�����̹Ƿ� ���� new�� �� ���� �Ʒ��� saxParserFactory ��ü�κ���
	// �ν��Ͻ��� ���;� �Ѵ�!
	SAXParserFactory factory;
	String path="C:/Java_workspace/UrlLoad/res/member.xml";
	MyHandler handler = new MyHandler();
	
	public ParserTest() {
		factory=SAXParserFactory.newInstance();
		try {
			SAXParser parser=factory.newSAXParser();
			
			// � ������ �ؼ�����, �̺�Ʈ ó���ڴ� �������� �����ϴ� ��!
			parser.parse(new File(path), handler);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new ParserTest();
	}
}






