package com.project.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class Questionnaire {
	
private static SessionFactory factory;
	
	public Questionnaire() {
		try{
	    	  Configuration configuration = new Configuration().configure();
	    	  StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
	    	  factory = configuration.buildSessionFactory(builder.build());
	    	  
	      }catch (Throwable ex) { 
	         System.err.println("Failed to create sessionFactory object." + ex);
	         throw new ExceptionInInitializerError(ex); 
	      }
	}
	
	public List getQuestions() {
		Session session = factory.openSession();
		List questions = session.createQuery("FROM Questions").list();
		session.close();
		return questions;
	}
	
//	public void setQuestions(List<String> questions) {
//		Session session = factory.openSession();
//		for( String q : questions) {
//			session.save(q);
//		}
//		session.close();
//	}
	
}
