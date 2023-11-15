package diningmanagement;

/**
 *
 * @author Reina Althea
 */

import java.util.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class employee_login {
    
    //public String database = "jdbc:mysql://localhost:3306/dining_db", "root", "1524";
    public int staff_id;
    public int manager_id;
    public boolean isManager;
    public int debug;
    public String message = "";
    
    public employee_login() {}
    
    public boolean check_employee() {
        isManager = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dining_db", "root", "1524");
            System.out.println("Connection Successfull");
            //message = "Connection Successfull";
            
            //2. Prepare SQL statement
            PreparedStatement pstmt = conn.prepareStatement("SELECT staff_id AS manager_id FROM staff WHERE position = ?");
            pstmt.setString(1, "Manager");
            ResultSet rst = pstmt.executeQuery();
           
            while(rst.next()) {
                manager_id = rst.getInt("manager_id");
            }

            // Check if the entered staff ID matches the specific manager's ID
            if(staff_id == manager_id) {
                isManager = true;
            }
             
            pstmt.close();
            conn.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(employee_login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            //message = e.getMessage();
        }
        return isManager;
    }
    
    public static void main (String args[]) {
        employee_login el = new employee_login();
        el.staff_id = 3005;
        System.out.println(el.check_employee());
    }
}
