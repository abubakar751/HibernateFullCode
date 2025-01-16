package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetStudentDetails {

	public static void main(String[] args) {
  Configuration configuration = new Configuration();
  configuration.configure("config.xml");
  SessionFactory sessionFactory = configuration.buildSessionFactory();
  Session openSession = sessionFactory.openSession();
 
  Address address = openSession.get(Address.class,10);
  System.out.println(address);
  Student student = openSession.load(Student.class,10 );
  System.out.println(student);
  sessionFactory.close();
  openSession.close();
  
  
  
	}

}
