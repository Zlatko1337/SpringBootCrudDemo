package com.tis.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.tis.crud.service.SongService;

@Controller
public class SongController {
    
    @Autowired
	private SongService songService;
    
	@GetMapping("/songs")
	public String showSongsList(@RequestParam(name = "albumId") long albumId, Model model) {
		model.addAttribute("songs", songService.getSongsByAlbumId(albumId)); //or album.getSongs()
		return "songs";
	}
    
}
