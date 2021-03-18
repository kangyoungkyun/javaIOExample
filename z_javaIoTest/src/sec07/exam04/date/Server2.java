package sec07.exam04.date;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Server2 {

	
	
	private int port = 4321;
	private Socket socket = null;
	private ServerSocket serverSocket= null;
	private DataOutputStream dos = null;
	
	
	
	public Server2() {
	
		
		try {
			
			//서버 소켓 생성
			serverSocket = new ServerSocket(port);
			
			System.out.println("Server 시작 on " + serverSocket.getLocalPort() + "...");
			System.out.println("클라이언트 기다리는 중...");
			
			//연결
			socket = serverSocket.accept();
			System.out.println("Client " + socket.getRemoteSocketAddress() + "connected to server - 연결완료..");
			
			
			//출력 스트림 생성
			dos = new DataOutputStream(socket.getOutputStream());
			
			
			//서버종료 안되게 무한 반복
			while(true) {
				
				//메시지 보내기
				String messageToClient = new Date().toString();
				dos.writeUTF(messageToClient);
				dos.flush();
			
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					
					
					
					System.out.println(" Broken pipe : dos.close()");
					break;
				}
				
			}
			

			//출력 스트림 닫기
			dos.close();
			//연결 종료
			socket.close();
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			System.out.println("error: " + e);
		}
		
		
	}
	
	
	
	public static void main(String[] args) {
		
		Server2 server1 = new Server2();
		
	}

}
