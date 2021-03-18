package sec05.exam01.support;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class OutputStreamWriterExample {

	public static void main(String[] args) throws Exception {
		
		//바이트 출력 스트림
		FileOutputStream fos = new FileOutputStream("/Users/k/Documents/workspace/chat/src/OutputStreamWriter.txt");
		
		//문자 출력 스트림
		Writer writer = new OutputStreamWriter(fos);

		
		String data = "바이트 출력 스트림을 문자 출력 스트림으로 변환";
		
		writer.write(data);
		
		writer.flush();
		
		writer.close();
		
		fos.close();
		
		System.out.println("파일 저장 끝 - ");
		
	}

}
