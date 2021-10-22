 


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

 
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="css/css.css">

<style>
    select{
        margin-bottom: 50px; 
    }
</style>
</head>
<body>
    
        <div class="login-form">
            <form method="POST" action="Search" role="form">
                <h2 class="text-center">Insert</h2>  
                <form method="POST" action="Search">
                    <div class="big-parent">
                        <div class="parent">
                            <center>
                                <legend>Search</legend>  
                                <select id="item" name="item" class="dropdown">
                                    <option value="id">id</option>
                                    <option value="firstName">firstName</option>
                                    <option value="lastName">lastName</option>
                                    <option value="average">average</option> 
                                    <option value="degree">Degree</option>
                                    <option value="year">Year</option> 
                                </select>
                                <br>
                                <div class="form-group">
                                    <input type="text" id="inp" name="inp" class="form-control"  >
                                </div>
                                <br>
                                <div class="form-group">
                                    <button type="submit" class="btn btn-primary btn-block">Search</button>
                                </div>
                            </center>
                        </div>
                    </div>
                </form>
        </div> 
</body>
</html>
