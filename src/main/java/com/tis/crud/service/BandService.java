package com.tis.crud.service;

import java.util.Arrays;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.tis.crud.dto.AlbumDTO;
import com.tis.crud.dto.BandDTO;
import com.tis.crud.dto.MusicianDTO;
import com.tis.crud.model.Band;
import com.tis.crud.repository.BandRepository;

@Service
public class BandService extends BaseService<BandDTO,Band>{
	
	@Autowired
	private BandRepository bandRepository;
		
	public Page<BandDTO> getAllBands(Pageable pageable) {	
		return bandRepository.findAll(pageable)
							 .map(this::convertEntityToDto);	
	}
		
	public BandDTO getBandById(long bandId) {	
		Band band = bandRepository.findById(bandId).orElseThrow(() -> new IllegalArgumentException("Invalid band Id:" + bandId));
		return convertEntityToDto(band);
	}
	
	public void saveBand(@Valid BandDTO bandDTO) {
		bandRepository.save(convertDtoToEntity(bandDTO));
	}
	
	public void deleteBand(long bandId) {	
		bandRepository.deleteById(bandId);
	}

	@Override
	BandDTO convertEntityToDto(Band band) {
		return new BandDTO(band.getId(), 
							band.getName(), 
							band.getYearFormed(), 
							Arrays.asList(modelMapper.map(band.getMusicians(), MusicianDTO[].class)), 
							Arrays.asList(modelMapper.map(band.getAlbums(), AlbumDTO[].class)));
	}

	@Override
	Band convertDtoToEntity(BandDTO bandDTO) {
		return new Band(bandDTO.getId(), 
						bandDTO.getName(), 
						bandDTO.getYearFormed());
	}

}