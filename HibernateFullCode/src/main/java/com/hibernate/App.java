package com.hibernate;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        
      Configuration configuration = new Configuration();
      configuration.configure("com/config.xml");
      SessionFactory sessionFactory = configuration.buildSessionFactory(); 
      Student student = new Student();
      student.setId(102);
      student.setName("AbuBakar");
      student.setCollegeName("ARC PG College");
		/*
		 * Address address = new Address(); address.setName("AbuBakar");
		 * address.setSecName("Chaudhhry"); address.setDate(new Date()); FileInputStream
		 * fileInputStream = new FileInputStream("src/main/java/com/hibernate/5.png");
		 * byte []data= new byte[fileInputStream.available()];
		 * fileInputStream.read(data); address.setImage(data);
		 */
    
      Session currentSession = sessionFactory.openSession();
      Transaction beginTransaction = currentSession.beginTransaction();
      currentSession.save(student);	
      beginTransaction.commit();
      sessionFactory.close();
      
    }
}
