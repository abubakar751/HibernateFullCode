package com.hibernate.fetch_technique;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class FetchTechnique {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure("com/hibernate/fetch_technique/fetchTechnique.xml");
        SessionFactory factory = configuration.buildSessionFactory();
        Session session = factory.openSession();

		/*
		 * Person person = new Person(); person.setName("AbuBakar");
		 * 
		 * Account account = new Account(); account.setName(" (1)Facebook");
		 * account.setPerson(person);
		 * 
		 * 
		 * 
		 * Account account1 = new Account(); account1.setName("(2) X");
		 * account1.setPerson(person);
		 * 
		 * 
		 * List<Account> list = new ArrayList<>(); list.add(account);
		 * list.add(account1);
		 * 
		 * 
		 * person.setList(list); Transaction transaction = session.beginTransaction();
		 * session.save(person);
		 * 
		 * transaction.commit();
		 */
        Person person = session.get(Person.class, 1);
        System.out.println(person.getId());
        System.out.println(person.getName());
        System.out.println(person.getList().size());

        session.close();
        factory.close();
    }
}