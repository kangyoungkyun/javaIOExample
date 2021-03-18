package sec05.exam01.support;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Q_DataInputOutputStreamExample {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		
		FileOutputStream fos = new FileOutputStream("/Users/k/Documents/workspace/chat/src/DataOutputStream.txt");
		
		DataOutputStream dos = new DataOutputStream(fos);
		
		dos.writeUTF("홍긴둥둥");
		dos.writeDouble(2.3);
		dos.writeInt(1);
		
		
		dos.writeUTF("콩민");
		
		dos.writeDouble(4.333);
		dos.writeInt(222);
		
		
		dos.flush();
		dos.close();
		fos.close();
		
		
		FileInputStream fis = new FileInputStream("/Users/k/Documents/workspace/chat/src/DataOutputStream.txt");
		DataInputStream dis = new DataInputStream(fis);
		
		
		for(int i = 0; i < 2; i++) {
			
			String name = dis.readUTF();
			double score = dis.readDouble();
			int order = dis.readInt();
			System.out.println(name + " : " + score + " : " + order);
		}
		
		
		dis.close();
		fis.close();
		
	}

	
	/*
	 *  홍긴둥둥 : 2.3 : 1
		콩민 : 4.333 : 222
	 */
	
}
