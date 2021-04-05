package de.yoktobit.daacco.jdbc.foomanagement.dataaccess.api.dao;

import java.util.List;

import de.yoktobit.daacco.jdbc.foomanagement.dataaccess.api.FooEntity;

public interface FooDao {
    
    List<FooEntity> findAll();
}
