package sec02.exam01.outputSteam_write;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class Write3 {

	public static void main(String[] args) throws Exception {
		
	/*
	 	FileOutputStream 객체의 write() 메소드 이용해서 파일에 문자 쓰기
	 */	
		
	OutputStream os	= new FileOutputStream("/Users/k/Documents/workspace/chat/src/test4.txt");
	
	//ABC 문자가 byte 타입 배열에 들어가 있다.
	byte[] data = "ABC".getBytes();
	
	//파일에 작성

	os.write(data , 1, 2);
	//BC 만 기록된다.

	os.flush();
	
	os.close();
	
	
	}

}
