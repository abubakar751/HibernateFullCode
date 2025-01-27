package com.hibernate.one_to_one;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainOneToOneMapping {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure("com/hibernate/one_to_one/config.xml");
        SessionFactory factory = configuration.buildSessionFactory();
        Session session = factory.openSession();

        Transaction transaction = session.beginTransaction();

        // Define 20 sample question-answer pairs
        String[][] questionAnswers = {
            {"What is Java?", "Java is a high-level, class-based, object-oriented programming language."},
            {"What is an Object in OOP?", "An object is an instance of a class that encapsulates data and behavior."},
            {"What is polymorphism in Java?", "Polymorphism is the ability of an object to take on many forms."},
            {"What is inheritance in OOP?", "Inheritance allows one class to inherit the properties and methods of another."},
            {"What is encapsulation?", "Encapsulation is the bundling of data with the methods that operate on it."},
            {"What are access modifiers in Java?", "Access modifiers determine the visibility of variables, methods, and classes."},
            {"What is the difference between an ArrayList and a LinkedList?", "ArrayList is backed by a dynamic array, while LinkedList is based on a doubly-linked list."},
            {"What is the purpose of the 'static' keyword?", "The 'static' keyword is used for memory management and to create shared members of a class."},
            {"What is multithreading?", "Multithreading is the ability of a program to execute multiple threads concurrently."},
            {"What are lambda expressions in Java?", "Lambda expressions provide a concise way to represent functional interfaces."},
            {"What is a functional interface?", "A functional interface is an interface with only one abstract method."},
            {"What is the Stream API in Java 8?", "The Stream API is used for functional-style operations on collections."},
            {"What is lazy loading in Hibernate?", "Lazy loading delays the initialization of an object until it is accessed."},
            {"What is a primary key in SQL?", "A primary key uniquely identifies each record in a table."},
            {"What is normalization in a database?", "Normalization organizes data to reduce redundancy and improve integrity."},
            {"What is ACID in databases?", "ACID stands for Atomicity, Consistency, Isolation, and Durability."},
            {"What is a REST API?", "A REST API is an architectural style for designing networked applications."},
            {"What is dependency injection in Spring?", "Dependency injection is a design pattern where a class receives its dependencies from an external source."},
            {"What is eager loading in Hibernate?", "Eager loading fetches associated data immediately with the main object."},
            {"What is the difference between a PUT and POST request in REST?", "PUT is used to update a resource, while POST is used to create a new resource."}
        };

        // Add each question and answer to the database
        for (String[] qa : questionAnswers) {
            Question question = new Question();
            question.setQuestion(qa[0]);

            Answer answer = new Answer();
            answer.setAnswer(qa[1]);

            // Establish the relationship
            answer.setQuestion(question);
            question.setAnswer(answer);

            // Persist both entities
            session.persist(question);
            session.persist(answer);
        }

        transaction.commit();
        session.close();
        factory.close();

        System.out.println("20 Question and Answer entries added successfully!");
    }
}
