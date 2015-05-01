package com.animal.model.dao.impl;

import javax.sql.*;
import java.util.*;

import org.springframework.jdbc.core.*;

import com.animal.model.*;
import com.animal.model.dao.*;

public class JDBCAnimalDAOImpl implements JDBCAnimalDAO{

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	
	public void setDataSource(DataSource dataSource)
	{
		this.dataSource = dataSource;
	}
	
	public void insert(Animal animal)
	{
		String query = "INSERT INTO ANIMAL " + "(ID, TYPE, AGE, GENDER, HEIGHT) VALUES (?, ?, ?, ?, ?)";
		
		jdbcTemplate = new JdbcTemplate(dataSource);
		
		jdbcTemplate.update(query, new Object[] { animal.getId(),
				animal.getType(), animal.getAge(), animal.getGender(), animal.getHeight()
		});
	}
	
	@SuppressWarnings({"unchecked"})
	public Animal findById(int id)
	{
		String query = "SELECT * FROM ANIMAL WHERE ID = ?";
		Animal animal = (Animal) jdbcTemplate.queryForObject(
				query, new Object[] { id }, new BeanPropertyRowMapper(Animal.class));
		
		return animal;
	}

	@SuppressWarnings("rawtypes")
	public List<Animal> findAll()
	{
		jdbcTemplate = new JdbcTemplate(dataSource);
		String query = "SELECT * FROM ANIMAL";
		
		List<Animal> animals = new ArrayList<Animal>();
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(query);
		
		for(Map row : rows)
		{
			Animal animal = new Animal();
			animal.setId(Integer.parseInt(String.valueOf(row.get("ID"))));
			animal.setType((String)row.get("TYPE"));
			animal.setAge(Integer.parseInt(String.valueOf(row.get("AGE"))));
			animal.setGender((String)row.get("GENDER"));
			animal.setHeight((String)row.get("HEIGHT"));
			animals.add(animal);
		}
		
		return animals;
	}

	public String findTypeById(int id)
	{
		String query = "SELECT TYPE FROM ANIMAL WHERE ID = ?";
		
		String type = (String) jdbcTemplate.queryForObject(
				query, new Object[] { id }, String.class);
		
		return type;
	}
}
