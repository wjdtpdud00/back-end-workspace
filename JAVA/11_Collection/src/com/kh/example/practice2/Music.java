package com.kh.example.practice2;
//데이터 베이스
public class Music {
	
	public String title;
	public String singerName;
	
	
	
	public Music() {
		
	}

	public Music(String title, String singerName) {
		this.title = title;
		this.singerName = singerName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSingerName() {
		return singerName;
	}

	public void setSingerName(String singerName) {
		this.singerName = singerName;
	}

}
