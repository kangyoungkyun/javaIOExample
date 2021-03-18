package sec04.exam01.file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class FileOutputStreamExample {

	public static void main(String[] args) throws Exception {
		
		
		String originFileName = "/Users/k/Documents/workspace/chat/src/test/house.jpg";
		
		String targetFileName = "/Users/k/Documents/workspace/chat/src/home.jpg";
		
		
		//파일로 부터 바이트 단위로 읽어 들일때 사용
		//두번째 방법
		
		//읽을 파일 객체 준비
		FileInputStream fis	= new FileInputStream(originFileName);
		
		
		//프로그램으로 부터 바이트 단위로 파일에 쓸때 사용
		//쓸 파일 객체 준비
		FileOutputStream fos = new FileOutputStream(targetFileName);
	
		
		int readByteNo;
		
		//읽을 바이트 수
		byte[] readBytes = new byte[100];
		
		//위의 바이트 수 만큼 읽는다.
		//readByteNo = fis.read(readBytes);

		
		//위의 바이트 수 만큼 읽는다.
		//읽은 값이 있으면 파일을 쓴다.
		while((readByteNo = fis.read(readBytes)) != -1) {
			
			System.out.println("readByteNo : " + readByteNo);
			//readByteNo : 100 .... 
			//readByteNo : 100 .... 
			
			fos.write(readBytes , 0 , readByteNo);
		}
		
		
		//파일 객체 닫기
		fos.flush();
		fos.close();
		fis.close();
		
		System.out.println("복사 성공");
		
	}

}
