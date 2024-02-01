package com.kh.example.practice2.compare;

import java.util.Comparator;

import com.kh.example.practice2.model.Song;

// 가수명 내림차순 정렬
public class ArtistDescending implements Comparator<Song>{
	
	@Override
	public int compare(Song o1, Song o2) {
		return o2.getArtist().compareTo(o1.getArtist());
	}

}
