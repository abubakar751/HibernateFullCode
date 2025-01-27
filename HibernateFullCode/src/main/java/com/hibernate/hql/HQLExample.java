package com.hibernate.hql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.hibernate.life_cycle.Employee;

public class HQLExample {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure("com/hibernate/one_to_one/config.xml");
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();

	//	String query = "from Employee where empSalary=:salary";

		
	//	  Query q=session.createQuery(query); q.setParameter("salary", 400000.0);
		 // List<Employee> list =q.list(); 
		  Transaction transaction =session.beginTransaction();
			/*
			 * for(Employee list2:list) { System.out.println(list2.getEmpName());
			 * 
			 * }
			 */
		 

		System.out.println("____________________________________________________________");
		String query2 = "SELECT q.questionId, q.question FROM Question q INNER JOIN q.answer a";
		Query<Object[]> create = session.createQuery(query2, Object[].class);
		List<Object[]> results = create.list();

		for (Object[] row : results) {
		    System.out.println("Question ID: " + row[0] + ", Question: " + row[1]);
		}
		transaction.commit();
		

		session.close();
		factory.close();
	}
}
