package de.yoktobit.daacco.jdbc.foomanagement.dataaccess.api.repo;

import com.infobip.spring.data.jdbc.QuerydslJdbcRepository;

import de.yoktobit.daacco.jdbc.foomanagement.dataaccess.api.BarEntity;

public interface BarQueryDslRepository extends QuerydslJdbcRepository<BarEntity, Long> {
    
}
