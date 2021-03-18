package sec04.exam01.file;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileExample {

	public static void main(String[] args) throws Exception {
		/*
		
		File 클래스
		IO 패키지에서 제공하는 File 클래스는 파일 크기, 파일 속성, 파일 이름 등의 
		정보를 얻어내는 기능과 파일 생성 및 삭제 기능을 제공한다.
		! 파일의 데이터를 읽고 쓰는 기능은 제공하지 않는다!
		 
		 */
		
		
		// 파일 객체 생성
		File dir = new File("/Users/k/Documents/workspace/chat/src/test");
		
		File file1 = new File("/Users/k/Documents/workspace/chat/src/file1.txt");
		File file2 = new File("/Users/k/Documents/workspace/chat/src/file2.txt");
		File file3 = new File(new URI("file:///Users/k/Documents/workspace/chat/src/file3.txt"));
		
		
		//위의 파일 객체 경로가 없으면 생성
		if(dir.exists() == false) {dir.mkdirs();}
		if(file1.exists() == false) {file1.createNewFile();}
		if(file2.exists() == false) {file2.createNewFile();}
		if(file3.exists() == false) {file3.createNewFile();}
		
		
		//출력할 디렉토리 경로
		File temp = new File("/Users/k/Documents/workspace/chat/src");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a HH:mm");
		
		
		//파일객체 경로에 존재하는 파일 및 디렉토리 출력 
		
		File[] contents = temp.listFiles();
		
		System.out.println("날짜              시간         형태       크기    이름");
		System.out.println("-------------------------------------------------------------------");
		
		
		for(File file : contents) {
			System.out.println(sdf.format(new Date(file.lastModified())));
			
			//디렉토리면
			if(file.isDirectory()) {
				
				System.out.print("\t<DIR>\t\t\t" + file.getName());
				
			//파일이면
			}else {
				System.out.print("\t\t\t" + file.length() + "\t" + file.getName());
			}
			
			System.out.println();
		}
		
	}

}
