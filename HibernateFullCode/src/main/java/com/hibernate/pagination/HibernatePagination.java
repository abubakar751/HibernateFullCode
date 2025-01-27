package com.hibernate.pagination;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.hibernate.one_to_one.Question;

public class HibernatePagination {

	
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("com/hibernate/one_to_one/config.xml").buildSessionFactory();

	Session session = factory.openSession();
	Query query = session.createQuery("from Question ");
	Query setFirstResult = query.setFirstResult(10);
	Query setMaxResults = query.setMaxResults(10);
	List <Question> list = query.list();
	for(Question list2:list) {
		System.out.println(list2.getQuestionId()+" "+list2.getQuestion()+" "+list2.getAnswer());
	}
	session.close();
	factory.close();
	
	}

}
