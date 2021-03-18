package sec05.exam01.support;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class P_BufferedInputStreamExample {

	public static void main(String[] args) throws Exception {
		
		
		/*
		 
		 입출력 성능에 영향을 미치는 입출력 소스
		 1. 하드 디스크, 2. 느린 네트워크
		 
		 버퍼를 이용한 해결
		 - 입출력 소스와 직접 작업하지 않고, 버퍼와 작업하므로 실행 성능을 향상
		 
		 프로그램은 쓰기 속도가 향상
		 버퍼가 차게되면 데이터를 한꺼번에 하드 디스크로 보내므로써 출력 횟수를 줄여줌.
		 
		 *바이트 기반 스트림 : BufferedInputStream , BufferedOutputStream
		 *문자 기반 스트림 : BufferedReader , BufferedWriter 
		 
		 BufferedInputStream : 바이트 입력 스트림에 연결되어 버퍼를 제공해주는 보조 스트림. 
		 BufferedReader : 문자 입력 스트림에 연결되어 버퍼를 제공해 주는 보조 스트림
		 
		 
		 */
		
		
		long start = 0;
		long end = 0;
		
		FileInputStream fis1 = new FileInputStream("/Users/k/Documents/workspace/chat/src/test/house.jpg");
		
		start = System.currentTimeMillis();
		
		while(fis1.read() != -1){}
		
		end = System.currentTimeMillis();
		
		System.out.println("사용하지 않았을때 : " + (end - start) + "ms");
		
		fis1.close();
		
		
		
		//바이트 입력 스트림
		FileInputStream fis2 = new FileInputStream("/Users/k/Documents/workspace/chat/src/test/house.jpg");
		
		//바이트 입력 스트림에 연결되어 버퍼를 제공해주는 보조 스트림. 
		BufferedInputStream bis = new BufferedInputStream(fis2); //버퍼 스트림 생성
		
		//bis = new BufferedInputStream(바이트 입력 스트림);
		
		start = System.currentTimeMillis();
		
		while(bis.read() != -1){}
		
		end = System.currentTimeMillis();
		
		System.out.println("사용했을 때 : " + (end - start) + "ms");
		
		fis2.close();
		
		
		
		/*
		 사용하지 않았을때 : 61ms
		 사용했을 때 : 12ms

		 */
		

	}

}
