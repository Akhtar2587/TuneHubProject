package com.kodnest.Tunehub.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.kodnest.Tunehub.entity.Song;
import com.kodnest.Tunehub.service.SongService;

@Controller
public class SongController {

	@Autowired
	SongService songService;
	
	@PostMapping("/addsong")
	public String addSong(@ModelAttribute Song song) {
		String name=song.getName();
		
		boolean songExists=songService.songExists(name);
		
		if(songExists==false) {
		songService.saveSong(song);
		System.out.println("Song added successfully");
		
		}else {
			System.out.println("Duplicate entry");
		}
		return "adminhome";
	}
	
	@GetMapping("/playsongs")
	public String playSongs(Model model) {
		
		boolean premium=true;
		
		if(premium) {
			List<Song> songslist=songService.fetchAllSongs();
			model.addAttribute("songs", songslist);
			System.out.println(songslist);
			return "viewsongs";
			}else {
				return "payform";
			}	
	}
	
	@GetMapping("/viewsongs")
	public String viewSongs(Model model) {
		
		List<Song> songslist=songService.fetchAllSongs();
		model.addAttribute("songs", songslist);
		return "viewsongs";
	}
}
