package sec02.exam01.inputStream_read;

import java.io.FileInputStream;
import java.io.InputStream;

//https://blog.naver.com/plateauh/222085091595
//https://estindev.tistory.com/entry/%EC%9E%90%EB%B0%94-IO-%EC%A0%95%EB%A6%AC
//https://willbfine.tistory.com/413?category=835334

public class ReadExam {

	public static void main(String[] args) throws Exception{
		
		
		/*
		    바이너리 기반 입력
		 	FileInputStream 객체의 read() 메소드 이용해서 파일의 문자 읽기
		 */
		
		//while문 
		int whileCount = 0;
		
		//인풋 스트림 구하기
		InputStream is = new FileInputStream("/Users/k/Documents/workspace/chat/src/test.txt");
		
		int readByte;
		
		//다읽을때 까지 while 문 돌기 - 7번 돈다.
		while(true) {
			
			 //읽은 문자값 (아스키 코드)97 98 99 ...
			//입력 스트림으로 부터 1바이트 읽고 읽은 바이트를 리턴한다.
			/*
			 read 메소드
			 입력 스트림으로 부터 1바이트 읽고 -> 4바이트 int 타입으로 리턴 
			 4바이트중 끝의 1바이트에만 데이터가 들어가 있다.
			*/
			 readByte = is.read();
			 //System.out.println(readByte);
			 
			
			 //읽은값이 없으면
			 if(readByte == -1) {
				 break;
			 
			 }else {
				 
				 whileCount += 1;
			 }
			 
			 //출력
			 //abcdefg
			 System.out.print((char)readByte);
		}
		
		System.out.print("읽은 개수 : " + whileCount);
		//읽은 개수 : 8
		
		is.close();
		
	}

}
