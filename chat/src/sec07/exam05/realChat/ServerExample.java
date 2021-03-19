package sec07.exam05.realChat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class ServerExample {
	
	
	ExecutorService executorService;
	ServerSocket serverSocket;
	List<Client> connections = new Vector<Client>();
	
	//서버 시작
	void startServer() {
		
		executorService = Executors.newFixedThreadPool(
			Runtime.getRuntime().availableProcessors()
	    );
		
		try {
			//서버 소캣 생성
			serverSocket = new ServerSocket(5001);		
			//serverSocket.bind(new InetSocketAddress("localhost", 5001));
			
			System.out.println("서버 소켓 생성 완료 : " + serverSocket);
			
		} catch(Exception e) {
			
			if(!serverSocket.isClosed()) { stopServer(); }
			return;
			
		}
		
		//스레드 1
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				
				
				while(true) {
					try {
						
						System.out.println("연결 대기 중...");
						
						Socket socket = serverSocket.accept();
						
						String message = "[서버연결 완료: " + socket.getRemoteSocketAddress()  + ": " + Thread.currentThread().getName() + "]";
						
						System.out.println("message : " + message);
		
						//클라이언트가 하나씩 접속 할때마다 소켓 생성 + (클라이언트)소켓의 읽기 스레드 , 쓰기 쓰레드 생성
						Client client = new Client(socket);
						
						
						//클라이언트 소캣 배열에 추가
						connections.add(client);
						
						
						System.out.println("[연결 수 : " + connections.size() + "]");
						
					} catch (Exception e) {
						
						if(!serverSocket.isClosed()) { stopServer(); }
						
						break;
					}
				}
			}
		};
		//스레드 작업 시작
		executorService.submit(runnable);
	}
	
	
	//서버 정지
	void stopServer() {
		try {
			
			Iterator<Client> iterator = connections.iterator();
			
			while(iterator.hasNext()) {
				Client client = iterator.next();
				client.socket.close();
				iterator.remove();
			}
			
			
			if(serverSocket!=null && !serverSocket.isClosed()) { 
				serverSocket.close(); 
			}
			if(executorService!=null && !executorService.isShutdown()) { 
				executorService.shutdown(); 
			}
			
			
			System.out.println("서버가 정지 되었습니다.");
			
			
		} catch (Exception e) { }
	}	
	
	
	//클라이언트가 서버에 접속하면 서버소켓은 클라이언트 연결용 소켓을 생성하고
	//메시지 받기 스레드, 쓰기 스레드를 생성한다.
	class Client {
		
		//특정 소켓
		Socket socket;
		
		//클라이언트 생성자
		Client(Socket socket) {
			this.socket = socket;
			receive();
		}
		
		//메시지 받기 처리 - 스레드 1
		void receive() {
			
			
			Runnable runnable = new Runnable() {
				@Override
				public void run() {
					try {
						
						System.out.println("Client - receive - run 1");
						
						
						//클라이언트 이름 설정용
						String name = null; 
						boolean identify = false;
						OutputStream out = socket.getOutputStream();
						PrintWriter writer = null;
						
						
						while(true) {
							
							System.out.println("Client - receive - run 2");
							

							//100바이트 씩 읽는다.
							byte[] byteArr = new byte[100];
							
							//입력 스트림 생성
							InputStream inputStream = socket.getInputStream();
							
							//처음 들어오는 클라이언트면
							if(name == null) {
								//OutputStream - 서버에서 클라이언트로 메시지 보내기
								writer = new PrintWriter(out, true);
								//클라이언트에게 연결완료 메시지 전송
								writer.println("서버에 연결완료! ID를 입력해 주세요");
							}
							
							
							//여기서 블락킹!! - 클라이언트로 부터 받은 데이터[*********** 블락킹 ************]
							int readByteCount = inputStream.read(byteArr);
							if(readByteCount == -1) {  throw new IOException(); }
							
							String message = "[" + socket.getRemoteSocketAddress() + ": " + Thread.currentThread().getName() + "]";

							System.out.println("socket 정보 : " + message);
							
							//클라이언트로 부터 받은 데이터
							String data = new String(byteArr, 0, readByteCount -1, "UTF-8");
							
							
							
							//연결 후 딱한번만 실행
							if(!identify) {
								
								SimpleDateFormat format2 = new SimpleDateFormat ( "yyyy년 MM월dd일 HH시mm분ss초");
								Date time = new Date();
								String time2 = format2.format(time);

								//이름 할당 및 출력
								name = data;
								identify = true;
									
								writer.println(time2);
								writer.println("* " + name + "님이 접속 했습니다.");
								writer.println("환영한다!");
								writer.println("해보기나 했어?");
								writer.println("꾸준히하면 할수있다.!");
								writer.println("===========================");
								continue;
								}
							

							//모든 클라이언트에게 보내기
							for(Client client : connections) {
								client.send(name +  " : " + data); 
							}
							
							System.out.println("Client - receive - run 3");
							
						}//while
						
						
					} catch(Exception e) {
						try {
							connections.remove(Client.this);
							String message = "[오류발생 : " + socket.getRemoteSocketAddress() + ": " + Thread.currentThread().getName() + "]";
							
							System.out.println("소켓을 닫습니다. : " + message);
							
							socket.close();
							
						} catch (IOException e2) {}
					}
					
					System.out.println("Client - receive - run 4");
				}
			};
			//메시지 받기 스레드 작동
			executorService.submit(runnable);
			
			System.out.println("Client - receive - run 5");
		}
		
		
		
		//메시지 보내기 스레드 -1 - 무한루프 아님
		void send(String data) {
			Runnable runnable = new Runnable() {
				@Override
				public void run() {
					try {
						
						
						byte[] byteArr = data.getBytes("UTF-8");
						//출력 스트림 생성
						OutputStream outputStream = socket.getOutputStream();
						
						//출력 스트림에 쓰기
						outputStream.write(byteArr);
						
						//출력
						outputStream.flush();
						
						
					} catch(Exception e) {
						try {
							String message = "[" + socket.getRemoteSocketAddress() + ": " + Thread.currentThread().getName() + "]";
							
							System.out.println("send 메서드 오류 발생 : " + message);
							
							
							connections.remove(Client.this);
							
							//소켓 닫기
							socket.close();
						
						} catch (IOException e2) {}
					}
				}
			};
			//메시지 보내기 스레드 실행
			executorService.submit(runnable);
		}
	}//Client - Class
	

	
	public static void main(String[] args) {
		ServerExample se = new ServerExample();
		se.startServer();
	}
}
