package com.omkarsh.jackson.json.demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args) {
	
		 try {
			 
			 //create object mapper
			 ObjectMapper mapper = new ObjectMapper();
			 
			 
			 //read JSON file and map/convert to JAVA POJO : data/sample-lite.json
			 
			/* Student theStudent =
					 mapper.readValue(new File("data/sample-lite.json"), Student.class);
			 */
			 Student theStudent =
					 mapper.readValue(new File("data/sample-full.json"), Student.class);
			 
			 //print first and last name
			 System.out.println("First Name = "+theStudent.getFirstName());
			 System.out.println("Last Name = "+theStudent.getLastName());
			 
			 //printing address:street, city
			 Address add = theStudent.getAddress();
			 
			 System.out.println("Street = "+add.getStreet());
			 System.out.println("City = "+add.getCity());
			 
			 //print out languages
			 for(String tempLang:theStudent.getLanguages())
			 {
				 System.out.println(tempLang);
			 }
		 }
		 catch (Exception e) {

			 e.printStackTrace();
		 
		 }
		
		
		
		
		
		
	}

}
