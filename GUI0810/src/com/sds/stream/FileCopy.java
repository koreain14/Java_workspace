/*
������ �������� �ڹ� ���α׷����� �о�鿩 ���ϴ� ���丮�� ������Ű�� = ����

�ڹٿ����� ����°� ���õ� ����� java.io ��Ű������ �����ϸ� �� ���������� ���� ����� ���� ��� �� ������
������� �� io ó���� �ǽ��غ���!!
*/

package com.sds.stream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


class  FileCopy{
	FileInputStream fis; // ������ ������� �� �Է� ��Ʈ��
	FileOutputStream fos; // ������ ������� �� ��� ��Ʈ��
	String name = "C:/Java_workspace/GUI0810/res/mj.jpg";
	String dest = "C:/Java_workspace/GUI0810/res/mj_copy.jpg";

	public FileCopy(){
		// �Ʒ��� �ڵ�� ���� �� ������ ���ɼ��� �Ȱ� �ִ� �ڵ��̴�.
		// ���� �ùٸ��� ���� ��θ� �Ǽ��� ���� ���, ���α׷��� �ƹ��� ��å�� ����!
		// �׷��� ���α׷��� ���������ᰡ �Ǿ������! ���� ���������Ḧ ���Ѽ��� �ȵȴ�!!!
		// ����ó���� ������ �����ΰ�? ������������ ����!!

		try{
			fis = new FileInputStream(name);
			fos = new FileOutputStream(dest);
			int data; // �о�帰 �˰��� 1���� �ޱ� ���� ����!!
			while((data=fis.read()) !=-1){
				System.out.println(data);
				// �о���� �����͸� �� ���Ͽ� �������!
				fos.write(data); // 1byte ���!!
			}
		}catch(FileNotFoundException e){
			e.printStackTrace();
			System.out.println("�������� �ʴ� ��γ׿�");
		}catch(IOException e){
			System.out.println("������ �б� ����");
		}finally{
			/*
			 ����ó�� �� try���̰�, catch���̰� ����� ���� ������ ó���ؾ� �� ������ �ִٸ�
			 finally���� �۾������ �Ѵ�!! try, catch���� ���� ���๮�� �ݵ�� finally�� ����������!!
			 �ݵ�� ó���ؾ� �� �۾��� ���� �� �ִ�!
			 ��� �� ���� ��κ� db�ݴ� �۾�, ��Ʈ�� �ݴ� �۾��� �е������� ���� ����!!
			*/
			if(fos!=null){
				try{
					fos.close(); // ��Ʈ�� �ݱ�
				}catch(IOException e){
				}
			}
			if(fis!=null){
				try{
					fis.close(); // ��Ʈ�� �ݱ�
				}catch(IOException e){
				}
			}
		}
	}
	
	public static void main(String[] args){
		new FileCopy();
	}
}
