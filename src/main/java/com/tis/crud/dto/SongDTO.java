package com.tis.crud.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class SongDTO {
    
    private long id;   
    private String name;
    private int yearReleased;
    private String writer;    
    private String singer;    
    private String genre;
    private int length;
   
}