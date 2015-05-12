package com.project.service;

import java.util.List;

import com.project.model.User;

public interface IMatch {

	// Method to register a user to the database
	public void registerUser(User user);

	// Method to get a specific user profile
	public User getUser(int id);
	
	// Method to get password to verify login
	public String getPassword(String name);

	// Method to edit user profile
	public void editUser(User user);

	// Method to get all users profiles
	public List getAllUsers();

	// Method to add user answers to table
	public void setAnswers(int id, List answers);

	// Method to get a users answers
	public List getAnswers(int id);

	// Method to get percentage for users answers
	public int getPercentage(List answers);

}
