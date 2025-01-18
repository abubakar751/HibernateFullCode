package com.hibernate.many_to_one;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;

public class ManyToOneMain {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure("com/hibernate/many_to_one/configManyToOne.xml");

        SessionFactory factory = configuration.buildSessionFactory();
        Session session = factory.openSession();

        OneAnswer oneAnswer = new OneAnswer();
        oneAnswer.setOneAnswer(" In OOPS Is Paradigm ");

        ManyQuestion manyQuestion = new ManyQuestion();
        manyQuestion.setManyQuestion("What is OOPS In Java");
        manyQuestion.setAnswer(oneAnswer);

        ManyQuestion manyQuestion1 = new ManyQuestion();
        manyQuestion1.setManyQuestion("What is Paradigm in java ");
       manyQuestion1.setAnswer(oneAnswer);
        ArrayList<ManyQuestion> list = new ArrayList<>();
        list.add(manyQuestion);
        list.add(manyQuestion1);
        oneAnswer.setManyQuestion(list);
        Transaction transaction = session.beginTransaction();
        session.save(oneAnswer);
        transaction.commit();
        session.close();
        factory.close();


    }
}
