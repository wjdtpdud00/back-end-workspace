package com.kh.socket2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

// 키보드로 입력받은 데이터를 읽어서 서버로 보낸다
// 다시 서버가 보낸 메세지를 받아서 클라이언트 자신의 콘솔창에 출력한다.
/*
 * 클라이언트측 로직
 * 1. 소켓 생성
 * 2. 스트림
 * */
public class ChattClient {
	public static void main(String[] args) {
		
		/* 1. 소켓 생성
		 * 
		 * 2. 스트림
		 * BufferedReader, InpuetStreamReader, System.in
		 * PrintWriter <- s.getOutputStream
		 * 
		 * BufferedReader, InputStreamReader <- s.getInputStream
		 * */
		
			// 1. 소켓 생성
			try {
				// ip받아오기
				String ip = InetAddress.getLocalHost().getHostAddress();
				Socket s = new Socket(ip, 60000);
				
				System.out.println("Client Socket Creating...");
				
				// 2. 스트림 (무한루프)
				// 키보드에 입력한것 > 읽음 > buffered에 담음
				// BufferedReader, InputStreamReader, System.in
				// PrintWriter <- s.getOutputStream
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
				
				System.out.println("Client stream Creating..");
				
				// 읽히는 것을 계속 실행
				
				
				BufferedReader br2 = new BufferedReader(new InputStreamReader(s.getInputStream()));
//				String line = "";
				while(true) {
					String line = br.readLine();
					pw.println(line);
					
					String severMsg = br2.readLine();
					System.out.println("내가 보낸 메세지 : " + severMsg);
				}
				
					
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("서버와의 연결에 실패하였습니다.");
			}
			
		
		
	
	
	
}
	
}
