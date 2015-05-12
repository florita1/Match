package com.project.service;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.project.model.User;

@Repository
public class MatchImplUsers implements IMatch {
	
	private static SessionFactory factory;
	
	public MatchImplUsers() {
		try{
			Configuration configuration = new Configuration().configure();
			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
			factory = configuration.buildSessionFactory(builder.build());

		}catch (Throwable ex) { 
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex); 
		}
	}

	@Override
	public void registerUser(User user) {
		Session session = factory.openSession();
		session.save(user);
		session.close();
	}
	
	@Override
	public String getPassword(String name) {
		Session session = factory.openSession();
		String hql = "SELECT password FROM User WHERE user_name= :name";
		Query query = session.createQuery(hql);
		query.setParameter("name",name);
		List pass = query.list();
		String passWord = "";
		for (Iterator iterator = pass.iterator(); iterator.hasNext();){
			passWord = (String) iterator.next();
		}
		session.close();
		
		return passWord;
	}

	@Override
	public User getUser(int id) {
		Session session = factory.openSession();
		User user = (User) session.get(User.class, id);
		session.close();
		return user;
	}

	@Override
	public void editUser(User user) {
		Session session = factory.openSession();
		session.update(user);
		session.close();
	}

	@Override
	public List getAllUsers() {
		Session session = factory.openSession();
		List users = session.createQuery("FROM User").list();
		return users;
	}

	@Override
	public void setAnswers(int id, List answers) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List getAnswers(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getPercentage(List answers) {
		// TODO Auto-generated method stub
		return 0;
	}
}
