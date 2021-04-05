package de.yoktobit.daacco.jpa.foomanagement.dataaccess.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import de.yoktobit.daacco.jpa.foomanagement.dataaccess.api.FooEntity;

public interface FooRepository extends JpaRepository<FooEntity, Long> {
    
}
