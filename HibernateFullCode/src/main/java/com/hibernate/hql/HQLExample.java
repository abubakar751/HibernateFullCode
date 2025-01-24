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
		configuration.configure("com/hibernate/life_cycle/config.xml");
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();

		String query = "from Employee where empSalary=:salary";
		
		Query q=session.createQuery(query);
		q.setParameter("salary", 400000.0);
		List<Employee> list =q.list();
		Transaction transaction = session.beginTransaction();
		for(Employee list2:list) {
		System.out.println(list2.getEmpName());
		
		}
		System.out.println("____________________________________________________________");
		
		String query2 = "delete from Employee where empId=1";
		Query<?> create = session.createQuery(query2);
		int executeUpdate = create.executeUpdate();

		
		transaction.commit();
		System.out.println("Deleted");
		System.out.println(executeUpdate);
		
		session.close();
		factory.close();
	}
}
