<%-- 
    Document   : add_ingredient_processing
    Created on : 14 Nov 2023, 9:54:17 pm
    Author     : Rhazelle Joy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*, diningmanagement.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Meal Processing</title>
        <style>
            body {
                display: flex;
                flex-direction: column;
                align-items: center;
                justify-content: center;
                height: 50vh;
                margin: 0;
            }

            h1, form {
                margin-bottom: 20px;
            }
            
            form input[type="submit"] {
                padding: 10px 10px; /* Adjust the values as needed */
                font-size: 15px;   /* Adjust the font size as needed */
            }
            
            form {
                text-align: center;
            }
        </style>
    </head>
    <body>
        <h1>ADD MEAL</h1>
        <form action="index.html">
            <jsp:useBean id="I" class="diningmanagement.ingredients" scope="session"/>
            <% //get info from add_ingredient.html
                String v_ingredient_name = request.getParameter("ingredient_name");
                String v_ingredient_description = request.getParameter("ingredient_description");
                String v_quantity = request.getParameter("quantity");
                
                I.ingredient_name = v_ingredient_name;
                I.ingredient_description = v_ingredient_description;
                I.quantity = Integer.parseInt(v_quantity);

                if(I.add_ingredients()) {
            %>
                <h2>Adding of Ingredient Successful!</h2>
            <% } else { %>
                <h2>Adding of Ingredient Failed!</h2>
            <% } 
            %>
            <input type="submit" value="Return to Menu">
        </form>
    </body>
</html>
