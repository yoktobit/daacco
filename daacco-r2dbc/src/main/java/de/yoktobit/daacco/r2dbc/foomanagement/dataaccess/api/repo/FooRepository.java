package de.yoktobit.daacco.r2dbc.foomanagement.dataaccess.api.repo;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import de.yoktobit.daacco.r2dbc.foomanagement.dataaccess.api.FooEntity;

public interface FooRepository extends ReactiveCrudRepository<FooEntity, Long>  {
    
}
