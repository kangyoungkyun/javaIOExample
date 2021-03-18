package sec02.exam02.reader_read;

import java.io.FileReader;
import java.io.Reader;

public class Reader3 {

	public static void main(String[] args) throws Exception {
		
		// FileReader객체의 read() 메소드 이용해서 파일의 문자 읽기
		Reader reader = new FileReader("/Users/k/Documents/workspace/chat/src/test.txt");
		
		int readCharNo;
		
		//4바이트 char 배열 생성
		char[] charBuf = new char[4];
		
		//FileReader 객체에서 읽은 문자열 중에서 4바이트 char 배열중 Index 1번 부터 2번째 까지만 읽기
		readCharNo = reader.read(charBuf, 1, 2);
		
		for(int i = 0 ; i < charBuf.length; i++) {
			System.out.println(charBuf[i]);
		}

		/*	  
			a
			b

		 */
		
		reader.close();
		
	}

}
