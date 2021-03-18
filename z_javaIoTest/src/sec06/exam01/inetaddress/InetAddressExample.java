package sec06.exam01.inetaddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressExample {

	public static void main(String[] args) {
		

		try {
			
			InetAddress local = InetAddress.getLocalHost();
			
			
			System.out.println("내 컴퓨터 ip 주소 :" +local.getHostAddress());
			
			
			InetAddress [] iaArr = InetAddress.getAllByName("www.naver.com");
			
			for(InetAddress remote : iaArr) {
				
				System.out.println("naver ip 주소 :" +remote.getHostAddress());
				
			}
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
