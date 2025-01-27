package com.hibernate.sql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import com.hibernate.one_to_one.Question;

public class SQLExample {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("com/hibernate/one_to_one/config.xml").buildSessionFactory();
		Session session = factory.openSession();
		String query = "select * from Question ";
		NativeQuery<Question> nativeQuery = session.createNativeQuery(query, Question.class);
		List<Question> list = nativeQuery.list();
		for (Question list2 : list) {
			System.out.println(list2.getQuestionId() + "    " + list2.getQuestion());

		}
		session.close();
		factory.close();
	}

}
