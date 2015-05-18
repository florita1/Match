package com.project.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.project.model.QuestionnaireTable;

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
	
	@SuppressWarnings("unchecked")
	public List<QuestionnaireTable> getQuestions() {
		Session session = factory.openSession();
		List<QuestionnaireTable> questions = session.createQuery("FROM QuestionnaireTable").list();
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
