package com.gumtree.enums;

/**
 * 
 * @author rpayal
 *
 */
public enum Gender {
	MALE("Male"),
    FEMALE("Female");

    private String name;

    Gender(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    /**
     * 
     * @param name
     * @return
     */
    public static Gender fromString(String name) {
        if (name != null) {
          for (Gender gender : Gender.values()) {
            if (name.equalsIgnoreCase(gender.name)) {
              return gender;
            }
          }
        }
        return null;
      }
}
