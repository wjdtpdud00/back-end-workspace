package com.kh.example.practice2.controller;
// controll : 동사
import java.util.ArrayList;
import java.util.Collections;

import com.kh.example.practice2.compare.ArtistDescending;
import com.kh.example.practice2.compare.TitleAscending;
import com.kh.example.practice2.model.Song;

public class SongController {
	// 싱글톤 패턴 (Singleton Pattern)
	// - 디자인 패턴 중 하나로 클래스가 최대 한 번만 객체 생성되도록 하는 패턴
	
	private ArrayList<Song> list = new ArrayList<>();
	
	//1. 생성자는 private
	private SongController() {}
	
	//2. 유일한 객체를 담을 static 변수
	private static SongController instance;
	
	//3. 객체를 반환하는 static 메서드
	public static SongController getInstance() {
		if(instance == null) instance = new SongController();
		return instance;
	}
	
	public boolean addLastList(Song song) {
		if(!song.getTitle().equals("") && !song.getTitle().equals("")) {
			return list.add(song);
		} 
		return false;
	}
	
	// Song song 형태를 받을것임
	public boolean addFirstList(Song song) {
		if(!song.getTitle().equals("") && !song.getTitle().equals("")) {
			list.add(0, song);
		} return true;
	}
	public ArrayList<Song> printAll() {
		return list;
	}
	public Song searchSong(String title) {
		for(Song song : list) {
			if(song.getTitle().contains(title)) {
				return song;
			}
		} return null;
	}
	public Song removeSong(String title) {
		for(Song song : list) {
			if(song.getTitle().equals(title)) {
				return list.remove(list.indexOf(song));
			} 
		}
		return null;
	}
	public Song updateSong(String search, Song update) {
		for(Song song : list) {
			if(song.getTitle().equals(search)) {
				return list.set(list.indexOf(song), update);
				
		}
	}
		return null;
}
	public ArrayList<Song> ascTitle() {
		ArrayList<Song> cloneList = (ArrayList<Song>) list.clone();
		Collections.sort(cloneList, new TitleAscending());
		return cloneList;
	}
	public ArrayList<Song> descArtist() {
		ArrayList<Song> cloneList = (ArrayList<Song>) list.clone();
		Collections.sort(cloneList, new ArtistDescending());
		return cloneList;
	}

}
