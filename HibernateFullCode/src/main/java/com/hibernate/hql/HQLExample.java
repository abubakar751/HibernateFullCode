package com.hibernate.hql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.hibernate.life_cycle.Employee;

public class HQLExample {
	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure("com/hibernate/life_cycle/config.xml");
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();

		String query = "from Employee where empSalary=:salary";
		
		Query q=session.createQuery(query);
		q.setParameter("salary", 400000.0);
		List<Employee> list =q.list();
		for(Employee list2:list) {
		System.out.println(list2.getEmpName());
		
		}
		session.close();
		factory.close();
	}
}
