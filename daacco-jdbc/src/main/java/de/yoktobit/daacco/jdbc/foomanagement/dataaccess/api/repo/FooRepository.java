package de.yoktobit.daacco.jdbc.foomanagement.dataaccess.api.repo;

import org.springframework.data.repository.PagingAndSortingRepository;

import de.yoktobit.daacco.jdbc.foomanagement.dataaccess.api.FooEntity;

public interface FooRepository extends PagingAndSortingRepository<FooEntity, Long>  {
    
}
