package com.tis.crud.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Data
@Getter @Setter @NoArgsConstructor @ToString @AllArgsConstructor
public class Band {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    private String name;
    private int yearFormed;

    @JsonManagedReference
    @OneToMany(mappedBy="band", cascade=CascadeType.ALL)
    private List<Musician> musicians;
    
    @JsonManagedReference
    @OneToMany(mappedBy="band", cascade=CascadeType.ALL)
    private List<Album> albums;
    
    
    public Band(long id, String name, int yearFormed) {
        this.id = id;
    	this.name = name;
        this.yearFormed = yearFormed;
    }

}

