<%-- 
    Document   : jsp
    Created on : May 26, 2021, 6:53:02 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            .big-parent{
                display: flex;
                justify-content: center;
                align-items: center;
            }
            .parent{
                border: 2px solid black;
                padding: 30px;
                margin-top: 90px 
            }
             .row{
                display:grid;
                grid-template-columns: 125px 400px 120px;
            }
            .fields{
                margin: 10px;
                padding: 10px;
             }
            .submitbtn{
                width: 80px;
                height: 35px;
                margin-left: 250px;
                padding: 7px;
                background: skyblue;
                border:none;
                margin-top: 30px;
            }
            .back-button{
                position: relative;
                background: red;
                width: 50px;
                height: 50px;
                border-radius: 50%;
            }
            .arrow{
                position: absolute;
                width: 15px;
                height: 2px;
                background: black;
            }
            .arrow1{
                top: 27px;
                left:16px ; 
                transform: rotate(40deg);
            }
            .arrow2{
                top: 17px;
                left:16px ; 
                transform: rotate(-40deg);
            }
        </style>
    </head>
     <body>
         
            <a href="http://localhost:27933/superuser-war">
                <div class="back-button">
                    <div class="arrow arrow1"></div>
                    <div class="arrow arrow2"></div>
                </div>
            </a>

        <form method="GET" action="ReadServ">
                <div class="big-parent">
                    <div class="parent">
                        <center> <legend>Inscription</legend>  
                            <select id="item" name="item">
                                <option value="id">id</option>
                                <option value="firstName">firstName</option>
                                <option value="lastName">lastName</option>
                                <option value="average">average</option>
                            </select>
                        </center>
                        <div class="row">
                            <div></div>  <div></div><p>Vous pouvez vous inscrire via ce formulaire.</p>
                         
                            <label class="fields" for="firstName"> input  </label>
                            <input class="fields" type="text" id="inp" name="inp" value="" size="20" maxlength="60" />
                            <input class="submitbtn" type="submit" value="Search" class="sansLabel" />

                        </div>

                    </div>
                </div>
        </form>
    </body> 
</html>
