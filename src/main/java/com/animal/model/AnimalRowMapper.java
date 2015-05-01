package com.animal.model;

import java.sql.*;

import org.springframework.jdbc.core.*;

@SuppressWarnings("rawtypes")
public class AnimalRowMapper implements RowMapper {

	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		Animal animal = new Animal();
		animal.setId(rs.getInt("ID"));
		animal.setType(rs.getString("TYPE"));
		animal.setAge(rs.getInt("AGE"));
		animal.setGender(rs.getString("GENDER"));
		animal.setHeight(rs.getString("HEIGHT"));
		return animal;
	}		
}
