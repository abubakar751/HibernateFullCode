<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link href="css/style.css" rel="stylesheet" />
    <title>Add Notes Form</title>
  </head>
  <body>
    <%@ include file="navbar.jsp" %>

    <div class="container mt-5">
      <!-- Responsive Title -->
      <h1 class="text-center mb-4">Please fill your notes details</h1>

      <!-- Responsive Form -->
      <form action="SaveNotServlet" method="post" class="row g-3 p-4 shadow-lg rounded bg-light">
        <div class="col-12">
          <label for="title" class="form-label">Note Title</label>
          <input type="text" class="form-control" id="title" name="title" placeholder="Enter Here" required>
        </div>
        <div class="col-12">
          <label for="content" class="form-label">Note Content</label>
          <textarea id="content" name="content" placeholder="Enter Your Content Here" class="form-control" style="height: 300px" required></textarea>
        </div>
        <div class="col-12 d-grid">
          <button type="submit" class="btn btn-primary">Add</button>
        </div>
      </form>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
  </body>
</html>
