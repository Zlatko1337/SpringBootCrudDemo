package com.tis.crud.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.tis.crud.model.Band;

@Repository
public interface BandRepository extends PagingAndSortingRepository<Band, Long> {

}
