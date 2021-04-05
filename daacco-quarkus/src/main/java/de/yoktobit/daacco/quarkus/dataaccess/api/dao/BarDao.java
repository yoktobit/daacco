package de.yoktobit.daacco.quarkus.dataaccess.api.dao;

import de.yoktobit.daacco.quarkus.dataaccess.api.BarEntity;
import io.smallrye.mutiny.Uni;

public interface BarDao {
    
    Uni<BarEntity> findByName(String name);
}
