package com.project.service;

import java.util.Iterator;
import java.util.List;

import org.hibernate.FlushMode;
import org.hibernate.HibernateException;
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
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.save(user);
			tx.commit();
		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		}finally {
			session.close(); 
		}
	}

	@Override
	public int getId(String name) {
		Session session = factory.openSession();
		Transaction tx = null;
		int id = 0;
		try{
			tx = session.beginTransaction();
			String hql = "SELECT id FROM User WHERE user_name= :name";
			Query query = session.createQuery(hql);
			query.setParameter("name",name);
			List pass = query.list();
			id = 0;
			for (Iterator iterator = pass.iterator(); iterator.hasNext();){
				id = (int) iterator.next();
			}
			tx.commit();
		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		}finally {
			session.close(); 
		}
		
		return id;
	}

	@Override
	public String getPassword(String name) {
		Session session = factory.openSession();
		Transaction tx = null;
		String passWord = null;
		try{
			tx = session.beginTransaction();
			String hql = "SELECT password FROM User WHERE user_name= :name";
			Query query = session.createQuery(hql);
			query.setParameter("name",name);
			List pass = query.list();
			passWord = "";
			for (Iterator iterator = pass.iterator(); iterator.hasNext();){
				passWord = (String) iterator.next();
			}
			tx.commit();
		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		}finally {
			session.close(); 
		}

		return passWord;
	}

	@Override
	public User getUser(int id) {
		Session session = factory.openSession();
		Transaction tx = null;
		User user = null;
		try{
			tx = session.beginTransaction();
			user = (User) session.get(User.class, id);
			tx.commit();
		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		}finally {
			session.close(); 
		}
		return user;
	}

	@Override
	public void editUser(User user) {
		Session session = factory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.update(user);
			tx.commit();
		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		}finally {
			session.close(); 
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUsers() {
		Session session = factory.openSession();
		Transaction tx = null;
		List<User> users = null;
		try{
			tx = session.beginTransaction();
			users = session.createQuery("FROM User").list();

			tx.commit();
		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		}finally {
			session.close(); 
		}
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
		Transaction tx = null;
		List<User> users = null;
		try{
			tx = session.beginTransaction();
			String hql = "FROM User WHERE gender= :gender and age between :min and :max";
			Query query = session.createQuery(hql);
			query.setParameter("gender", gender);
			query.setParameter("min", min);
			query.setParameter("max", max);
			users = query.list();
			tx.commit();
		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		}finally {
			session.close(); 
		}

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
	public int getPercentage(List<Answers> userAnswers, List<Answers> matchAnswers) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void editAnswers(Answers answer) {
		// TODO Auto-generated method stub
		
	}

}
