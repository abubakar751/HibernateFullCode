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
        Question question = new Question();
        question.setQuestion("Who is CEO of Google");
        Answer answer = new Answer();
        answer.setAnswer("Sunder Pichayi is CEO of Google ");
        answer.setQuestion(question);
        question.setAnswer(answer);
        Transaction transaction = session.beginTransaction();
        session.persist(question);
        session.persist(answer);
        transaction.commit();
        session.close();
        factory.close();

    }
}
