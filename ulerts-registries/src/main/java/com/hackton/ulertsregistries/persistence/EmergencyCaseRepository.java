package com.hackton.ulertsregistries.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZoneId;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.hackton.ulertsregistries.model.EmergencyCase;
import com.hackton.ulertsregistries.model.EmergencyCase.EmergencyType;
import com.hackton.ulertsregistries.model.EmergencyCase.FireState;

@Repository
public class EmergencyCaseRepository {
   
	@Autowired
    JdbcTemplate jdbcTemplate;

    public EmergencyCase findById(long id) {
        return jdbcTemplate.queryForObject("select * from emergencyCase where id=?", new Object[] { id },
                new BeanPropertyRowMapper<EmergencyCase>(EmergencyCase.class));
    }
    
    public List<EmergencyCase> findAll() {
		return jdbcTemplate.query("select * from emergencyCase", new EmergencyCaseRowMapper());
	}
    
	public int deleteById(long id) {
		return jdbcTemplate.update("delete from emergencyCase where id=?", new Object[] { id });
	}

	public int insert(EmergencyCase emergencyCase) {
		return jdbcTemplate.update("insert into emergencyCase (emergencyType, numberPeopleHurt, numberCarImplied, desincarcerateNumber, ETAPolice, ETAFirefighters, ETAAmbulance, fireState, matchedSos) " 
	+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?)",
				new Object[] { emergencyCase.getEmergencyType().toString(), emergencyCase.getNumberPeopleHurt(), emergencyCase.getNumberCarImplied(), emergencyCase.getDesincarcerateNumber(), emergencyCase.getETAPolice(), emergencyCase.getETAFirefighters(),
						emergencyCase.getETAAmbulance(), emergencyCase.getFireState().toString(), emergencyCase.getMatchedSos()});
	}

	public int update(EmergencyCase emergencyCase) {
		return jdbcTemplate.update("update emergencyCase " + 
	" set emergencyType = ?, numberPeopleHurt = ?, numberCarImplied = ?, desincarcerateNumber = ?, ETAPolice = ?, ETAFirefighters = ?, ETAAmbulance = ?, fireState = ?, matchedSos = ? " + " where id = ?",
				new Object[] { emergencyCase.getDesincarcerateNumber(), emergencyCase.getEmergencyType(), emergencyCase.getETAAmbulance(), 
						emergencyCase.getETAFirefighters(), emergencyCase.getETAPolice(), emergencyCase.getFireState(), emergencyCase.getMatchedSos().getSos().getPhoneNumber(), emergencyCase.getNumberCarImplied(),
						emergencyCase.getNumberPeopleHurt(),emergencyCase.getId()});
	}
	
	 class EmergencyCaseRowMapper implements RowMapper<EmergencyCase> {
			@Override
			public EmergencyCase mapRow(ResultSet rs, int rowNum) throws SQLException {
				EmergencyCase emergencyCase = new EmergencyCase();
				emergencyCase.setId(rs.getInt("id"));
				emergencyCase.setDesincarcerateNumber(rs.getInt("desincarcerateNumber"));
				emergencyCase.setEmergencyType(EmergencyType.valueOf(rs.getString("emergencyType")));
				emergencyCase.setETAAmbulance(rs.getDate("ETAAmbulance")!= null ? rs.getDate("ETAAmbulance").toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime():null);
				emergencyCase.setETAFirefighters(rs.getDate("ETAFirefighters")!=null ? rs.getDate("ETAFirefighters").toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime():null);
				emergencyCase.setETAPolice(rs.getDate("ETAPolice")!=null ? rs.getDate("ETAPolice").toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime():null);
				emergencyCase.setFireState(rs.getString("fireState")!=null ? FireState.valueOf(rs.getString("fireState")): null);
				emergencyCase.setMatchedSos(null);
				emergencyCase.setNumberCarImplied(rs.getInt("numberCarImplied"));
				emergencyCase.setNumberPeopleHurt(rs.getInt("numberPeopleHurt"));
				return emergencyCase;
			}

		}
}
