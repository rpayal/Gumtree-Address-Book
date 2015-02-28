package com.gumtree.model;

import java.util.Date;

import com.gumtree.enums.Gender;

/**
 * Person 
 * 
 * @author rpayal
 *
 */
public class Person {
	 	private String name;
	    private Gender gender;
	    private Date birthDate;
	    
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Gender getGender() {
			return gender;
		}
		public void setGender(Gender gender) {
			this.gender = gender;
		}
		public Date getBirthDate() {
			return birthDate;
		}
		public void setBirthDate(Date birthDate) {
			this.birthDate = birthDate;
		}
		
		@Override
		public String toString() {
			return "Person [name=" + name + ", gender=" + gender + ", birthDate="
					+ birthDate + "]";
		}
}
