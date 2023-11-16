<%-- 
    Document   : manage_ingredients.html
    Created on : 14 Nov 2023, 9:29:44 pm
    Author     : Rhazelle Joy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*, diningmanagement.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Staff Login</title>
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
        <h1>Staff Login!</h1>
        <jsp:useBean id="A" class="diningmanagement.employee_login" scope="session"/>
        <% // receive the values from manage_meal.html
        String v_staff_id = request.getParameter("staff_id");
        if (v_staff_id != null && !v_staff_id.isEmpty()) {
            A.staff_id = Integer.parseInt(v_staff_id);
            //debugging
//            out.println("Staff ID: " + A.staff_id);
//            out.println("manager ID: " + A.manager_id);
//            out.println("mesasge: " + A.message);
//            out.println("Status: " + A.check_employee());
            
            if (A.check_employee()) { 
        %>
                <form action="add_ingredient.html">
                    <br><input type="submit" value="Add Ingredients">
                </form>
                
                <form action="update_meal_ingredients.html">
                    <br><input type="submit" value="Update Meal Ingredients">
                </form>
                
                <form action="view_ingredients.jsp">
                    <br><input type="submit" value="View Ingredients">
                </form>
                
                <form action="view_meal_ingredients.jsp">
                    <br><input type="submit" value="View Meal Ingredients">
                </form>
                
                <form action="index.html">
                    <br><input type="submit" value="Return to Menu">
                </form>
        <%  } else { 
        %>
            <h1>Not Authorized to Access</h1>
        <%  }
        } else {
    %>
        <h1>Invalid Staff ID</h1>
    <% } %>   
    </body>
</html>
