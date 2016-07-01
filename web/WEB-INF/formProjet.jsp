<%-- 
    Document   : fromProjet
    Created on : 1 juil. 2016, 16:54:21
    Author     : Okito
--%>
<%@taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <form method="post" >
            Nom <input type="text" name="nom" />
            <br/>Sujet <input type="text" name="sujet" />
            <br/>Titre <input type="text" name="titre" />
            <br/>Date de Création <input type="text" name="dateCreation" />
            <br/>Data limite <input type="text" name="dateLimite" />
            <br/><button type="submit" >Valider projet</button>
            
        </form>
    </body>
</html>
