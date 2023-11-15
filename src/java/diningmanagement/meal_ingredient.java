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

public class meal_ingredient {
    public int      meal_ingredient_id;
    public int      ingredient_id;
    public int      meal_id;
    public int      quantity_used;
    
    public ArrayList<Integer>   meal_ingredient_idlist = new ArrayList<>();
    public ArrayList<Integer>   ingredient_idlist = new ArrayList<>();
    public ArrayList<String>    ingredient_namelist = new ArrayList<>();
    public ArrayList<Integer>   meal_idlist = new ArrayList<>();
    public ArrayList<String>    meal_namelist = new ArrayList<>();
    public ArrayList<Integer>   quantity_usedlist = new ArrayList<>();
    
    public meal_ingredient() {}
    
    public void clearList(){
        meal_ingredient_idlist.clear();
        ingredient_idlist.clear();
        meal_idlist.clear();
        quantity_usedlist.clear();
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
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM meal_ingredient"); //select all ingredients
            ResultSet rst = pstmt.executeQuery();
           
            while(rst.next()) {
                meal_ingredient_idlist.add(rst.getInt("meal_ingredient_id"));
                ingredient_idlist.add(rst.getInt("ingredient_id"));
                meal_idlist.add(rst.getInt("meal_id"));
                quantity_usedlist.add(rst.getInt("quantityUsed"));
                
                //debugging
//                System.out.println("Ingredient ID: " + rst.getInt("meal_ingredient_id"));
//                System.out.println("Ingredient Name: " + rst.getInt("ingredient_id"));
//                System.out.println("Ingredient Description: " + rst.getInt("meal_id"));
//                System.out.println("Ingredient Quantity: " + rst.getInt("quantityUsed"));
            }
            
            for(int i = 0; i < ingredient_idlist.size(); i++) {
                pstmt = conn.prepareStatement("SELECT ingredient_name FROM ingredient WHERE ingredient_id = ?"); //select all ingredients
                pstmt.setInt(1, ingredient_idlist.get(i));
                rst = pstmt.executeQuery();
                
                while(rst.next()) {
                    ingredient_namelist.add(rst.getString("ingredient_name"));
                }
            }
            
            for(int i = 0; i < meal_idlist.size(); i++) {
                pstmt = conn.prepareStatement("SELECT meal_name FROM meal WHERE meal_id = ?"); //select all ingredients
                pstmt.setInt(1, meal_idlist.get(i));
                rst = pstmt.executeQuery();
                
                while(rst.next()) {
                    meal_namelist.add(rst.getString("meal_name"));
                }
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
        meal_ingredient mi = new meal_ingredient();
//        
//        i.ingredient_name = "Magic potato";
//        i.ingredient_description = "1000g";
//        i.quantity = 100;
//        
//        System.out.println(i.add_ingredients());

        mi.view_ingredients();
    }
}
