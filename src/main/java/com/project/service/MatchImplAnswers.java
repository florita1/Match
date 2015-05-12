package com.project.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.project.model.Questions;
import com.project.model.User;

public class MatchImplAnswers implements IMatch{
	
	private static SessionFactory factory;
	
	public MatchImplAnswers() {
		try{
	    	  Configuration configuration = new Configuration().configure();
	    	  StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
	    	  factory = configuration.buildSessionFactory(builder.build());
	    	  
	      }catch (Throwable ex) { 
	         System.err.println("Failed to create sessionFactory object." + ex);
	         throw new ExceptionInInitializerError(ex); 
	      }
	}

	public int getPercentage(List setAnswers) {
		List<Boolean> answers = setAnswers;
		int yes = 0;
		for(boolean answer : answers) {
			if(answer) {
				yes += 1;
			}
		}
		float dec =  (float) yes/answers.size();
		dec = dec*100;
		int percentage = (int) dec;
		
		return percentage;
	}

	public List getAnswers(int userId) {
		Session session = factory.openSession();
		String hql = "FROM Questions WHERE id = :uid";
		Query query = session.createQuery(hql);
		query.setParameter("uid", userId);
		List answers = query.list();
		session.close();
		return answers;
	}
	
	@Override
	public void setAnswers(Questions answers) {
		Session session = factory.openSession();
		session.save(answers);
		session.close();
		
	}

	@Override
	public User getUser(int id) {
		return null;	
	}
	
	@Override
	public void registerUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
