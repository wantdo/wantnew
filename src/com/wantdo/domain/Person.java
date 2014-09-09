package com.wantdo.domain;

/**
 * Person entity. @author MyEclipse Persistence Tools
 */

public class Person implements java.io.Serializable {

	// Fields

	private Integer id;
	private String username;
	private String password;
	private String users;

	// Constructors

	/** default constructor */
	public Person() {
	}

	/** full constructor */
	public Person(String username, String password,String users) {
		this.username = username;
		this.password = password;
		this.users = users;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsers() {
		return users;
	}

	public void setUsers(String users) {
		this.users = users;
	}

}