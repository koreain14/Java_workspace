package com.iot.main;

class UseString4{
	public static void main(String[] args){
		String str="korea java";	
		String str2="photo.jpg";
		
		char c=str.charAt(3);
		int c1=str.indexOf("a");
		int c2=str.lastIndexOf("a");
		int c3=str.length();
		String c4=str.replace("korea","ÄÚ¸®¾Æ");
		String c5=str.substring(2,9);
		String c6=str.toUpperCase();

		String[] arr=str2.split("\\.");

		System.out.println(c);
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		System.out.println(c4);
		System.out.println(c5);
		System.out.println(c6);
		System.out.println(arr[0]);
		System.out.println(arr[1]);

	



	}
}