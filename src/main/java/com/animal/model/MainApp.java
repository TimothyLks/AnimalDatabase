package com.animal.model;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

import com.animal.model.dao.JDBCAnimalDAO;

import java.util.*;

public class MainApp {

	public static void main(String[] args) 
	{		
		Scanner s = new Scanner(System.in);
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		//Object animalDAO = context.getBean("animalDAO");
		JDBCAnimalDAO jdbcAnimalDAO = (JDBCAnimalDAO) context.getBean("jdbcAnimalDAO");
		
		int id, age;
		String type, gender, height;
			
		System.out.println("Command Options: ");
		System.out.println("1: Insert animal");
		System.out.println("2: Find Animal by id");
		System.out.println("3: Find all animals");
		System.out.println("4: Find animal type by id");
		System.out.println("?: Display");
		System.out.println("7: Quit");
		Scanner scan = new Scanner(System.in);
		String choice = s.nextLine();
		
		do {	
		switch (choice){
		    case "1":
		    	System.out.println("Which type of animal do you want to create?");
                type = s.nextLine();
                
                if(type.equals("cow")||type.equals("goat")||type.equals("mountain goat"))
                {
	                System.out.println("Id?");
	                id = s.nextInt();
	                
	                System.out.println("Age?");
	                age = s.nextInt();
	                	                
		            System.out.println("Gender?");
		            gender = s.next();
		            
		            if(gender.equals("male")||gender.equals("female"))
	                {
		            	System.out.println("Height?");
		                height = s.next();
		                
		        		Animal animal = new Animal(id, type, age, gender, height);
		        		jdbcAnimalDAO.insert(animal);
		                System.out.println("You are back in the option menu");
		        		choice= s.nextLine();
		        		break;
	                }
		            else
		            {
		            	System.out.println("Sorry, the gender you chose is not available");
	                	System.out.println("Please choose between male and female");
	                	gender = s.next();
		            }
	                
                }else 
                {
	        		System.out.println("Sorry, the animal you chose is not available");
                	System.out.println("Please choose between cow, goat or mountain goat");
                }
	        		break;
		        
		    case "2":
		    	System.out.println("Give an id");
        		id = s.nextInt();
            	Animal animal = jdbcAnimalDAO.findById(id);
        		System.out.println(animal);
        		System.out.println("You are back in the option menu");
        		choice= s.nextLine();
		        break;
		    case "3":
		    	List<Animal> animals = jdbcAnimalDAO.findAll();
        		System.out.println(animals);
        		System.out.println("You are back in the option menu");
        		choice= s.nextLine();
        		break;
		    case "4":
		    	System.out.println("Give an id");
        		id = s.nextInt();
            	type = jdbcAnimalDAO.findTypeById(id);
        		System.out.println(type);
        		System.out.println("You are back in the option menu");
        		choice= s.nextLine();
		        break;
		    case "?":
		    	System.out.println("Command Options: ");
				System.out.println("1: Insert animal");
				System.out.println("2: Find Animal by id");
				System.out.println("3: Find all animals");
				System.out.println("4: Find animal type by id");
				System.out.println("?: Display");
				System.out.println("7: Quit");
				choice= s.nextLine();
		            break; 
			default:
				System.out.println("Invalid choice");
				choice= s.nextLine();
				break;
		}}while (choice != "7");
	}
	}
	
	