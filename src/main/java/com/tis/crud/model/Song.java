package com.tis.crud.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @NoArgsConstructor @ToString
public class Song {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;   
    private String name;
    private int yearReleased;
    private String writer;    
    private String singer;    
    private String genre;
    private int length;
    
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "album_Id")
    private Album album;
    
    
    public Song(String name) {
        this.name = name;
    }

}