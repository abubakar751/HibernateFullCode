package com.hibernate.Embeddable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmbeddableMain {
	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure("com/hibernate/Embeddable/Embadded.xml");
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session openSession = sessionFactory.openSession();
		
		/*
		 * UserAddress userAddress = new UserAddress();
		 * userAddress.setStreet("90 ft Straet"); userAddress.setCity("Sakinaka");
		 * userAddress.setZipCode("400072")
		 */;
		 UserClassForEmbadableAnnotation userClass = new UserClassForEmbadableAnnotation();
			userClass.setUserName("Abubakar");
			
	        UserAddress userAddress = new UserAddress("90 ft Street", "Sakinaka", "400072");
	        userClass.setUserAddress(userAddress);

		Transaction beginTransaction = openSession.beginTransaction();
		openSession.save(userClass);
		
		beginTransaction.commit();
		sessionFactory.close();
		openSession.close();
	}
}
