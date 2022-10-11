package com.tis.crud.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.tis.crud.model.Song;

@Repository
public interface SongRepository extends CrudRepository<Song, Long> {
    
    List<Song> findByAlbumId(long albumId);
    
}
