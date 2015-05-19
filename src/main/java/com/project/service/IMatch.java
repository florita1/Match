package com.project.service;

import java.util.List;

import com.project.model.Answers;
import com.project.model.User;

public interface IMatch {

	// Method to register a user to the database
	public void registerUser(User user);

	// Method to get a specific user profile
	public User getUser(int id);
	
	// Method to get user id from username
	public int getId(String name);
	
	// Method to get password to verify login
	public String getPassword(String name);

	// Method to edit user profile
	public void editUser(User user);

	// Method to get all users profiles
	public List<User> getAllUsers();
	
	// Method that searches users with filters
	public List<User> searchUsers(String ageRange, String gender);
	
	// Method to edit user answers
	public void editAnswers(Answers answer);

	// Method to add user answers to table
	public void setAnswers(Answers userAnswers);

	// Method to get a users answers
	public List<Answers> getAnswers(User user);

	// Method to get percentage for users answers
	public int getPercentage(List<Answers> userAnswers, List<Answers> matchAnswers);

}
