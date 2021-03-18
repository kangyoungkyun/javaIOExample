package sec04.exam01.file;

import java.io.FileReader;


public class FileReaderExample {

	public static void main(String[] args) throws Exception {
		
		
		//텍스트 파일로부터 데이터를 읽어 들일 때 사용
		//문자 단위로 읽기 때문에 텍스트가 아닌 그림, 오디오, 비디오 등의 파일은 읽을 수 없다.
		FileReader fr = new FileReader("/Users/k/Documents/workspace/chat/src/test.txt");

		
		int readCharNo;
		
		
		char [] cbuf = new char[100];
		
		
		while((readCharNo = fr.read(cbuf)) != -1) {
			
			String data = new String(cbuf , 0, readCharNo);
			
			System.out.print(data);
			//abcdefg

		}
		
		
		fr.close();

	}

}
