package sec07.exam03.chatExam1;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class MySocketClient {

	public static void main(String[] args) {
		
		try {
			
			
			Socket socket = null;
			socket = new Socket("localhost" , 1234);
			System.out.println("서버에 접속 성공!"); // 접속 확인용
			
			//서버에서 보낸 메시지 읽는 스레드
			ListeningThread t1 = new ListeningThread(socket);
			
			//서버로 메시지 보내는 스레드
			WritingThread t2 = new WritingThread(socket);
			
			
			t1.start();
			
			t2.start();
			
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
