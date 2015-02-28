package com.gumtree.dao;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.gumtree.GumtreeApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = GumtreeApplication.class)
@WebAppConfiguration
@IntegrationTest
public class PersonDAOTest {
	@Autowired
	private PersonDAO personDAO;
	
	@Test
	public void testGetPersons() {
		assertEquals(personDAO.getPersons().size(), 4);
	}
}
