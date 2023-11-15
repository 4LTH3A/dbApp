/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package diningmanagement;

import java.util.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Reina Althea
 */
public class meals {
    
    //variables (for single record)
    public int      meal_id;
    public String   meal_name;
    public String   meal_category;
    public float    meal_price;
    public String   meal_description;
    public String   meal_type;
    
    //list of meals (for multiple records)
    public ArrayList<Integer> meal_idlist = new ArrayList<>();
    public ArrayList<String> meal_namelist = new ArrayList<>();
    public ArrayList<String> meal_categorylist = new ArrayList<>();
    public ArrayList<Float> meal_pricelist = new ArrayList<>();
    public ArrayList<String> meal_descriptionlist = new ArrayList<>();
    public ArrayList<String> meal_typelist = new ArrayList<>();
    
    public meals () {}
    
    public boolean add_meal () {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dining_db", "root", "1524");
            System.out.println("Connection Successfull");
            //message = "Connection Successfull";
            
            //2. Prepare SQL statement
            PreparedStatement pstmt = conn.prepareStatement("SELECT MAX(meal_id) + 1 AS new_id FROM meal"); //to get a new meal_id
            ResultSet rst = pstmt.executeQuery();
           
            while(rst.next()) {
                meal_id = rst.getInt("new_id");
            }
            
            pstmt = conn.prepareStatement("INSERT INTO meal (meal_id, meal_name, meal_category, meal_price, meal_description, meal_type) VALUES (?, ?, ?, ?, ?, ?)");
            pstmt.setInt(1, meal_id);
            pstmt.setString(2, meal_name);
            pstmt.setString(3, meal_category);
            pstmt.setFloat(4, meal_price);
            pstmt.setString(5, meal_description);
            pstmt.setString(6, meal_type);
            pstmt.executeUpdate();
            
            pstmt.close();
            conn.close();
            return true;
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(employee_login.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            //message = e.getMessage();
            return false;
        }
    }
    
    public boolean delete_meal () {
        int count = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dining_db", "root", "1524");
            System.out.println("Connection Successfull");
            //message = "Connection Successfull";
            
            //2. Prepare SQL statement
            PreparedStatement pstmt = conn.prepareStatement("SELECT COUNT(*) AS count FROM meal WHERE meal_id = ?");
            pstmt.setString(1, String.valueOf(meal_id));
            ResultSet rst = pstmt.executeQuery();
            
            while(rst.next()) {
                count = rst.getInt("count");
            }
            
            if(count == 1) {
                pstmt = conn.prepareStatement("DELETE FROM meal WHERE meal_id = ?");
                pstmt.setString(1, String.valueOf(meal_id));
                pstmt.executeUpdate();
            }
            else
                return false;
           
            pstmt.close();
            conn.close();
            return true;
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(employee_login.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            //message = e.getMessage();
            return false;
        }
    }
    
    public static void main (String args[]) {
        meals M = new meals();
        
//        M.meal_name = "Coke";
//        M.meal_category = "Beverages";
//        M.meal_price = 79;
//        M.meal_description = "Cold drink for summer!";
//        M.meal_type = "Ala carte";
//        M.add_meal();

        M.meal_id = 6001;
        System.out.println(M.delete_meal());
    }
}
