package sec02.exam02.reader_read;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

public class Reader2 {

	public static void main(String[] args) throws Exception {
		
		// FileReader객체의 read() 메소드 이용해서 파일의 문자 읽기

		
		
		Reader reader = new FileReader("/Users/k/Documents/workspace/chat/src/test.txt");
		
		int readCharNo;
		
		//2바이트 char 배열 생성
		char[] charBuf = new char[2];
		
		String data = "";
		
		while(true) {
		
			//FileReader 객체에서 파일을 읽고 반환값으로 아스키 코드 값을 리턴한다.
			//입력 스트림으로 부터 읽은 문자들을 매개값으로
			//주어진 문자 배열 cbuf[off] 부터 len 개 까지 저장한다.
			//실제로 읽은 문자 수인 len 개를 리턴한다.
			readCharNo = reader.read(charBuf);
			
			//읽은 문자가 없으면 -1 리턴
			if(readCharNo == -1) {break;}
			
			//charBuf 배열의 0 인덱스 위치부터 readCharNo length만큼 String객체로 생성
			data += new String(charBuf, 0, readCharNo);
			
		}
		
		
		System.out.print(data);
		//abcdefg
		reader.close();
		
	}

}
