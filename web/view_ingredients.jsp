<%-- 
    Document   : view_ingredients
    Created on : 15 Nov 2023, 12:59:48 pm
    Author     : Reina Althea
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*, diningmanagement.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Ingredients</title>
        <style>
            body {
                display: flex;
                align-items: center;
                justify-content: center;
                height: 70vh;
                margin: 0;
            }

            form {
                text-align: center; /* Optional: Align form content to center within the form */
            }
        </style>
    </head>
    <body>
        <form action="index.html">
            <h1>View Ingredients</h1>
            <jsp:useBean id="I" class="diningmanagement.ingredients" scope="session"/>
            <table border="1">
                <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Description</th>
                <th>Quantity</th>
                </tr>
                <%  I.view_ingredients();
                    for(int i = 0; i < I.ingredient_idlist.size(); i++ ) { %>
                    <tr>
                        <td><%= I.ingredient_idlist.get(i) %></td>
                        <td><%= I.ingredient_namelist.get(i) %></td>
                        <td><%= I.ingredient_descriptionlist.get(i) %></td>
                        <td><%= I.quantitylist.get(i) %></td>
                    </tr>
                <% } %> 
            </table>
            <br><input type="submit" value="Return to Menu">
        </form>
    </body>
</html>
