package sec02.exam02.reader_read;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

public class Reader1 {

	public static void main(String[] args) throws Exception {
		
		// 문자기반 입력
		// FileReader객체의 read() 메소드 이용해서 파일의 문자 읽기

		Reader reader = new FileReader("/Users/k/Documents/workspace/chat/src/test.txt");
		
		//4바이트 int
		int readData;
		
		while(true) {
		
			//FileReader 객체에서 파일을 읽고 반환값으로 아스키 코드 값을 리턴한다.
			//입력 스트림으로 부터 한개의 문자를 읽고 리턴한다.
			//한개의 문자(2바이트)를 읽고 4바이트 int 타입으로 리턴한다.
			readData = reader.read();
			
			//읽은 문자가 없으면 -1 리턴
			if(readData == -1) {break;}
			
			System.out.print((char)readData);
			//abcdefg
		}
		
		reader.close();
		
	}

}
