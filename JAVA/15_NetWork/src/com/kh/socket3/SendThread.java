package com.kh.socket3;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class SendThread extends Thread{
	
	Socket socket;
	Scanner sc = new Scanner(System.in);
	
	// 소켓이 담긴 상태
	public SendThread(Socket socket) {
		// socket이란 변수에 담아놓음
		this.socket = socket;
	}
	
	// 실제 구현은 run메소드에서 진행됨
	public void run() {
		try {
			// socket의 스트림을 받아옴
			PrintStream ps = new PrintStream(socket.getOutputStream());
			
			while(true) {
				ps.println(sc.nextLine());
				ps.flush(); // .flush() 출력과 동시에 데이터 비움
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
