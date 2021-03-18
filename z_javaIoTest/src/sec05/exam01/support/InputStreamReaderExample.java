package sec05.exam01.support;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class InputStreamReaderExample {

	public static void main(String[] args) throws Exception {
		
		//콘솔에서 한글 입력받기 : 소스 스트림이 바이트 기반 스트림이지만.
		//데이터가 문자일 경우 사용할 수 있다.
		//Reader 와 Writer는 문자 단위로 입출력하기 때문에 바이트 기반 스트림보다는 편리하다.
		//문자셋의 종류를 지정할 수 있기 때문에 다양한 문자를 입출력할 수 있다.
		
		
		//입력 스트림
		//소스 스트림이 바이트 기반 스트림이다. 데이터는 문자이다.
		InputStream is = System.in;
		
		
		//다른 스트림과 연결이 되어 여러가지 편리한 기능을 제공해주는 보조 스트림
		//문자변환, 입출력 성능향상, 기본 데이터 타입 입출력, 객체 입출력 등의 기능을 제공
		//InputStreamReader 는 바이트 입력 스트림에 연결되어 문자 입력 스트림인 Reader로 변환시키는 보조 스트림이다.
		Reader reader = new InputStreamReader(is);
		
		int readCharNo;
		
		
		char[] cbuf = new char[100];
		
		
		while((readCharNo = reader.read(cbuf)) != -1 ) {
			
			String data = new String(cbuf,0, readCharNo);
			System.out.println(data);
		}
		
		
		reader.close();
		
	}

}
