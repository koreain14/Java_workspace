package com.sds.stream;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.io.OutputStream;

import java.io.IOException;

public class TextCopy{
	InputStream is;
	OutputStream os;

	InputStreamReader reader;
	BufferedReader buffr;

	public TextCopy(){
		is=System.in;

		reader=new InputStreamReader(is);
		buffr=new BufferedReader(reader);
		
		String data=null;

		try{
			while(true){
				data=buffr.readLine();
				System.out.println(data);
				}
			}catch(IOException e){
			e.printStackTrace();		
		}
	}

	public static void main(String [] args){
		new TextCopy();
	}
}
