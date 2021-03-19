package sec07.exam04.date;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client1 {

	
	private String serverName = "localhost";
	private int serverPort = 4321;
	private Socket socket = null;
	private DataInputStream dis = null;
	
	
	
	public Client1() {
		
		try {
			
			
			
			socket = new Socket(serverName, serverPort);
			System.out.println("Connected to server " + socket.getRemoteSocketAddress());
			
			
			dis = new DataInputStream(socket.getInputStream());
			String messageFromServer = dis.readUTF();
			System.out.println("오늘 날짜 : " + messageFromServer);
			
			
			//입력 스트림 닫기..
			dis.close();
			
			//소켓 닫기..
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
		
		Client1 client1 = new Client1();
	}
	
	
	

}
