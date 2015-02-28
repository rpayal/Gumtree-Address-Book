package com.gumtree.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gumtree.enums.Gender;
import com.gumtree.service.IPersonService;

/**
 * Controller for managing Person resource.
 * 
 * @author rpayal
 *
 */
@RestController
public class PersonController {
	@Autowired
    private IPersonService personService;
	
    @RequestMapping(value = "/rest/person/{gender}/count", method = RequestMethod.GET, produces = "application/json")
    public int getTotalPersonForGender(@PathVariable String gender) {
    	return personService.getPersons(Gender.fromString(gender)).size();
    }

    @RequestMapping(value = "/rest/person/agediff", method = RequestMethod.GET, produces = "application/json")
    public long getPersonsAgeDiff(@RequestParam(required = false, defaultValue = "Bill McKnight") String name1, @RequestParam(required = false, defaultValue = "Paul Robinson") String name2) {
    	return personService.getPersonsAgeDiffInDays(personService.getPerson(name1), personService.getPerson(name2));
    }

    @RequestMapping(value = "/rest/person/oldest", method = RequestMethod.GET, produces = "application/json")
    public String getOldestPerson() {
    	return personService.getOldestPerson().getName();
    }
}
