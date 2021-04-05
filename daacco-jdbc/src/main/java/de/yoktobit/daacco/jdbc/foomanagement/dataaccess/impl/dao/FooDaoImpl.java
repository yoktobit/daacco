package de.yoktobit.daacco.jdbc.foomanagement.dataaccess.impl.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import de.yoktobit.daacco.jdbc.foomanagement.dataaccess.api.FooEntity;
import de.yoktobit.daacco.jdbc.foomanagement.dataaccess.api.dao.FooDao;

@Component
public class FooDaoImpl implements FooDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public List<FooEntity> findAll() {
        
        return jdbcTemplate.query("SELECT * FROM foo", this::mapRow);
    }
    
    public FooEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
            
        return FooEntity.builder().id(rs.getLong("id")).name(rs.getString("name")).build();
    }
}
