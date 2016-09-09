package com.sds.table;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class MyModel extends AbstractTableModel{
	String[] columns={"이름","나이","성별"};
	ArrayList<String[]> list = new ArrayList<String[]>();
	
	// xml 파싱관련...
	SAXParserFactory factory;
	SAXParser parser;
	String path="C:/Java_workspace/UrlLoad/res/member.xml";
	MyHandler handler;
	
	public MyModel() {
		factory = SAXParserFactory.newInstance();
		handler=new MyHandler(this);
		startParsing();
	}
	
	// xml을 파싱하는 메서드
	public void startParsing(){
		try {
			parser=factory.newSAXParser();
			parser.parse(new File(path), handler);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		
	public int getColumnCount() {
		return columns.length;
	}
	
	@Override
	public String getColumnName(int col) {
		return columns[col];
	}

	public int getRowCount() {
		return list.size();
	}

	public Object getValueAt(int col, int row) {
		return list.get(col)[row];
	}
}
