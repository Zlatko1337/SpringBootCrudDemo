package com.tis.crud.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class BandDTO {
    
    private long id;
    private String name;
    private int yearFormed;
    private List<MusicianDTO> musicians;
    private List<AlbumDTO> albums;
    
}

