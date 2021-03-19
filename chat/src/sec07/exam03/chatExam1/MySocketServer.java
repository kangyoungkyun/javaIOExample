package sec07.exam03.chatExam1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/*
 
네트워크 프로그래밍(TCP 소켓) 스레드 병렬 처리
연결시, ServerSocket의 accept()를 실행하거나, 

서버 연결 요청을 위해 Socket 생성자 또는 connect()를 실행할 경우 해당 작업이 완료되기 전까지 블로킹(blocking)된다.

데이터 통신시에도 InputStream, OutputStream의 read(), write() 메소드는 작업이 끝날 때 까지 블로킹된다.

=> 결론적으로 ServerScoket과 Socket은 동기(블로킹) 방식으로 구동된다.

 
이렇게 동작할때의 문제점은, 서버 애플리케이션은 지속적으로 클라이언트의 연결 수락 기능을 해야하는데, 입출력에서 블로킹되면 이 작업을 할 수 없게된다. 또한 클라이언트1과 입출력하는 동안 클라이언트2와 입출력을 할 수 없게된다. 그렇기 때문에 우리는 작업스레드를 생성해서 병렬적으로 처리해야 한다.

=> 과도한 스레드 생성을 방지하기위해 스레드 풀을 사용한다.
 
 */
public class MySocketServer extends Thread{

	
	//유저 확인용 배열
	static ArrayList<Socket> list = new ArrayList<Socket>();
	static Socket socket = null;
	
	
	//생성자
	public MySocketServer( Socket socket) {
		this.socket = socket; 	//유저 소켓 을 할당
		list.add(socket);		//유저를 리스트에 추가
	}
	
	
	//스레드 실행
	//Thread 에서 start() 메소드 사용 시 자동으로 해당 메소드 시작 (Thread별로 개별적 수행)
	public void run() {
		
		System.out.println("서버 : " + socket.getInetAddress() + " ip 의 클라이언트와 연결완료");
		
		
		try {
			
			
			//InputStream - 클라이언트에서 보낸 메시지 읽기
			InputStream input = socket.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(input));
			
	
			
			//OutputStream - 서버에서 클라이언트로 메시지 보내기
			OutputStream out = socket.getOutputStream();
			PrintWriter writer = new PrintWriter(out, true);
			
			
			//클라이언트에게 연결완료 메시지 전송
			writer.println("서버에 연결완료! ID를 입력해 주세요");
		
			String readValue;	//클라이언트에서 보낸 값 저장
			String name = null; //클라이언트 이름 설정용
			boolean identify = false;
			
			
			//무한 반복
			//클라이언트가 메시지 입력시 마다 수행 + 출력
			//클라이언트 1이 입력한 문자 처리할때 
			//클라이언트 2가 입력한 문자는 기다리게 된다..........
			while((readValue = reader.readLine()) != null) {
				
				
				//지연 테스트
				//팅 문자열 5번 출력 - 2초 간격
				for(int i = 0 ; i< 3; i++) {
					
					System.out.println("지연테스트 : 소켓 정보 : " + socket);
					
					try {
						
						//2초 간격
						Thread.sleep(2000);
						
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
				}
				
				
				
				//연결 후 딱한번만 실행
				if(!identify) {
					
					
			
					SimpleDateFormat format2 = new SimpleDateFormat ( "yyyy년 MM월dd일 HH시mm분ss초");
					Date time = new Date();
					String time2 = format2.format(time);

					
					//이름 할당 및 출력
					name = readValue;
					identify = true;
					
					writer.println(time2);
					writer.println("* " + name + "님이 접속 했습니다.");
					writer.println("해보기나 했어?");
					writer.println("화이팅. 할수있다.!");
					writer.println("===========================");
					
					
					continue;
				}
				
				//클라이언트에게 메시지 전송 !
				//list 안에 클라이언트 정보가 담겨있다
				for(int i = 0; i<list.size(); i++) {
					
					out = list.get(i).getOutputStream();
					writer = new PrintWriter(out, true);
					
					//클라이언트에게 메시지 전송
					writer.println(name + " : " + readValue);
				}
				
			}
			
			
		//예외 처리
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		
		int socketPort = 1234;
		
		try {
			
			ServerSocket serverSocket = new ServerSocket(socketPort);
			
			System.out.println("socket : " + socketPort + " 으로 서버가 열렸습니다"); // 서버 오픈 확인용
			
			//소켓 서버가 종료될때 까지 무한 루프
			while(true) {
				
				
				System.out.println("accept 전 ");
				
				//서버에 클라이언트 접속시
				Socket socketUser = serverSocket.accept(); 
				
				System.out.println("accept 후 ");
				
				//쓰레드 개별 생성
				//스레드 안에 클라이언트 정보 담아줌
				Thread thd = new MySocketServer(socketUser); 
				
				
				//스레드 시작
				thd.start();
				
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
