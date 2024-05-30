package com.kodnest.Tunehub.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodnest.Tunehub.entity.Playlist;
import com.kodnest.Tunehub.repository.PlaylistRepository;
import com.kodnest.Tunehub.service.PlaylistService;

@Service
public class PlaylistServiceImpl implements PlaylistService{

	@Autowired
	PlaylistRepository playlistRepository;

	@Override
	public void addPlaylist(Playlist playlist) {
		Playlist exiplaylist=playlistRepository.findByName(playlist.getName());
		
		if(exiplaylist==null) {
		playlistRepository.save(playlist);
		}else {
			System.out.println("Playlist already exists!");
		}
	}

	@Override
	public List<Playlist> fetchAllPlaylists() {
		List<Playlist> playlists=playlistRepository.findAll();
		return playlists;
	}
}
