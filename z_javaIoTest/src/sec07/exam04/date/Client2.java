package sec07.exam04.date;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client2 {

	
	private String serverName = "localhost";
	private int serverPort = 4321;
	private Socket socket = null;
	private DataInputStream dis = null;
	
	
	
	public Client2() {
		
		try {
			
			//클라이언트 소캣 생성
			socket = new Socket(serverName, serverPort);
			System.out.println("Connected to server " + socket.getRemoteSocketAddress());
			
			
			//데이터 출력 스트
			dis = new DataInputStream(socket.getInputStream());
		
			
			//무한 반복
			while(true) {
				
				try {
					
					String messageFromServer = dis.readUTF();
					System.out.println("오늘 날짜 : " + messageFromServer);
					
				}catch(IOException e) {
					
					break;
					
				}

			}
			
			
			//출력 스트림 닫기
			dis.close();
			
			//입력 스트림 닫기
			socket.close();
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			System.out.println("error 1 : " + e);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			System.out.println("error 2 : " + e);
		}
		
		
	}
	
	
	public static void main(String[] args) {
		
		Client2 client1 = new Client2();
	}
	
	
	

}
