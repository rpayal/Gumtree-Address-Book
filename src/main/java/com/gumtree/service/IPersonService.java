package com.gumtree.service;

import java.util.List;

import com.gumtree.enums.Gender;
import com.gumtree.model.Person;

/**
 * Person Service
 * 
 * @author rpayal
 *
 */
public interface IPersonService {
	/**
	 * How many days a person older then other person
	 * 
	 * @param person1
	 * @param person2
	 */
	long getPersonsAgeDiffInDays(Person person1, Person person2);
	
	/**
	 * Calculates number of person based on there sex.
	 * 
	 * @param sex
	 * @return
	 */
	List<Person> getPersons(Gender gender);
	
	/**
	 * Return oldest person in the lot.
	 * 
	 * @return
	 */
	Person getOldestPerson();
	
	/**
	 * Get Person for name passed.
	 * @param name
	 * @return
	 */
	Person getPerson(String name);
}
