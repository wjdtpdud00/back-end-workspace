package com.kh.file;

import java.io.File;
import java.io.IOException;

/*
 * File 클래스
 * - 파일과 디렉토리를 다루는데 사용되는 클래스
 * */
public class FileTest {

	public static void main(String[] args) {
		
		File file = new File(/*파일명*/"src/test.txt");
		
		// .getName() :파일명을 가져오는 메소드
		System.out.println("파일명 : " + file.getName());
		//.getAbsolutePath() : 절대경로 찾는 메소드
		System.out.println("절대 경로 : " + file.getAbsolutePath());
		// .getPath() : 절대경로 찾는 메소드
		System.out.println("상대 경로 : " + file.getPath());
		// .length() : 파일 용량을 가져오는 메소드
		System.out.println("파일 용량 : " + file.length());
		// .exists() : 파일 존재 여부 확인 메소드
		System.out.println("파일 존재 여부 : " + file.exists());
		// .isFile() : 파일인지 확인하는 메소드
		System.out.println("파일 여부 : " + file.isFile());
		// .isDirectory() : 디렉토리 인지 확인하는 메소드
		System.out.println("디렉토리 여부 : " + file.isDirectory());
		
		// 만약 존재하지 않는 경로를 제시하면 IOException 발생(java.io.IOException:
		//                                        지정된 경로를 찾을 수 없습니다)
		// 폴더,파일이 없는 새로운 파일 생성!
		File newFile = new File("src/temp/test.txt");
//		System.out.println(newFile.exists());// false
			
			// 파일이 존재하지 않은경우! | try catch는 바깥쪽에!
			try {
				// 존재하지 않는 폴더부터 만들기
				File tempDir = new File("src/temp");
				if(!tempDir.isDirectory()) {
					// 디렉토리 파일이 존재하지 않는경우!
					tempDir.mkdir();
//					System.out.println(tempDir.isDirectory());
				}
				if(!newFile.exists()) {
					// 파일이 존재하지 않는 경우!
					newFile.createNewFile();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			// -> temp패키지 안에 test.txt파일이 생김!
		
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
