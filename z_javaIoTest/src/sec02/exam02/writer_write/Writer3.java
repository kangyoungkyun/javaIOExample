package sec02.exam02.writer_write;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Writer3 {

	public static void main(String[] args) throws Exception {
		
		//파일이 작성될 위치
		Writer writer	= new FileWriter("/Users/k/Documents/workspace/chat/src/test7.txt");
		
		char[] data = "aaabbbbfccc".toCharArray();
		
		System.out.print(data);
		//aaabbbbfccc
			
			
		//파일에 쓰기
		writer.write(data,1,2); //aa

		
		writer.flush();
		writer.close();
		
	}

}
