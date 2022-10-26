package com.tis.crud.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import com.tis.crud.dto.MusicianDTO;
import com.tis.crud.service.MusicianService;

@Controller
public class MusicianController {
    
	@Autowired
	private MusicianService musicianService;
	
	@GetMapping("/musicians")
	public String showMusicians(Model model) {
		model.addAttribute("musicians", musicianService.getAllMusicians());
	    return "musicians";
	}
	
	@GetMapping("/musicians/add")
	public String showAddNewMusicianForm(MusicianDTO musicianDTO) {
	    return "add-musician";
	}
	
	@PostMapping("/musicians")
	public String addMusician(@Valid MusicianDTO musicianDTO, BindingResult result) {
	    if (result.hasErrors()) {
	        return "add-musician";
	    }     
	    musicianService.saveMusician(musicianDTO);
	    return "redirect:/musicians";
	}
	
	@GetMapping("/musicians/edit/{id}")
	public String showUpdateMusicianForm(@PathVariable("id") long musicianId, Model model) {
	    model.addAttribute("musician", musicianService.getMusicianById(musicianId));    
	    return "update-musician";
	}
	      
	@PutMapping("/musicians/{id}")
	public String updateMusician(@PathVariable("id") long musicianId, @Valid MusicianDTO musicianDTO, BindingResult result) {
	    if (result.hasErrors()) {
	    	musicianDTO.setId(musicianId);
	        return "update-musician";
	    }     
	    musicianService.saveMusician(musicianDTO);
	    return "redirect:/musicians";
	}
	
	@DeleteMapping("/musicians/{id}")
	public String deleteMusician(@PathVariable("id") long musicianId) {
		musicianService.deleteMusician(musicianId);
	    return "redirect:/musicians";
	}	
    
}
