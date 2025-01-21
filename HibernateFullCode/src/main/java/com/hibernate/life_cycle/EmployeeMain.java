package com.hibernate.life_cycle;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmployeeMain {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure("com/hibernate/life_cycle/config.xml");
        SessionFactory factory = configuration.buildSessionFactory();
        Employee employee = new Employee("Abu Bakar", 400000);  //Transient State
        Session session = factory.openSession();              // Persistence State from here
        Transaction transaction = session.beginTransaction(); // ....
        session.save(employee);                               //.. to here  here
        session.delete(employee);//.. Removed State
        transaction.commit();
        session.close();                                      //Detached State
        

    }
}
