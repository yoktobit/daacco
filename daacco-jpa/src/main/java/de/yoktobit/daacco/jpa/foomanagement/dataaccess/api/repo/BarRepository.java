package de.yoktobit.daacco.jpa.foomanagement.dataaccess.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import de.yoktobit.daacco.jpa.foomanagement.dataaccess.api.BarEntity;

public interface BarRepository extends JpaRepository<BarEntity, Long> {
    
    BarEntity findByName(String name);
}
