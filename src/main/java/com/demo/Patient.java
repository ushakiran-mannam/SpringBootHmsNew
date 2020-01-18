package com.demo;

public class Patient extends User{

	/** The age. */
	private int age;

	/** The name. */
	private String name;

	/** The area. */
	private String areaOfLiving;

	/** The state. */
//	private String state;

	/** The city. */
	private String newCity;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Gets the age.
	 *
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Sets the age.
	 *
	 * @param age the new age
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the area.
	 *
	 * @return the area


	/**
	 * Gets the state.
	 *
	 * @return the state
	 */
//	public String getState() {
//		return state;
//	}
//
//	/**
//	 * Sets the state.
//	 *
//	 * @param state the new state
//	 */
//	public void setState(String state) {
//		this.state = state;
//	}
	public String getAreaOfLiving() {
		return areaOfLiving;
	}

	public void setAreaOfLiving(String area) {
		this.areaOfLiving = area;
	}

	/**
	 * Gets the city.
	 *
	 * @return the city
	 */
	public String getNewCity() {
		return newCity;
	}

	

	/**
	 * Sets the city.
	 *
	 * @param city the new city
	 */
	public void setNewCity(String newCity) {
		this.newCity = newCity;
	}

	/** The id. */
	private int id;

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return id + "," + name + "," + age + "," + "," + newCity + "," ;

	}

}
