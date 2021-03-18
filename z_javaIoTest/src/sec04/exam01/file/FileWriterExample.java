package sec04.exam01.file;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterExample {

	public static void main(String[] args) throws Exception {
	
		//프로그램으로 부터 텍스트 파일을 쓸 때 사용
		//문자 단위로 쓰기 때문에 텍스트가 아닌 그림, 오디오, 비디오 등의 파일은 쓸 수 없다.
		File file = new File("/Users/k/Documents/workspace/chat/src/test_KOR.txt");

		FileWriter fw = new FileWriter(file,true);
		
		
		fw.write("FileWriter는 한글로된 " + "\r\n");
		fw.write("문자열을 바로 출력할 수 있다. " + "\r\n");
		fw.flush();
		fw.close();
		System.out.println("파일에 저장완료");
		
		
	}

}
