package com.gumtree.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.gumtree.GumtreeApplication;
import com.gumtree.dao.IPersonDAO;
import com.gumtree.enums.Gender;
import com.gumtree.model.Person;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = GumtreeApplication.class)
@WebAppConfiguration
@IntegrationTest
public class PersonServiceTest {
	@Autowired
	private IPersonDAO personDAO;
	
	@Autowired
	private IPersonService personService;
	
	@Test
	public void testGetPersonsAgeDiffInDays() {
		assertEquals(personService.getPersonsAgeDiffInDays(getPerson("test1", Gender.MALE, LocalDate.now().minusDays(5)), getPerson("test1", Gender.MALE, LocalDate.now())), 5);
	}
	
	@Test
	public void testGetPersons() {
		assertEquals(personService.getPersons(Gender.FEMALE).size(), 2);
		assertEquals(personService.getPersons(Gender.MALE).size(), 2);
	}
	
	@Test
	public void testGetOldestPerson() {
		assertEquals(personService.getOldestPerson().getName(), "Bill McKnight");
	}

	@Test
	public void testPerson() {
		assertEquals(personService.getPerson("Bill McKnight").getGender(), Gender.MALE);
		assertNull(personService.getPerson("tester test"));
	}

	private Person getPerson(String name, Gender gender, LocalDate dob) {
		Person person = new Person();
		person.setName(name);
		person.setGender(gender);
		person.setBirthDate(Date.from(dob.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
		return person;
	}

}
