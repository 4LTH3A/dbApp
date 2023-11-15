<%-- 
    Document   : add_meal_processing
    Created on : 14 Nov 2023, 6:38:58 pm
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
                font-size: 12px;   /* Adjust the font size as needed */
            }
            
            form {
                text-align: center;
            }
        </style>
    </head>
    <body>
        <h1>ADD MEAL</h1>
        <form action="index.html">
            <jsp:useBean id="M" class="diningmanagement.meals" scope="session"/>
            <% //get info from add_meal.html
                String v_meal_name = request.getParameter("meal_name");
                String v_meal_category = request.getParameter("meal_category");
                String v_meal_price = request.getParameter("meal_price");
                String v_meal_description = request.getParameter("meal_description");
                String v_meal_type = request.getParameter("meal_type");

                M.meal_name = v_meal_name;
                M.meal_category = v_meal_category;
                M.meal_price = Float.parseFloat(v_meal_price);
                M.meal_description = v_meal_category;
                M.meal_type = v_meal_type;

                if(M.add_meal()) {
            %>
                <h1>Adding of Meal Successful!</h1>
            <% } else { %>
                <h1>Adding of Meal Failed!</h1>
            <% } 
            %>
            <input type="submit" value="Return to Menu">
        </form>
    </body>
</html>
