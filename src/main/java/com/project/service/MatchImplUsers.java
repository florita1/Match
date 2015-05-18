package com.project.service;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import com.project.model.Answers;
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
		Transaction tx = session.beginTransaction();
		session.save(user);
		tx.commit();
		session.close();
	}
	
	@Override
	public int getId(String name) {
		Session session = factory.openSession();
		String hql = "SELECT id FROM User WHERE user_name= :name";
		Query query = session.createQuery(hql);
		query.setParameter("name",name);
		List pass = query.list();
		int id = 0;
		for (Iterator iterator = pass.iterator(); iterator.hasNext();){
			id = (int) iterator.next();
		}
		session.close();
		
		return id;
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
		Transaction tx = session.beginTransaction();
		session.update(user);
		tx.commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUsers() {
		Session session = factory.openSession();
		List<User> users = session.createQuery("FROM User").list();
		return users;
	}
	
	@Override
	public List<User> searchUsers(String ageRange, String gender) {
		int max = 100;
		int min = 0;
		if(ageRange.equals("a1")) {
			max = 23; min = 20;
		} else if(ageRange.equals("a2")) {
			max = 27; min = 24;
		} else {
			max = 31; min = 28;
		}	
		Session session = factory.openSession();
		String hql = "FROM User WHERE age between :min and :max";
		Query query = session.createQuery(hql);
		query.setParameter("min",min);
		query.setParameter("max",max);
		List<User> users = query.list();
		session.close();
		
		return users;
	}

	@Override
	public void setAnswers(Answers userAnswers) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Answers> getAnswers(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getPercentage(List<String> answers) {
		// TODO Auto-generated method stub
		return 0;
	}

}
