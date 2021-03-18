package sec05.exam01.support;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class P_BufferedReaderExample {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

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
		
		//콘솔라인 입력 스트림
		InputStream is = System.in;
		Reader reader = new InputStreamReader(is);
		
		//BufferedReader를 사용해서 콘솔로 부터 라인 단위로 읽기
		BufferedReader br = new BufferedReader(reader);
		
		
		//br = new BufferedReader(문자입력 스트림);
		
		System.out.print("입력 : ");
		
		
		/*
		 * BufferedReade 는 readLine() 메소드를 추가적으로 가지고 있다.
		 * 이 메소드를 이용하면 \r , \n 로 구분된 행 단위의 문자열을 한꺼번에 읽을 수 있다.
		 * 
		 */
		
		String lineString = br.readLine();
		System.out.print("출력 : " + lineString);
		
	}

}
