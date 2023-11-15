<%-- 
    Document   : register_staff_processing
    Created on : Nov 14, 2023, 11:58:29 PM
    Author     : Miko Santos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Staff Processing</title>
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
        <form action = "index.html">
        <jsp:useBean id = "s" class="diningmanagement.staff" scope="session"/>
        <% //Register the values from register_staff.html
            String v_lastname = request.getParameter("lastname");
            String v_middlename = request.getParameter("middlename");
            String v_firstname = request.getParameter("firstname");
            String v_mobile_no = request.getParameter("mobile_no");
            String v_email_add = request.getParameter("email_add");
            String v_salary = request.getParameter("salary");
            String v_position = request.getParameter("position");
            
            s.lastname = v_lastname;
            s.middlename = v_middlename;
            s.firstname = v_firstname;
            s.mobile_no = v_mobile_no;
            s.email_add = v_email_add;
            s.salary =  Float.parseFloat(v_salary);
            s.position = v_position;
            
            int status = s.register_staff();
            if (status == 1){
        %>
                <h2>Register Staff Successful</h2>
        <%    } else{
        %>      <h2>Register Staff Failed</h2>
        <%    }    
        %>    
        <input type = "submit" value ="Return to Menu"> 
        </form>
    </body>
</html>
