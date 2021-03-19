package sec07.exam02.data_read_write;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerExample {

	public static void main(String[] args) {

		
		ServerSocket serverSocket = null;
		
		
		
		try {
			
			
			serverSocket = new ServerSocket();
			
			
			System.out.println("serverSocket 1 : " + serverSocket);
			
			serverSocket.bind(new InetSocketAddress("localhost" , 5000));
			
			System.out.println("serverSocket 2 : " + serverSocket);
			
			while(true) {
				
				System.out.println("- 연결 기다림..");
				
				Socket socket = serverSocket.accept();
				InetSocketAddress isa = (InetSocketAddress)socket.getRemoteSocketAddress();
				
				System.out.println("연결 수락함 : " + isa.getHostName());
			

				//지연 테스트
				//팅 문자열 5번 출력 - 2초 간격
				for(int i = 0 ; i< 5; i++) {
					
					System.out.println("지연테스트 : 소켓 정보 : " + socket);
					try {
						
						//2초 간격
						Thread.sleep(2000);
						
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
				}
				
				
				
				
				//읽기 - 1
				
				byte[] bytes = null;
				String message = null;
				
				//소켓으로 부터 입력 스트림 객체 생성
				InputStream is = socket.getInputStream();
				
				//읽은 데이터 담을 바이트 변수 생성
				bytes = new byte[100];
				
				//입력 스트림 읽기  - 100 바이트 씩
				int readByteCount =	is.read(bytes);
				
				//바이트를 문자로 변환
				message = new String(bytes, 0, readByteCount , "UTF-8");
				
				System.out.println("- 데이터 받기 성공 : " + message);
				
				
				
				//쓰기 - 2
				
				//소켓으로 부터 출력 스트림 객체 생성
				OutputStream os	= socket.getOutputStream();
				message = "hello client!";
				bytes = message.getBytes("UTF-8");
				os.write(bytes);
				
				
				//내보내기
				os.flush();
					
				
				is.close();
				os.close();
				
				socket.close();
				
				System.out.println("소켓 종료 : socket.close()");
			}
			
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
		
		if(!serverSocket.isClosed()) {
			
			try {
				serverSocket.close();
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
		}
		
	}

}


/*
 
- 연결 기다림..
연결 수락함 : localhost
- 데이터 받기 성공 : hi server!
- 연결 기다림..
연결 수락함 : localhost
- 데이터 받기 성공 : hi server - 안녕 서버!
- 연결 기다림..
 
 */


