package com.tis.crud.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.tis.crud.datable.DataTable;
import com.tis.crud.dto.BandDTO;
import com.tis.crud.service.BandService;

@Controller
public class BandController {

	@Autowired
	private BandService bandService;

	@GetMapping("/bands")
	public String showBands() {
		return "bands";
	}

	@GetMapping(path = "/bands", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DataTable<BandDTO>> listAllTable(@RequestParam("draw") int draw,
	              						@RequestParam("start") int start,
	              						@RequestParam("length") int length) {
	
		int page = start / length; 
		Pageable pageable = PageRequest.of(page, length, Sort.by(Sort.Direction.ASC,"id"));
		
		Page<BandDTO> responseData = bandService.getAllBands(pageable);
		
		DataTable<BandDTO> dataTable = new DataTable<>();
		dataTable.setData(responseData.getContent());
		dataTable.setRecordsTotal(responseData.getTotalElements());
		dataTable.setRecordsFiltered(responseData.getTotalElements());
		dataTable.setDraw(draw);
		dataTable.setStart(start);
		
		return new ResponseEntity<>(dataTable, HttpStatus.OK);
	}

	@GetMapping("/bands/add")
	public String showAddNewBandForm(BandDTO bandDTO) {
		return "add-band";
	}

	@PostMapping("/bands")
	public String addBand(@Valid BandDTO bandDTO, BindingResult result) {
		if (result.hasErrors()) {
		    return "add-band";
		}
		bandService.saveBand(bandDTO);     
		return "redirect:/bands";
	}

	@GetMapping("/bands/edit/{id}")
	public String showUpdateBandForm(@PathVariable("id") long bandId, Model model) {
		model.addAttribute("band", bandService.getBandById(bandId));    
		return "update-band";
	}

	@PutMapping("/bands/{id}")
	public String updateBand(@PathVariable("id") long bandId, @Valid BandDTO bandDTO, BindingResult result) {
		if (result.hasErrors()) {
			bandDTO.setId(bandId);
			return "update-band";
		}
		bandService.saveBand(bandDTO);
		return "redirect:/bands";
	}

	@DeleteMapping("/bands/{id}")
	public ResponseEntity<String> deleteBand(@PathVariable("id") long bandId) {
		bandService.deleteBand(bandId);     
		return new ResponseEntity<>("Bravo", HttpStatus.OK);
	}	
	
}
