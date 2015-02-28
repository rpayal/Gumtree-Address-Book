package com.gumtree.dao;

import java.util.List;

import com.gumtree.model.Person;

/**
 * Person DAO 
 *  
 * @author rpayal
 *
 */
public interface IPersonDAO {
	public List<Person> getPersons();
}
