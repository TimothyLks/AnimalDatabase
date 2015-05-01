package com.animal.model.dao;

import com.animal.model.*;;

public interface AnimalDAO {
	
	public void insert(Animal animal);
	public Animal findById(int id);
}
