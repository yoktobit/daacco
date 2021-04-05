package de.yoktobit.daacco.jdbc.foomanagement.dataaccess.impl.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import de.yoktobit.daacco.jdbc.foomanagement.dataaccess.api.BarEntity;
import de.yoktobit.daacco.jdbc.foomanagement.dataaccess.api.dao.BarDao;

@Component
public class BarDaoImpl implements BarDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public BarEntity findByName(String name) {
        
        return jdbcTemplate.queryForObject("SELECT * FROM bar WHERE name = ?", this::mapRow, name);
    }

    public BarEntity mapRow(ResultSet rs, int rowNum) throws SQLException {

        return BarEntity.builder().id(rs.getLong("id")).name(rs.getString("name")).build();
    }
}
