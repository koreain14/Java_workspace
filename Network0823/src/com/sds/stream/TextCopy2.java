package com.sds.stream;

import java.io.InputStream;
import java.io.IOException;

public class TextCopy2{
	InputStream is;

	public FileCopy(){
		is=System.in;
		int data;

		try{
			data=is.read();
			System.out.println(data);
		}catch(IOException e){
			e.printStackTrace();		
		}
			
	}

	public static void main(String [] args){
		new TextCopy2();
	}
}
