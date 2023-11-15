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
            <h1>View Meal Ingredients</h1>
            <jsp:useBean id="MI" class="diningmanagement.meal_ingredient" scope="session"/>
            <table border="1">
                <tr>
                <th>Meal Ingredient ID</th>
                <th>Ingredient ID</th>
                <th>Ingredient Name</th>
                <th>Meal ID</th>
                <th>Meal Name</th>
                <th>Quantity</th>
                </tr>
                <%  MI.view_ingredients();
                    for(int i = 0; i < MI.meal_ingredient_idlist.size(); i++ ) { %>
                    <tr>
                        <td><%= MI.meal_ingredient_idlist.get(i) %></td>
                        <td><%= MI.ingredient_idlist.get(i) %></td>
                        <td><%= MI.ingredient_namelist.get(i) %></td>
                        <td><%= MI.meal_idlist.get(i) %></td>
                        <td><%= MI.meal_namelist.get(i) %></td>
                        <td><%= MI.quantity_usedlist.get(i) %></td>
                    </tr>
                <% } %> 
            </table>
            <br><input type="submit" value="Return to Menu">
        </form>
    </body>
</html>
