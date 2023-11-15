<%-- 
    Document   : firing_staff_processing
    Created on : Nov 15, 2023, 1:13:22 AM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Firing Staff Processing</title>
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
            <%
                String v_staff_id = request.getParameter("staff_id");
                s.staff_id = Integer.parseInt(v_staff_id);
                int status = s.remove_staff();
                if (status == 1){
            %>
                    <h2>Fired Successful</h2>
            <%  } else{
            %>      <h2>Fired Fail</h2>
            <%  }    
            %>    
            <input type = "submit" value ="Return to Menu"> 
        </form>
    </body>
</html>
