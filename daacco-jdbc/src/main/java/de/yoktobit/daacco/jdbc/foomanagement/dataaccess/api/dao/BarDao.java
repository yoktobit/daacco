package de.yoktobit.daacco.jdbc.foomanagement.dataaccess.api.dao;

import de.yoktobit.daacco.jdbc.foomanagement.dataaccess.api.BarEntity;

public interface BarDao {
    
    BarEntity findByName(String name);
}
