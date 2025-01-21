package com.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.enties.Note;
import com.helper.FactoryProvoider;

public class SaveNotServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public SaveNotServlet() {
        super();
       
    }

	

	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
             SessionFactory factory = FactoryProvoider.getFactory();
            if (factory == null) {
                throw new RuntimeException("SessionFactory is null. Check FactoryProvoider initialization.");
            }

            String parameter = request.getParameter("title");
            String parameter2 = request.getParameter("content");

            Note note = new Note(parameter, parameter2, new Date());
            System.out.println(note);

            Session session = factory.openSession();
            Transaction transaction = session.beginTransaction();
            session.save(note);
            transaction.commit();
            session.close();

            response.getWriter().println("Note saved successfully!");

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("An error occurred: " + e.getMessage());
        }
    }


}
