package com.animal.model.dao.impl;

import java.sql.*;
import javax.sql.*;

import com.animal.model.*;
import com.animal.model.dao.*;

public class AnimalDAOImpl {

	private DataSource datasource;
	
	public void setDataSource(DataSource datasource)
	{
		this.datasource = datasource;
	}
	
	public void insert(Animal animal) 
	{
		String query = "INSERT INTO ANIMAL " + "(ID, TYPE, AGE, GENDER, HEIGHT) VALUES(?, ?, ?, ?, ?)";
		Connection conn = null;
		
		try
		{
			conn = datasource.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.executeUpdate();
			ps.setInt(1, animal.getId());
			ps.setString(2, animal.getType());
			ps.setInt(3, animal.getAge());
			ps.setString(4, animal.getGender());
			ps.setString(5, animal.getHeight());
			ps.close();
		} 
		catch(SQLException e) { throw new RuntimeException(e); }
		finally
		{
			if(conn != null)
			{
				try
				{
					conn.close();
				} 
				catch(SQLException e) {}
			}
		}
	}
	
	public Animal findById(int id)
	{
		String query = "SELECT * FROM ANIMAL WHERE ID = ?";
		Connection conn = null;
		
		try
		{
			conn = datasource.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setInt(1, id);
			Animal animal = null;
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				animal = new Animal(
						rs.getInt("ID"),
						rs.getString("TYPE"),
						rs.getInt("AGE"),
						rs.getString("GENDER"),
						rs.getString("HEIGHT")
						);
			}
			
			rs.close();
			ps.close();
			return animal;
		}
		catch(SQLException e) { throw new RuntimeException(e); }
		finally
		{
			if(conn != null)
			{
				try
				{
					conn.close();
				} 
				catch(SQLException e) {}
			}
		}
	}
	
}
