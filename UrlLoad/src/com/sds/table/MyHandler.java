package com.sds.table;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MyHandler extends DefaultHandler {
	MyModel model;
	String[] data;
	
	// ����ΰ� ��� �±׸� �������� �ִ����� üũ�� �� �ִ� ������ �����غ���!
	boolean name;
	boolean age;
	boolean gender;
	
	public MyHandler(MyModel model) {
		this.model=model;
	}
	
	// �����ױװ� �߰ߵǸ� ȣ��Ǵ� �޼���
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if(qName.equalsIgnoreCase("member")){
			System.out.println(qName);
			// �������迭�� �����!!
			data=new String[3];
		}
		if(qName.equalsIgnoreCase("name")){
			name=true;
		} else if(qName.equalsIgnoreCase("age")){
			age=true;
		} else if(qName.equalsIgnoreCase("gender")){
			gender=true;
		} 
	}
	
	// �±��� ���� �߰ߵǸ� ȣ��Ǵ� �޼���
	public void characters(char[] ch, int start, int length) throws SAXException {
		String str = new String(ch, start, length);
		//System.out.println(str);
		
		if(name){ // ����ΰ� Name�� ������ ���
			data[0]=str;
			name=false;
		} else if(age){// ����ΰ� age�� ������ ���
			data[1]=str;
			age=false;
		} else if(gender){// ����ΰ� gender�� ������ ���
			data[2]=str;
			gender=false;
		}
	}
	
	// �ݴ� �±׿� ���� �߰ߵǸ� ȣ��Ǵ� �޼���
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// �ѻ���� ������ �Ϸ�� �����̹Ƿ� List�� ž���Ű��!!
		if(qName.equalsIgnoreCase("member")){
			System.out.println("�ѻ�� ���� �ϼ�");
			model.list.add(data);
		}
	}
}
