<%-- 
    Document   : jsp1
    Created on : May 20, 2021, 6:21:40 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form method="POST" action="Servlet">
            <fieldset>
                <legend>Inscription</legend>
                <p>Vous pouvez vous inscrire via ce formulaire.</p>
                <label for="Id">Id  </label>
                <input type="text" id="Id" name="Id" value="" size="20" maxlength="60" />
                <br />                 
                <br />
                <label for="firstName">Nom </label>
                <input type="text" id="firstName" name="firstName" value="" size="20" maxlength="30" />
                <br />               
                <br />
                <label for="lastName">Prenom </label>
                <input type="text" id="lastName" name="lastName" value="" size="20" maxlength="30" />
                <br />                
                <br />
                <label for="average">note </label>
                <input type="text" id="average" name="average" value="" size="20" maxlength="20" />
                <br />                
                <br />
                 <input type="submit" value="Ajouté" class="sansLabel" />
                <br />
    </body>

</html>
