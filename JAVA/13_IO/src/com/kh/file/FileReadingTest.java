package com.kh.file;
/*
 * 문자 기반 스트림
 * - 문자 데이터를 읽고 출력할 때 사용
 * - Reader, Writer : 문자 기반 입출력 스트림의 최상위 클래스
 * */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileReadingTest {

	String fileName = "src/test.txt";
	String outfileName = "src/result.txt";

	public static void main(String[] args) {

		FileReadingTest f = new FileReadingTest();
//		f.fileSave();
//		f.fileRead();
//		f.method1();
		f.method2();

	}

	public void fileSave() {
		// FileWriter를 사용해서 파일을 생성하고 데이터를 문자 단위로 저장

		// [try-with-resource 문을 통해서 사용한 리소스를 자동으로 close()]
		try (/* 반납하려는 코드 */FileWriter fw = new FileWriter(fileName, true/* 기본이 false임 : 그냥 한번실행하고 끝남| true는 반복실행 */);) {
			fw.write("IO 재밌나요?\n");
			fw.write("아닌가요 ㅠㅠ?\n");
			fw.write("뭐가 되었든 끝납니다!\n");

			fw.flush(); // 강제로 자료 출력
			fw.write("오전 수업 끝!\n");
		} catch (IOException e) {
			e.printStackTrace();
		} // 실행을 할수록 내용이 추가됨 : FileWritert생성자에 true를 넣었기 때문임.

		/*
		 * FileWriter fw = null; try { fw = new FileWriter(fileName);
		 * 
		 * fw.write("IO 재밌나요?\n"); fw.write("아닌가요 ㅠㅠ?\n"); fw.write("뭐가 되었든 끝납니다!\n");
		 * // .flush() : 강제로 자료 출력 메소드 fw.flush();
		 * 
		 * } catch (IOException e) { e.printStackTrace(); } finally { try { fw.close();
		 * } catch (IOException e) { e.printStackTrace(); } }
		 */
	}
	// test.txt 파일 생성

	public void fileRead() {
		// FileReader를 사용해서 파일에서 데이터를 문자 단위로 읽어온다.
		try (FileReader fr = new FileReader(fileName)) {

			int data = 0;
			// -1이되기 전까지 숫자를 반환함
			while ((data = fr.read()) != -1) {
				System.out.print((char) data);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 파일에 있는 내용을 읽어서 한 줄 단위로 콘솔에 출력하는 로직
	// 보조 스트림 BufferedReader : 버퍼(char[])에 데이터가 쌓이기를 기다렸다가 꽉 차게 될 시 한꺼번에 보냅니다.
	public void method1() {
		try (
				// 기반스트림 > 보조스트림
				// 이건 기반스트림
				FileReader fr = new FileReader(fileName);
				BufferedReader br = new BufferedReader(fr);
				) {
				  String line = "";
				  // null나오기전까지 비교, 단위는 한줄!
				  while((line = br.readLine()) != null) {
					  System.out.println(line);
				  }
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//파일에 있는 내용을 읽어서 또다른 파일로 출력하는 로직
	public void method2() {
		
		/*
		 * BufferedReader, BufferedWriter : 입출력 효율을 높이기 위해 
		 * 							버퍼(char[])를 사용하는 보조스트림
		 * --> 라인(line) 단위로 입출력이 편리하다.
		 * 
		 * 
		 * PrintWriter : 프린터와 유사하게 출력하는 print(), println() 
		 *               메서드를 가지고 있는 보조스트림
		 * */
		
		try(
				/*
				 * 파일명 > fileReader> 보조스트림 순으로 합쳐서 , 한줄로 만듬
				 * FileReader fr = new FileReader(fileName);
				   BufferedReader br = new BufferedReader(fr);*/
				
				BufferedReader br = new BufferedReader(new FileReader(fileName));
				// 실행할때마다 내용 추가됨 : true 때문임
				PrintWriter pw = new PrintWriter(/* 기반 스트림*/new FileWriter(outfileName, true));
//				BufferedWriter bw = new BufferedWriter(new FileWriter(outfileName)); 
		) {
			// 반복문 초기화시킨후, 돌림
			String line = "";
			while((line = br.readLine()) != null) {
//				System.out.println(line);
//				bw.write(line); // 한줄로 쭈루루룩 나오게 출력함.
//				bw.newLine(); // 라인 구분자(개행문자)를 출력
				pw.println(line);
			}
			
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
