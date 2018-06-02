package com.pramati.dao;

import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
/**
 * @author Saroj Goudo
 * Service class for handling city search.
 */
@Component
public class CityDAOImpl implements CityDAO{

	JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/* (non-Javadoc)
	 * @see com.pramati.dao.CityDAO#getCityName(java.lang.String, int)
	 */
	@SuppressWarnings("static-access")
	@Override
	public String getCityName(String cityStartsWith,int atmost) {
		StringJoiner sj = new StringJoiner("\n");
		String sql= "select * from city where LOWER(city_name) like '"+cityStartsWith.toLowerCase()+"%' limit "+atmost;
		List<Map<String, Object>> data=jdbcTemplate.queryForList(sql);
		for (Map<String, Object> entry : data) {
		    for (Object key : entry.values()) {
		        sj.add((String)key);
		    }
		   
		}
     return sj.toString();
	}

}
