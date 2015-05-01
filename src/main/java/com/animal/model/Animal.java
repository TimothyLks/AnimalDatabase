package com.animal.model;

public class Animal {
	
	private int id, age;
    private String type,gender,height;
	
    public Animal()
    {
    	
    }
    
    public Animal(int id, String type, int age, String gender, String height)
    {
        this.id = id;
        this.type = type;
        this.age = age;
        this.gender = gender;
        this.height = height;
    }
    
    public int getId()
    {
        return id;
    }
    
    public int getAge()
    {
        return age;
    }
    
    public String getType()
    {
        return type;
    }
    
    public String getGender()
    {
        return gender;
    }
     
    public String getHeight()
    {
        return height;
    }
    
    public void setId(int id)
    {
        this.id = id;
    }
    
    public void setAge(int age)
    {
        this.age = age;
    }
    
    public void setType(String type)
    {
        this.type = type;
    }
    
    public void setGender(String Gender)
    {
        this.gender = gender;
    }
     
    public void setHeight(String height)
    {
        this.height = height;
    }
    
    @Override
    public String toString()
    {
    	return "id= "+ id + ", type= "+ type + ", age= "+ age + ", gender= "+ gender + ", height= "+ height; 
    }
}
