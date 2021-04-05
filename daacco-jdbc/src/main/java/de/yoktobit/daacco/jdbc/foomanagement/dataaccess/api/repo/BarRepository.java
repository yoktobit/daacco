package de.yoktobit.daacco.jdbc.foomanagement.dataaccess.api.repo;

import org.springframework.data.repository.PagingAndSortingRepository;

import de.yoktobit.daacco.jdbc.foomanagement.dataaccess.api.BarEntity;

public interface BarRepository extends PagingAndSortingRepository<BarEntity, Long> {
    
    BarEntity findByName(String name);
}
