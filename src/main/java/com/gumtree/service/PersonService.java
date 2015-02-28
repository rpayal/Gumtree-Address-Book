package com.gumtree.service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gumtree.dao.IPersonDAO;
import com.gumtree.enums.Gender;
import com.gumtree.model.Person;

@Service
public class PersonService implements IPersonService {
	@Autowired
	private IPersonDAO personDAO;

	@Override
	public long getPersonsAgeDiffInDays(Person person1, Person person2) {
		long ageDiff = 0;
		LocalDate person1LocalDate = getLocalDate(person1.getBirthDate());
		LocalDate person2LocalDate = getLocalDate(person2.getBirthDate());
		if (person1LocalDate.isBefore(person2LocalDate)) {
			ageDiff = ChronoUnit.DAYS.between(person1LocalDate,
					person2LocalDate);
		} else {
			ageDiff = ChronoUnit.DAYS.between(person1LocalDate,
					person2LocalDate);
		}
		return ageDiff;
	}

	@Override
	public List<Person> getPersons(Gender gender) {
		return personDAO.getPersons().stream()
				.filter(p -> p.getGender().equals(Gender.MALE))
				.collect(Collectors.toList());
	}

	@Override
	public Person getOldestPerson() {
		return personDAO
				.getPersons()
				.stream()
				.reduce((p1, p2) -> p1.getBirthDate().before(p2.getBirthDate()) ? p1
						: p2).get();
	}

	@Override
	public Person getPerson(String name) {
		return personDAO.getPersons().stream().filter(p -> p.getName().equals(name)).findAny().orElse(null);
	}

	/**
	 * Convert Date to LocalDate
	 * 
	 * @param date
	 * @return
	 */
	private LocalDate getLocalDate(Date date) {
		Instant instant = Instant.ofEpochMilli(date.getTime());
		return LocalDateTime.ofInstant(instant, ZoneId.systemDefault())
				.toLocalDate();
	}
}
