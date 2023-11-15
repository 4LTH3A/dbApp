/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package diningmanagement;
/**
 *
 * @author Reina Althea
 */

import java.util.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ingredients {
    
    public int      ingredient_id;
    public String   ingredient_name;
    public String   ingredient_description;
    public int      quantity;
    
    public ArrayList<Integer>   ingredient_idlist = new ArrayList<>();
    public ArrayList<String>    ingredient_namelist = new ArrayList<>();
    public ArrayList<String>    ingredient_descriptionlist = new ArrayList<>();
    public ArrayList<Integer>   quantitylist = new ArrayList<>();
    
    public ingredients () {}
    
    public boolean add_ingredients () {
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dining_db", "root", "1524");
            System.out.println("Connection Successfull");
            //message = "Connection Successfull";
            
            //2. Prepare SQL statement
            PreparedStatement pstmt = conn.prepareStatement("SELECT MAX(ingredient_id) + 1 AS new_id FROM ingredient"); //to get a new meal_id
            ResultSet rst = pstmt.executeQuery();
           
            while(rst.next()) {
                ingredient_id = rst.getInt("new_id");
            }
            
            pstmt = conn.prepareStatement("INSERT INTO ingredient (ingredient_id, ingredient_name, ingredient_description, quantity) VALUES (?, ?, ?, ?)");
            pstmt.setInt(1, ingredient_id);
            pstmt.setString(2, ingredient_name);
            pstmt.setString(3, ingredient_description);
            pstmt.setInt(4, quantity);
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
    
    public void clearList(){
        ingredient_idlist.clear();
        ingredient_namelist.clear();
        ingredient_descriptionlist.clear();
        quantitylist.clear();
    }
    
    public boolean view_ingredients () { 
        clearList();
         try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dining_db", "root", "1524");
            System.out.println("Connection Successfull");
            //message = "Connection Successfull";
            
            //2. Prepare SQL statement
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM ingredient"); //select all ingredients
            ResultSet rst = pstmt.executeQuery();
           
            while(rst.next()) {
                ingredient_idlist.add(rst.getInt("ingredient_id"));
                ingredient_namelist.add(rst.getString("ingredient_name"));
                ingredient_descriptionlist.add(rst.getString("ingredient_description"));
                quantitylist.add(rst.getInt("quantity"));
                
                //debugging
                System.out.println("Ingredient ID: " + rst.getInt("ingredient_id"));
                System.out.println("Ingredient Name: " + rst.getString("ingredient_name"));
                System.out.println("Ingredient Description: " + rst.getString("ingredient_description"));
                System.out.println("Ingredient Quantity: " + rst.getInt("quantity"));

            }
            
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
        ingredients i = new ingredients();
//        
//        i.ingredient_name = "Magic potato";
//        i.ingredient_description = "1000g";
//        i.quantity = 100;
//        
//        System.out.println(i.add_ingredients());

        i.view_ingredients();
    }
}
