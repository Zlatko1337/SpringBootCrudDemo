package com.tis.crud.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @NoArgsConstructor @ToString
public class Album {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;   
   
    private String name;
    private int yearReleased;
    
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "band_Id")
    private Band band;
    
    @JsonManagedReference
    @OneToMany(mappedBy="album", cascade=CascadeType.ALL)
    private List<Song> songs;
   
}
