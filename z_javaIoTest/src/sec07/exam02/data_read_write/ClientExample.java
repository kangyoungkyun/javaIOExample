package sec07.exam02.data_read_write;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClientExample {

	public static void main(String[] args) {

		
		Socket socket = null;
		
		
		
		try {
			
			
			socket = new Socket();
			System.out.println( "[연결 요청]");
			socket.connect(new InetSocketAddress("localhost" , 5000));
			System.out.println( "[연결 성공]");
			
			
			//데이터 출력 준비
			byte[] bytes = null;
			String message = null;
			
			//소켓으로 부터 출력 스트림 생성
			OutputStream os = socket.getOutputStream();
			message = "hi server - 안녕 서버!";
			bytes = message.getBytes("UTF-8");
			
			//출력 스트림에 데이터 쓰기
			os.write(bytes);
			
			//데이터 내보내기
			os.flush();
			
			System.out.println("데이터 보내기 성공");
			
			
			
			//소켓으로 부터 입력 스트림 생성
			InputStream is = socket.getInputStream();
			
			bytes = new byte[100];
			
			//입력 스트림으로 부터 바이트 읽기 
			int readByteCount = is.read(bytes);
			
			//읽은 바이트 문자열로 변환
			message = new String(bytes, 0, readByteCount);
			
			System.out.println("데이터 받기 성공 : " + message);
			
		
			os.close();
			
			is.close();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//소켓 닫기
		if(!socket.isClosed()) {
			
			try {
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

}

/*
[연결 요청]
[연결 성공]
데이터 보내기 성공
데이터 받기 성공 : hello client!
*/

