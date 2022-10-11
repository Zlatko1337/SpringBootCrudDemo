package com.tis.crud.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.tis.crud.model.Musician;

@Repository
public interface MusicianRepository extends CrudRepository<Musician, Long> {
    
}
