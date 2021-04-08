package de.yoktobit.daacco.r2dbc.foomanagement.dataaccess.api.repo;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import de.yoktobit.daacco.r2dbc.foomanagement.dataaccess.api.BarEntity;

import reactor.core.publisher.Mono;

/**
 * Repo für BarEntities
 *
 */
public interface BarRepository extends ReactiveCrudRepository<BarEntity, Long> {

  /**
   * Sucht ein {@link BarEntity} nach Name
   *
   * @param name Name der BarEntity
   * @return {@link BarEntity}
   */
  Mono<BarEntity> findByName(String name);
}
