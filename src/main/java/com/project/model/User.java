package com.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Users")
public class User {

	@Id
	@GeneratedValue
	private int id;
	
	@Column(name="user_name")
	private String user_name;
	
	@Column(name="first_name")
	private String first_name; 
	
	@Column(name="last_name")
	private String last_name;
	
	@Column(name="age")
	private int age;
	@Column(name="gender")
	private String gender;
	@Column(name="email")
	private String email;  
	@Column(name="password")
	private String password;
	
	
	private transient int percentage;
	
	public User() {}
	public User(String fname, String lname, String uname, int age, String email, String pass) {
		this.first_name = fname;
		this.last_name = lname;
		this.user_name = uname;
		this.age = age;
		this.email = email;
		this.password = pass;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getPercentage() {
		return percentage;
	}
	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}
}
