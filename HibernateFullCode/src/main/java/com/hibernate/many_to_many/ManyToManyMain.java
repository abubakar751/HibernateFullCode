package com.hibernate.many_to_many;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

    public class ManyToManyMain {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure("com/hibernate/many_to_many/configManyToMany.xml");
        SessionFactory factory = configuration.buildSessionFactory();
        Session session = factory.openSession();

        Department department = new  Department();
        Department department1 = new Department();
        
        department.setDepartName("BCA");
        department1.setDepartName("BSC");

        Student student = new Student();
        Student student1 = new Student();

        student.setStudentName("Abu Bakar");
        student1.setStudentName("Abu ");

        ArrayList<Student> studentList = new ArrayList<>();
        ArrayList<Department> departmentList = new ArrayList<>();

        studentList.add(student);
        studentList.add(student1);

        departmentList.add(department);
        departmentList.add(department1);


        student.setDepartments(departmentList);
        department1.setStudents(studentList);


        Transaction transaction = session.beginTransaction();
        session.save(student);
        session.save(student1);
        session.save(department);
        session.save(department1);
        transaction.commit();
        session.close();
        factory.close();



    }
}
