<%-- 
    Document   : manage_staff_processing
    Created on : Nov 15, 2023, 1:55:50 AM
    Author     : Miko Santos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage Staff Processing</title>
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
        <% // receive the values from manage_staff.html
        String v_staff_id = request.getParameter("staff_id");
        if (v_staff_id != null && !v_staff_id.isEmpty()) {
            A.staff_id = Integer.parseInt(v_staff_id);
          
            if (A.check_employee()) { 
        %>
                <form action="register_staff.html">
                    <input type="submit" value="Register Staff">
                </form>
                
                <form action="firing_staff.html">
                    <input type="submit" value="Fire Staff">
                </form>
        <%  } else { 
        %>
            <h1>Not Authorized to Access</h1>
        <%  }
        } else {
    %>
        <h1>Invalid Staff ID</h1>
    <% } 
    %>  
    </body>
</html>
