package com.tis.crud.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
public class AlbumDTO {
    
    private long id;   
    private String name;
    private int yearReleased;
  
}
