package com.animal.model.dao;

import com.animal.model.*;
import java.util.*;

public interface JDBCAnimalDAO {

	public void insert(Animal animal);
	public Animal findById(int id);
	public List<Animal> findAll();
	public String findTypeById(int id);
}
