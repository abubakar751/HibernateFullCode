<!doctype html>
<%@page import="com.enties.Note"%>
<%@page import="org.hibernate.Session"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page import="com.helper.FactoryProvoider"%>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<link href="css/style.css" rel="stylesheet" />
<title>Add Notes Form</title>
</head>
<body>
	<%@ include file="navbar.jsp"%>

	<div class="container mt-5">
		<!-- Responsive Title -->
		<h1 class="text-center mb-4">Edit Your Note</h1>
		<% 
   int noteId=Integer.parseInt(request.getParameter("note_id").trim());

    Session session2= FactoryProvoider.getFactory().openSession();
  

    // Fetching the note object based on the ID
     Note note = session2.get(Note.class,noteId);
    
    

%>

		<!-- Responsive Form -->
		<form action="UpdateServlet" method="post" class="row g-3 p-4 shadow-lg rounded bg-light">
		<input type="hidden" name="notId" value="<%= note.getId() %>">

			
			<div class="col-12">
				<label for="title" class="form-label">Note Title</label> <input
					type="text" class="form-control" id="title" name="title"
					placeholder="Enter Here" value="<%= note.getTitle() %>">
			</div>

			<div class="col-12">
    <label for="content" class="form-label">Note Content</label>
    <textarea id="content" name="content" required class="form-control" style="height: 300px;" placeholder="Enter Your Content Here">
        <%= note.getContant() %>
    </textarea>
</div>



			<div class="col-12 d-grid">
				<button type="submit" class="btn btn-primary">Update</button>
			</div>
		</form>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
</body>
</html>
