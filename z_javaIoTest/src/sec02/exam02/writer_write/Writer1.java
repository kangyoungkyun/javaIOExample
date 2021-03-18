package sec02.exam02.writer_write;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Writer1 {

	public static void main(String[] args) throws Exception {
		
		//파일이 작성될 위치
		Writer writer	= new FileWriter("/Users/k/Documents/workspace/chat/src/test5.txt");
		
		char[] data = "aaabbbbfccc".toCharArray();
		
		//aaabbbbfccc 문자열 개수 만큼 돈다.
		for(int i =0 ; i < data.length; i++) {
			
			System.out.print(data[i]);
			//aaabbbbfccc
			
			//파일에 쓰기
			writer.write(data[i]);
		
			
		}
		
		writer.flush();
		writer.close();
		
	}

}
