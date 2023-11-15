<%-- 
    Document   : delete_meal_processing
    Created on : 14 Nov 2023, 8:43:32 pm
    Author     : Rhazelle Joy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete Meal Processing</title>
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
        <h1>DELETE MEAL</h1>
        <form action="index.html">
            <jsp:useBean id="M" class="diningmanagement.meals" scope="session"/>
            <% //get info from delete_meal.html
               String v_meal_id = request.getParameter("meal_id");
               
               M.meal_id = Integer.parseInt(v_meal_id);
               
               if (M.delete_meal()) { 
                %>
                    <h2>Meal Successfully Deleted</h2>
                <%  } else { 
                %>
                    <h2>Meal Deletion Failed</h2>
                <%  } 
                %>
            <input type="submit" value="Return to Menu">
        </form>
    </body>
</html>
