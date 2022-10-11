package com.tis.crud.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tis.crud.dto.SongDTO;
import com.tis.crud.model.Song;
import com.tis.crud.repository.SongRepository;

@Service
public class SongService extends BaseService<SongDTO, Song>{
	
	@Autowired
	private SongRepository songRepository;
		
	public List<SongDTO> getSongsByAlbumId(long albumId) {	
		return songRepository.findByAlbumId(albumId).stream()
							 .map(this::convertEntityToDto)
							 .collect(Collectors.toList());
	}

	@Override
	SongDTO convertEntityToDto(Song song) {
		return new SongDTO(song.getId(), 
							song.getName(), 
							song.getYearReleased(), 
							song.getWriter(),
							song.getSinger(),
							song.getGenre(),
							song.getLength());
	}

	@Override
	Song convertDtoToEntity(SongDTO songDTO) {
		return null;
	}

}