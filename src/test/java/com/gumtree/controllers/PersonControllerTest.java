package com.gumtree.controllers;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.util.ReflectionTestUtils;

import com.gumtree.enums.Gender;
import com.gumtree.model.Person;
import com.gumtree.service.IPersonService;

public class PersonControllerTest {
	private PersonController target;
	private IPersonService personService;
	private MockHttpServletRequest request;
	
	@Before
	public void setUp() throws Exception {
		personService = EasyMock.createMock(IPersonService.class);
		
		request = new MockHttpServletRequest();
		target = new PersonController();
		ReflectionTestUtils.setField(target, "personService", personService);
	}

	@Test
	public void testGetTotalPersonForGender() {
		request.setRequestURI("rest/person/Male/count");
		request.setMethod("GET");
		request.setAttribute("Accept", "application/json; charset=utf8");
		
		List<Person> persons = new ArrayList<>();
		
		EasyMock.expect(personService.getPersons(Gender.MALE)).andReturn(persons);
		
		EasyMock.replay(personService);
		target.getTotalPersonForGender(Gender.MALE.getName());
		EasyMock.verify(personService);
	}

	@Test
	public void testgetPersonsAgeDiff() {
		request.setRequestURI("rest/person/agediff");
		request.setMethod("GET");
		request.setAttribute("Accept", "application/json; charset=utf8");
		
		Person person1 = getPerson("test1", Gender.MALE, LocalDate.now().minusDays(5));
		Person person2 = getPerson("test1", Gender.MALE, LocalDate.now());
		EasyMock.expect(personService.getPerson(person1.getName())).andReturn(person1);
		EasyMock.expect(personService.getPerson(person2.getName())).andReturn(person2);
		EasyMock.expect(personService.getPersonsAgeDiffInDays(person1, person2)).andReturn(5l);
		
		EasyMock.replay(personService);
		target.getPersonsAgeDiff(person1.getName(), person2.getName());
		EasyMock.verify(personService);
	}
	
	@Test
	public void testGetOldestPerson() {
		request.setRequestURI("rest/person/agediff");
		request.setMethod("GET");
		request.setAttribute("Accept", "application/json; charset=utf8");
		
		Person person1 = getPerson("test1", Gender.MALE, LocalDate.now().minusDays(5));
		EasyMock.expect(personService.getOldestPerson()).andReturn(person1);
		
		EasyMock.replay(personService);
		target.getOldestPerson();
		EasyMock.verify(personService);
	}

	private Person getPerson(String name, Gender gender, LocalDate dob) {
		Person person = new Person();
		person.setName(name);
		person.setGender(gender);
		person.setBirthDate(Date.from(dob.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
		return person;
	}

}
