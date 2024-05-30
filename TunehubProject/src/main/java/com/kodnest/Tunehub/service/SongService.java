package com.kodnest.Tunehub.service;

import java.util.List;

import com.kodnest.Tunehub.entity.Song;

public interface SongService {

	void saveSong(Song song);

	boolean songExists(String name);

	List<Song> fetchAllSongs();

	void updateSong(Song song);

}
