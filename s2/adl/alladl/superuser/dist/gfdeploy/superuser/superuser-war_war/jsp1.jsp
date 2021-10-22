<%-- 
    Document   : jsp
    Created on : May 26, 2021, 6:53:02 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <title> Bootstrap 4 Form Validation with Validator.js Example | positronx.io</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet"></link>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/1000hz-bootstrap-validator/0.11.9/validator.min.js"></script>

        <style>
        body {
            background: #EECDA3;
            background: -webkit-linear-gradient(to top, #EF629F, #EECDA3);
            background: linear-gradient(to top, #EF629F, #EECDA3);
        }

        .container {
            max-width: 550px;
        }

        .has-error label,
        .has-error input,
        .has-error textarea {
            color: red;
            border-color: red;
        }

        .list-unstyled li {
            font-size: 13px;
            padding: 4px 0 0;
            color: red;
        }
    </style>

    
    
    </head>
     <body>
         
       <div class="container mt-5">
        <div class="card">
            <h5 class="card-header text-center">Bootstrap 4 Form Validation Demo</h5>
            <div class="card-body">

        <form method="POST" action="Servlet1" role="form">
               <div class="form-group">
      
                    <div class="form-group">
                        <label>ID</label>
                        <input type="text" class="form-control" id="id" name="id" placeholder="Username">
                    </div> 
                   
                    <div class="form-group">
                        <label>firstName</label>
                        <input type="text" class="form-control" id="firstName" name="firstName" placeholder="Name">
                    </div>

                     <div class="form-group">
                        <label>lastName</label>
                        <input type="text" class="form-control" id="lastName" name="lastName" placeholder="Name">
                    </div>
                     <div class="form-group">
                        <label>Average </label>
                        <input type="text" class="form-control" id="average" name="average" placeholder="Name">
                    </div>
   
    

            <div class="form-group">
                <button type="submit" class="btn btn-primary btn-block">Send</button>
            </div>
        </form>
            </div>
        </div>
    </div>
</body>
</html>
