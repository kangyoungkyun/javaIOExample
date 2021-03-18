package sec02.exam01.outputSteam_write;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class Write1 {

	public static void main(String[] args) throws Exception {
		
	/*
	    바이너리 기반 출력
	 	FileOutputStream 객체의 write() 메소드 이용해서 파일에 문자 쓰기
	 */	
		
	OutputStream os	= new FileOutputStream("/Users/k/Documents/workspace/chat/src/test2.txt");
	
	//ABC 문자가 byte 타입 배열에 들어가 있다.
	byte[] data = "ABC".getBytes();
	
	//byte 배열의 개수만큼 돌면서 파일에 작성
	for(int i = 0 ; i < data.length; i++) {
		
		//출력 스트립으로 1바이트를 보낸다.
		os.write(data[i]);
	}

	//버퍼에 잔류하는 모든 바이트를 출력한다.
	os.flush();
	
	//사용한 시스템 자원을 반납하고 출력 스트림을 닫는다.
	os.close();
	
	
	}

}
