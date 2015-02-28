package com.gumtree.dao;

import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import au.com.bytecode.opencsv.CSVReader;

import com.gumtree.enums.Gender;
import com.gumtree.model.Person;

@Component
public class PersonDAO implements IPersonDAO, InitializingBean {

    @Value("${address.book.file.location}")
    private String fileLocation;
    
    private List<Person> persons = new ArrayList<>();
    
	@Override
	public List<Person> getPersons() {
		// TODO Auto-generated method stub
		return persons;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
		
		//create CSVReader object
        CSVReader reader = new CSVReader(new FileReader(new File(getClass().getClassLoader().getResource(fileLocation).getFile())), ',');
 
        //read all lines at once
        List<String[]> records = reader.readAll();
         
        Iterator<String[]> iterator = records.iterator();
         
        while(iterator.hasNext()){
            String[] record = iterator.next();
            Person person = new Person();
            person.setName(record[0].trim());
            person.setGender(Gender.fromString(record[1].trim()));
            person.setBirthDate(sdf.parse(record[2].trim()));
            persons.add(person);
        }
        reader.close();
        System.out.println("PERSONS --> " + persons);
	}

}
