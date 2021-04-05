package de.yoktobit.daacco.r2dbc.foomanagement.dataaccess.api.repo;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import de.yoktobit.daacco.r2dbc.foomanagement.dataaccess.api.BarEntity;
import reactor.core.publisher.Mono;

public interface BarRepository extends ReactiveCrudRepository<BarEntity, Long> {
    
    Mono<BarEntity> findByName(String name);
}
