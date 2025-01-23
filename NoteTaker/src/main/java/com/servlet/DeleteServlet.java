package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.enties.Note;
import com.helper.FactoryProvoider;

/**
 * Servlet implementation class DeleteServlet
 */
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public DeleteServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
		    // Parse the note_id from the request
		    int parseInt = Integer.parseInt(request.getParameter("note_id"));
		    
		    // Open a Hibernate session
		    Session session = FactoryProvoider.getFactory().openSession();
		    Transaction transaction = null;
		    
		    try {
		        // Begin transaction
		        transaction = session.beginTransaction();
		        
		        // Fetch the note using the provided ID
		        Note note = session.get(Note.class, parseInt);
		        
		        if (note != null) {
		            // Delete the note if it exists
		            session.delete(note);
		            transaction.commit();
		        } else {
		            // If note not found, throw a custom exception
		            throw new Exception("Note with ID " + parseInt + " not found.");
		        }
		    } catch (Exception e) {
		        if (transaction != null) {
		            transaction.rollback(); // Rollback in case of an error
		        }
		        e.printStackTrace(); // Log the error for debugging
		        request.setAttribute("errorMessage", "Error deleting the note: " + e.getMessage());
		    } finally {
		        session.close(); // Ensure session is closed
		    }
		    
		    // Redirect to the all_notes.jsp page
		    response.sendRedirect("all_notes.jsp");
		} catch (NumberFormatException e) {
		    e.printStackTrace(); // Log the error
		    response.getWriter().println("Invalid note ID.");
		}

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
