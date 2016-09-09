/*
sax �Ľ̹���� �� �±׿�Ҹ� ��� �޸𸮿� �ø��� ����� �ƴ϶�, �� �±׿�Ұ� �߰ߵ� �� ����
�����ڿ��� �̺�Ʈ�� ���� �����Ѵ�. ���� �޸𸮿� �ö���� ��ü�� ���� ����. 
���� �����ڰ� �� �̺�Ʈ Ÿ�̹��� ��ġ�� �ʰ� ������ ó���� ����� �Ѵ�.
*/
package com.sds.xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.sds.table.MyModel;

public class MyHandler extends DefaultHandler {
	MyModel model;
	
	public MyHandler(MyModel model) {
		this.model=model;
	}
	
	public void startDocument() throws SAXException {
		System.out.println("������ �߰ߵǾ��׿�");
	}
	
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		System.out.print("<"+qName+">");
	}
	
	public void endElement(String uri, String localName, String qName) throws SAXException {
		System.out.println("</"+qName+">");
	}
	
	public void characters(char[] ch, int start, int length) throws SAXException {
		String data=new String(ch, start, length);
		System.out.print(data);
	}
}
