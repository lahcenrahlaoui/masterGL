<%-- 
    Document   : jsp1
    Created on : May 25, 2021, 11:41:40 PM
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
            <fieldset>
                <legend>Inscription</legend>
                <p>Vous pouvez vous inscrire via ce formulaire.</p>
                <label for="Id">  Id  </label>
                <input type="text" id="Id" name="Id" value="" size="20" maxlength="60" />                
                <a href="Servlet"><input type="submit" value="Ajouté" class="sansLabel" />
                </a>
            </fieldset>
             
    </body>
</html>
