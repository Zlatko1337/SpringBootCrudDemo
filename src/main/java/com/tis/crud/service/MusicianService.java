package com.tis.crud.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tis.crud.dto.MusicianDTO;
import com.tis.crud.model.Musician;
import com.tis.crud.repository.MusicianRepository;

@Service
public class MusicianService extends BaseService<MusicianDTO, Musician>{
	
	@Autowired
	private MusicianRepository musicianRepository;
		
	public List<MusicianDTO> getAllMusicians() {	
		return StreamSupport.stream(musicianRepository.findAll().spliterator(), false)
				.map(this::convertEntityToDto)
				.collect(Collectors.toList());
	}
		
	public MusicianDTO getMusicianById(long musicianId) {	
		Musician musician = musicianRepository.findById(musicianId).orElseThrow(() -> new IllegalArgumentException("Invalid musician Id:" + musicianId));
		return convertEntityToDto(musician);
	}

	public void saveMusician(@Valid MusicianDTO musicianDTO) {
		musicianRepository.save(convertDtoToEntity(musicianDTO));
	}
	
	public void deleteMusician(long musicianId) {	
		musicianRepository.deleteById(musicianId);
	}

	@Override
	MusicianDTO convertEntityToDto(Musician musician) {
		return new MusicianDTO(musician.getId(),
							   musician.getName(),
							   musician.getDateOfBirth());
	}

	@Override
	Musician convertDtoToEntity(MusicianDTO musicianDTO) {
		return new Musician(musicianDTO.getId(),
							musicianDTO.getName(),
							musicianDTO.getDateOfBirth());
	}

}