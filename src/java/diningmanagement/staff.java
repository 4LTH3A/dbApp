/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package diningmanagement;

/**
 *
 * @author Miko Santos
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;
import java.sql.*;

public class staff {
    public int staff_id;
    public String lastname;
    public String middlename;
    public String firstname;
    public String  mobile_no;
    public String email_add;
    public float salary;
    public String position;
    
    public ArrayList<Integer> staff_idList =  new ArrayList<>();
    public ArrayList<String> lastnameList =  new ArrayList<>();
    public ArrayList<String> middlenameList =  new ArrayList<>();
    public ArrayList<String> firstnameList =  new ArrayList<>();
    public ArrayList<String > mobile_noList =  new ArrayList<>();
    public ArrayList<String> email_addList =  new ArrayList<>();
    public ArrayList<Float> salaryList =  new ArrayList<>();
    public ArrayList<String> positionList =  new ArrayList<>();
    
    public staff(){
        
    }
    public int register_staff(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dining_db", "root", "1524");
            System.out.println("Connection Successfull");
            //message = "Connection Successfull";
           
            PreparedStatement pstmt = conn.prepareStatement("SELECT MAX(staff_id)+ 1 AS newID FROM staff");
            ResultSet rst = pstmt.executeQuery();
            while (rst.next()) {
                staff_id = rst.getInt("newID");
            }
            
            pstmt = conn.prepareStatement("INSERT INTO staff(staff_id, lastname, middlename, firstname, mobile_no, email_add,salary, position) VALUES (?,?,?,?,?,?,?,?)");
            pstmt.setInt(1, staff_id);
            pstmt.setString(2, lastname);
            pstmt.setString(3, middlename);
            pstmt.setString(4, firstname);
            pstmt.setString(5, mobile_no);
            pstmt.setString(6, email_add);
            pstmt.setFloat(7, salary);
            pstmt.setString(8, position);
          
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
            return 1;
        } catch(ClassNotFoundException | SQLException e){
            System.out.println(e.getMessage());
            return 0;
        }
    }
    public int remove_staff() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            int rowsAffected;
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dining_db", "root", "1524")) {
                System.out.println("Connection Successfull");
                PreparedStatement pstmt = conn.prepareStatement("DELETE FROM staff WHERE staff_id = ?");
                pstmt.setInt(1, staff_id);
                rowsAffected = pstmt.executeUpdate();
                pstmt.close();
            }

            if (rowsAffected > 0) {
                System.out.println("Staff member removed successfully.");
                return 1;
            } else {
                System.out.println("No staff member found with the given ID.");
                return 0;
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }
    
    public static void main(String[] args){
        /**
         * staff s = new staff();
         * s.firstname = "Miko";
         * s.middlename = "Lumintac";
         * s.lastname = "Santos";
         * s.mobile_no = "63956789123";
         * s.salary = (float) 15000.0000;
         * s.position = "Server";
         * s.register_staff();
         * 
         * s.remove_staff(3006);
        */
    }
    
}
