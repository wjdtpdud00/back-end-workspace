package com.kh.socket3;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChattServer {

	public static void main(String[] args) {
		
		try {
			ServerSocket severSocket = new ServerSocket(3000/*3000은 포트번*/);
			System.out.println("클라이언트 기다리는 중....!");
			
			while(true) {
				// 클라이언트가 접속할 때마다 새로운 스레드 생성
				Socket socket = severSocket.accept();
				ClientThread client = new ClientThread(socket);
				client.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
