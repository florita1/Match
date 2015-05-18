package com.project.service;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.project.model.Answers;
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

	public int getPercentage(List<String> setAnswers) {
		List<String> answers = setAnswers;
		int yes = 0;
		for(String answer : answers) {
			if(answer.equals("Yes")) {
				yes += 1;
			}
		}
		float dec =  (float) yes/answers.size();
		dec = dec*100;
		int percentage = (int) dec;
		
		return percentage;
	}

	@SuppressWarnings("unchecked")
	public List<Answers> getAnswers(User user) {
		Session session = factory.openSession();
		//Criteria c = session.createCriteria(Answers.class);
		//List<Answers> answers = c.list();
		//Questions answers = (Questions) session.get(Questions.class);
		String hql = "FROM Answers WHERE user_id = :uid";
		Query query = session.createQuery(hql);
		query.setParameter("uid", user);
		List<Answers> answers = query.list();
		session.close();
		return answers;
	}
	
	@Override
	public void setAnswers(Answers answer) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(answer);
		tx.commit();
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
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getId(String name) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<User> searchUsers(String ageRange, String gender) {
		// TODO Auto-generated method stub
		return null;
	}

}
