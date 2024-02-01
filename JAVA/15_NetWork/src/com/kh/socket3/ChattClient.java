package com.kh.socket3;

import java.awt.BufferCapabilities;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

class ChattClient {

	public static void main(String[] args) {
		
		try {// 소켓에는 클라이언트, 아이피번호 넘김
			Socket socket = new Socket("192.168.10.51", 3000);
			System.out.println("서버와 연결되었습니다..");
			
			// 소켓을 변수값에 담음
			Thread sendThread = new SendThread(socket);
			sendThread.start();// 소켓 실행중
			
			// BufferedReader > 데이터를 읽어옴
			// InputStreamReader() : 스트림의 nextline 
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			while(br != null) {
				System.out.println(br.readLine());
			}
		} catch (IOException e) { // IOException 최상위 클래스임 
			System.out.println("서버 종료...!");
			e.printStackTrace();
		} 
		
	}

}
