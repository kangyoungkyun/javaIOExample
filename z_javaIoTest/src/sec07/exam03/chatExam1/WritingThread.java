package sec07.exam03.chatExam1;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

//서버로 메시지 보내는 Thread
public class WritingThread extends Thread{

	
	Socket socket = null;
	
	//채팅용 스케너
	Scanner scanner = new Scanner(System.in);
	
	
	//생성자
	public WritingThread(Socket socket) {
		//소켓 할당
		this.socket = socket;
	}

	
	@Override
	public void run() {
	
		System.out.println("WritingThread run!");
		
		try {
			// OutputStream - 클라이언트에서 Server로 메시지 발송
			OutputStream out = socket.getOutputStream();
			
			
			PrintStream writer = new PrintStream(out);
			
			//무한 반복
			while(true) {
				
				writer.println(scanner.nextLine());
				
			}
			
			
		//예외처리
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	
}
