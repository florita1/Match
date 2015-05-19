package com.project.service;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
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

	@Override
	public int getPercentage(List<Answers> userAnswers, List<Answers> matchAnswers) {
		int yes = 0;
		for(int x = 0; x <= userAnswers.size()-1; x++) {
			String uAnswer = userAnswers.get(x).getAnswer();
			String mAnswer = matchAnswers.get(x).getAnswer();
			if(uAnswer.equals(mAnswer)) {
				yes += 1;
			}
		}
		float dec =  (float) yes/userAnswers.size();
		dec = dec*100;
		int percentage = (int) dec;

		return percentage;
	}

	@SuppressWarnings("unchecked")
	public List<Answers> getAnswers(User user) {

		Session session = factory.openSession();
		Transaction tx = null;
		List<Answers> answers = null;
		try{
			tx = session.beginTransaction();
			String hql = "FROM Answers WHERE user_id = :uid";
			Query query = session.createQuery(hql);
			query.setParameter("uid", user);
			answers = query.list();
			tx.commit();
		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		}finally {
			session.close(); 
		}
		return answers;
	}

	@Override
	public void setAnswers(Answers answer) {
		Session session = factory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.save(answer);
			tx.commit();
		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		}finally {
			session.close(); 
		}

	}
	
	@Override
	public void editAnswers(Answers answer) {
		Session session = factory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.update(answer);
			tx.commit();
		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		}finally {
			session.close(); 
		}
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
