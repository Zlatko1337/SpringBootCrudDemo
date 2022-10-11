package com.tis.crud.model;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @NoArgsConstructor @ToString
public class Musician {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @NotBlank(message = "Name is mandatory")
    private String name;
    
    private Date dateOfBirth;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "band_Id")
    private Band band;
    
    public Musician(long id, String name, Date dateOfBirth) {
    	this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

}
