package com.kh.example.practice2.model;

public class Song {
	private String title;
	private String artist;
	
	// 메모리에 영원히 올라와있지 x, 메서드가 끝나면 데이터도 끝
	
	/*extends는 클래스를 확장하는 거고, implements는 인터페이스를 구현하는 것이다.
	인터페이스와 보통 클래스의 차이는 인터페이스는 정의한 메소드를 구현하지 않아도 된다.
	인터페이스를 상속받는 클래스에서 인터페이스에 정의된 메소드를 구현하면 된다.*/
	public Song() {
		
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public Song(String title, String artist) {
		this.title = title;
		this.artist = artist;
	}
	
	@Override
	public String toString() {
		return artist + "-" + title;
	}

}
