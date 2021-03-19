package sec07.exam04.date;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Server1 {

	
	
	private int port = 4321;
	private Socket socket = null;
	private ServerSocket serverSocket= null;
	private DataOutputStream dos = null;
	
	
	
	
	public Server1() {
	
		
		
		try {
			serverSocket = new ServerSocket(port);
			
			System.out.println("Server 시작 on " + serverSocket.getLocalPort() + "...");
			
			
			socket = serverSocket.accept();
			System.out.println("Client " + socket.getRemoteSocketAddress() + "connected to server..");
			
			
			dos = new DataOutputStream(socket.getOutputStream());
			
			
			//메시지 보내기
			String messageToClient = new Date().toString();
			dos.writeUTF(messageToClient);
			dos.flush();
			
			
			dos.close();
			socket.close();
			
			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			System.out.println("error: " + e);
		}
		
		
	}
	
	
	
	public static void main(String[] args) {
		
		Server1 server1 = new Server1();
		
	}

}
