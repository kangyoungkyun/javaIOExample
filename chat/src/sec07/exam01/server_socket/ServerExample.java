package sec07.exam01.server_socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		ServerSocket serverSocket = null;
		
		
		
		try {
			
			//서버 소켓 객체 생성
			serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress("localhost" , 5001));
			
			
			while(true) {
				System.out.println( "[연결 기다림]");
				
				//연결 수락 후 소켓 생성
				Socket socket = serverSocket.accept();
				InetSocketAddress isa = (InetSocketAddress)socket.getRemoteSocketAddress();
				
				
				System.out.println("[연결 수락함]" + isa.getHostName());
				
			}
			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//서버 소켓이 안닫혀 있으면 닫아준다.
		if(!serverSocket.isClosed()) {
			
			try {
				
				serverSocket.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

}

/*
[연결 기다림]
[연결 수락함]localhost
[연결 기다림]
[연결 수락함]localhost
[연결 기다림]...
 */
