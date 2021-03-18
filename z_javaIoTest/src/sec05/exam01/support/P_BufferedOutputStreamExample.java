package sec05.exam01.support;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class P_BufferedOutputStreamExample {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		
		/*
		 * BufferedOutputStream 은 바이트 출력 스트림에 연결되어 버퍼를 제공해 주는 보조 스트림 
		 * BufferedWriter 는 문자 출력 스트림에 연결되어 버퍼를 제공해 주는 보조 스트림 
		 */
		
		
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		int data = -1;
		long start = 0;
		long end = 0;
		
		//바이트 스트림으로 읽어서
		fis	= new FileInputStream("/Users/k/Documents/workspace/chat/src/test/house.jpg");
		bis = new BufferedInputStream(fis);
		
		
		
		//바이트 스트림에 쓰기
		fos = new FileOutputStream("/Users/k/Documents/workspace/chat/src/test/kkk.jpg");
		
		
		start = System.currentTimeMillis();
		
		
		while((data = bis.read()) != -1) {
			
			//바이트 스트림에 쓰기
			fos.write(data);
		}
		
		
		fos.flush();
		
		end = System.currentTimeMillis();
		
		fos.close(); 
		bis.close(); 
		fis.close();
		
		System.out.println("사용하지 않았을 때: " + (end-start) + "ms");
		
		
		
		// ####################################################
		
		
		//바이트 스트림으로 읽어서
		fis	= new FileInputStream("/Users/k/Documents/workspace/chat/src/test/house.jpg");
		bis = new BufferedInputStream(fis);
		
		
		
		//바이트 스트림에 쓰기
		fos = new FileOutputStream("/Users/k/Documents/workspace/chat/src/test/kkk.jpg");
		
		//바이트 출력 스트림에 연결되어 버퍼를 제공해 주는 보조 스트림
		bos = new BufferedOutputStream(fos);
		
		start = System.currentTimeMillis();
		
		
		while((data = bis.read()) != -1) {
			
			//보조 바이트 스트림에 쓰기
			bos.write(data);
		}
		
		
		fos.flush();
		
		end = System.currentTimeMillis();
		
		fos.close(); 
		bis.close(); 
		fis.close();
		
		System.out.println("사용했을 때: " + (end-start) + "ms");
		
		
		/*
		 
		 사용하지 않았을 때: 221ms
		 사용했을 때: 3ms
		 
		 */
		
		
		
		
		
		
	}

}
