package com.hibernate.one_to_many;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class OneToManyMappingMain {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure("com/hibernate/one_to_many/configMany.xml");
        SessionFactory factory = configuration.buildSessionFactory();
        Session session = factory.openSession();

        OneQuestion question = new OneQuestion();
        question.setQuestion("How Many Social Media App");

        ManyAnswer answer = new ManyAnswer();
        answer.setAnswer(" (1)Facebook");
        answer.setQuestion(question);



        ManyAnswer answer1 = new ManyAnswer();
        answer1.setAnswer("(2) X");
        answer1.setQuestion(question);


        List<ManyAnswer> list = new ArrayList<>();
        list.add(answer);
        list.add(answer1);


        question.setList(list);
        Transaction transaction = session.beginTransaction();
        session.save(question);

        transaction.commit();
        session.close();
        factory.close();
    }
}