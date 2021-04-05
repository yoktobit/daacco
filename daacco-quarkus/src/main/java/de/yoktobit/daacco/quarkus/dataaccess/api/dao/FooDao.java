package de.yoktobit.daacco.quarkus.dataaccess.api.dao;

import de.yoktobit.daacco.quarkus.dataaccess.api.FooEntity;
import io.smallrye.mutiny.Multi;

public interface FooDao {
    
    Multi<FooEntity> findAll();
}
