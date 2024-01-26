package com.kh.example.practice2;


// 기능 :  ~할때는 ~한다.
public class MusicController {
	
	private Music[] mArr = new Music[2];

	
	// public은 어디서든 호출 가능!
	public int checkMusiclastMusic(String title, String singerName) {
		//위의 배열만큼 돈다.
		for(int i=0; i<mArr.length; i++) {
			if(mArr[i] != null) {
				System.out.println("추가 성공");
			}else {
				// return값이 없게 되는 경우 만들었음
			}
		}
		return -1;
	}
	
	
	
}
