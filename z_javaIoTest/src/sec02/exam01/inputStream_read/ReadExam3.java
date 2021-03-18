package sec02.exam01.inputStream_read;

import java.io.FileInputStream;
import java.io.InputStream;

public class ReadExam3 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		
		InputStream is = new FileInputStream("/Users/k/Documents/workspace/chat/src/test.txt");
		
		
		//총 4바이트만 읽겠다.
		byte[] readBytes = new byte[4];
		
		//위에서 읽은 바이트 중 2번째 index 부터 시작해서 1번째 문자값만 읽겠다. 
		//나머지는 0
		
		is.read(readBytes, 2, 1);
		
		for(int i = 0; i < readBytes.length; i++) {
			
			System.out.print(readBytes[i]);
			//0 0 97 0
			
		}
		
		
		is.close();
		
	}

}
