package com.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.enties.Note;
import com.helper.FactoryProvoider;


public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public UpdateServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
        String content = request.getParameter("content");
        int notId = Integer.parseInt(request.getParameter("notId").trim());
        Session session = FactoryProvoider.getFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Note note = session.get(Note.class,notId);
        note.setTitle(title);
        note.setContant(content);
        note.setAddedDate(new Date());
        transaction.commit();
        session.close();
        response.sendRedirect("all_notes.jsp");
        
        
	}

}
