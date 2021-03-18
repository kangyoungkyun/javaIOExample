package sec04.exam01.file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class FileInputStreamExample {

	public static void main(String[] args){
		
		//파일로 부터 바이트 단위로 읽어 들일때 사용
		//첫번째 방법
		FileInputStream fis;
		
		try {
			fis = new FileInputStream("/Users/k/Documents/workspace/chat/src/test.txt");
			
			int data;
			
			while( (data = fis.read()) != -1 ) {
				System.out.write(data);
				//abcdefg
			}
			
			//파일 닫기
			fis.close();
			
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
