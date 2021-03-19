package sec07.exam01.server_socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClientExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Socket socket = null;
		
		try {
			//소캣 객체 생성
			socket = new Socket();
			
			System.out.println("[연결 요청]");
			
			//연결
			socket.connect(new InetSocketAddress("localhost" , 5001));
			
			System.out.println("[연결 성공]");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		//클라이언트 소켓이 안닫혔으면 
		if(!socket.isClosed()) {
			
			try {
				//클라이언트 소켓 닫기
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
 */

