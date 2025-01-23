<%@page import="org.hibernate.query.Query"%>
<%@page import="org.hibernate.Session"%>
<%@page import="com.enties.Note"%>
<%@page import="java.util.List"%>
<%@page import="com.helper.FactoryProvoider"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@page import="javax.servlet.http.HttpServletResponse"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>All Notes</title>

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Font Awesome for Icons -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css"
	rel="stylesheet">
<link href="css/style.css" rel="stylesheet" />
<style>
/* Custom Styles for Notes Cards */
.card-note {
	background-color: #f9f9f9;
	border-radius: 15px;
	box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
	margin-bottom: 20px;
	transition: transform 0.3s ease;
}

.card-note:hover {
	transform: translateY(-10px);
	box-shadow: 0 8px 12px rgba(0, 0, 0, 0.2);
}

/* Card Body Styling */
.card-body {
	padding: 20px;
}

/* Title Style */
.card-title {
	font-size: 20px;
	font-weight: bold;
	color: #333;
	margin-bottom: 10px;
}

/* Text Content Style */
.card-text {
	font-size: 16px;
	color: #555;
	margin-bottom: 15px;
}

/* Added Date Style */
.added-date {
	font-size: 14px;
	color: #888;
}

/* Delete Button Styling */
.delete-btn {
	background-color: #dc3545;
	color: white;
	border: none;
	padding: 8px 16px;
	border-radius: 5px;
	font-size: 14px;
	transition: background-color 0.3s;
}

.delete-btn:hover {
	background-color: #c82333;
	cursor: pointer;
}

/* Icon inside the delete button */
.delete-btn i {
	margin-right: 5px;
}
</style>
</head>
<body>
	<%@ include file="navbar.jsp"%>

	<div class="container mt-4">
		<h1 class="text-uppercase text-center mb-4">All Notes</h1>

		<% 
        // Delete the note if the delete button was clicked
        String noteIdStr = request.getParameter("noteId");
        if (noteIdStr != null) {
            try {
                int noteId = Integer.parseInt(noteIdStr);
                Session session2 = FactoryProvoider.getFactory().openSession();
                session2.beginTransaction();

                // Fetching the note object based on the ID
                Note noteToDelete = session2.get(Note.class, noteId);
                if (noteToDelete != null) {
                    session2.delete(noteToDelete);
                    session2.getTransaction().commit();
                }
                session2.close();

                // Redirecting to refresh the page
                response.sendRedirect("allNotes.jsp");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // Fetching Notes from Database using Hibernate
        Session session2 = FactoryProvoider.getFactory().openSession();
        
        try {
            Query q = session2.createQuery("from Note");
            List<Note> list = q.list(); 
            
            // Displaying the notes in Bootstrap cards
            if (list != null && !list.isEmpty()) {
        %>

		<div class="row">
			<% 
            // Looping through the list and displaying each note in a Bootstrap card
            for (Note note : list) {
        %>
			<div class="col-12 mb-3">
				<div class="card-note">
					<div class="card-body">
						<h5 class="card-title"><%= note.getTitle() %></h5>
						
						<p class="card-text"><%= note.getContant() %></p>
						<p class="added-date" style="color: #3f51b5; font-weight: 600;">
    Added on: <%= note.getAddedDate() %>
</p>

</p>
						

						<!-- Delete Button with Font Awesome Trash Icon -->

						<a href="DeleteServlet?note_id=<%= note.getId() %>"
							class="btn btn-danger">Delete</a> <a
							href="update.jsp?note_id=<%= note.getId() %>"
							class="btn btn-primary">update</a>

					</div>
				</div>
			</div>
			<% 
            }
            %>
		</div>

		<% 
            } else {
        %>
		<p class="alert alert-warning">No notes available.</p>
		<% 
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session2.close();
        }
        %>
	</div>

	<!-- Bootstrap JS -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
