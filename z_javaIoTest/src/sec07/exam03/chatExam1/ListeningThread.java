package sec07.exam03.chatExam1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ListeningThread extends Thread{

	
	Socket socket = null;

	//생성자 : 소켓 할당
	public ListeningThread(Socket socket) {
		
		// 받아온 Socket Parameter를 해당 클래스 Socket에 넣기
		this.socket = socket; 
	}
	
	
	@Override
	public void run() {
		
		System.out.println("ListeningThread run!");
		
		try {
			
			//InputStream - Server 에서 보낸 메시지를 클라이언트로 가져옴
			// socket의 InputStream 정보를 InputStream in에 넣은 뒤
			InputStream input = socket.getInputStream();
			
			// BufferedReader에 위 InputStream을 담아 사용
			BufferedReader reader = new BufferedReader(new InputStreamReader(input));
			
			
			//무한반복
			while(true){
				System.out.println(reader.readLine());
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
