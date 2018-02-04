package com.hackton.ulertsregistries.persistence;

import com.hackton.ulertsregistries.model.EmergencyCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EmergencyCaseRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public EmergencyCase findById(long id) {
        return jdbcTemplate.queryForObject("select * from emergencyCase where id=?", new Object[] { id },
                new BeanPropertyRowMapper<EmergencyCase>(EmergencyCase.class));
    }
}
