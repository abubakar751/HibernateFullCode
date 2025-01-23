<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    
    <!-- Font Awesome for icons -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet">
    
    <link href="css/style.css" rel="stylesheet" />
    <title>Note Maker - Home</title>

    <style>
        body {
            background-color: #f4f9fc;
        }

        .btn-custom {
            background-color: #5c6bc0;
            color: white;
            font-weight: bold;
        }

        .btn-custom:hover {
            background-color: #3f51b5;
            color: white;
        }

        .header-section {
            background-color: rgba(63, 81, 181, 0.8); /* Slight transparency */
            color: white;
            padding: 50px 0;
            text-align: center;
            border-radius: 5px;
            margin-bottom: 30px;
        }

        .card {
            background-color: #ffffff;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
            padding: 20px;
            margin-bottom: 20px;
        }

        .card-title {
            color: #3f51b5;
        }

        .btn-icon {
            display: flex;
            align-items: center;
            justify-content: center;
        }

        .btn-icon i {
            margin-right: 8px;
        }

        /* Add image as a background for the main section */
       
    </style>
  </head>
  <body>
    <%@ include file="navbar.jsp" %>

    <div class="container mt-5">
        <!-- Section with Image Background -->
        

        <!-- Header Section -->
        <div class="header-section">
            <h1>Welcome to Note Maker</h1>
            <p class="lead">Create, manage, and organize all your personal notes with ease!</p>
        </div>

        <!-- Action Buttons -->
        <div class="row justify-content-center mt-4">
            <div class="col-md-4 mb-4">
                <a href="add_not.jsp" class="btn btn-custom btn-lg btn-block">
                    <i class="fas fa-pencil-alt"></i> Create a New Note
                </a>
            </div>
            <div class="col-md-4 mb-4">
                <a href="all_notes.jsp" class="btn btn-custom btn-lg btn-block">
                    <i class="fas fa-list"></i> View All Notes
                </a>
            </div>
        </div>
    </div>

    <!-- Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
  </body>
</html>
