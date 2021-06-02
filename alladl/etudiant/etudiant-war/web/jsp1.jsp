<%-- 
    Document   : jsp1
    Created on : May 25, 2021, 9:42:38 PM
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
                <label for="Nom">Nom </label>
                <input type="text" id="Nom" name="Nom" value="" size="20" maxlength="20" />
                <br />               
                <br />
                <label for="Prenom">Prenom </label>
                <input type="text" id="Prenom" name="Prenom" value="" size="20" maxlength="20" />
                <br />                
                <br />
                <label for="note">note </label>
                <input type="text" id="note" name="note" value="" size="20" maxlength="20" />
                <br />                
                <br />
                 <input type="submit" value="Ajouté" class="sansLabel" />
                <br />
    </body>
</html>
