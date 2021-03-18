package sec02.exam01.inputStream_read;

import java.io.FileInputStream;
import java.io.InputStream;

public class ReadExam2 {

	public static void main(String[] args) throws Exception{
		
		
	/*
	 	FileInputStream 객체의 read() 메소드 이용해서 파일의 문자 읽기
	 	new byte[3]; 객체를 이용해서 인풋스트림에서 여러개의 문자를 읽는다.
	 	is.read(바이트수 객체);
	 */
		
		//while문 
		int whileCount = 0;
		
		//인풋 스트림 구하기
		InputStream is = new FileInputStream("/Users/k/Documents/workspace/chat/src/test.txt");
		
		System.out.println("is : " + is); 
		//is : java.io.FileInputStream@2f7c7260
		
		int readByteNO;
		
		
		//인풋 스트림에서 읽을 바이트 수 (3글자씩 읽게 한다.)
		byte[] readBytes = new byte[3];
		
		
		//전체 문자열 저장 변수
		String data = "";
		
		
		while(true) {
			
			//인풋 스트림에서 readBytes 개수 만큼 읽기
			//읽은 바이트 수! 를 리턴한다.
			readByteNO = is.read(readBytes);
			
			
			//읽은게 없으면 -1 
			if(readByteNO == -1) {
				
				break;
			 
			 }else {
				 
				 whileCount += 1;
			 }
			
			//readBytes 배열의 0 인덱스 위치부터 readCharNo length만큼 String객체로 생성
			data += new String(readBytes, 0, readByteNO);
		}
				
		
		System.out.println(data);
		
		System.out.print("읽은 개수 : " + whileCount); 
		//읽은 개수 : 3
		
		//인풋 스트림을 마지막에는 닫아준다.
		is.close();

		
	}

}
