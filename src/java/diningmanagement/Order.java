/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package diningmanagement;
/**
 *
 * @author YES
 */

import java.util.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Order {
    public int transaction_id;
    public int customer_id;
    public String order_status;

    public ArrayList<Integer> transaction_idList = new ArrayList<>();
    public ArrayList<Integer> customer_idList = new ArrayList<>();
    public ArrayList<String> order_statusList = new ArrayList<>();

    public Order() {}

    public void clearLists() {
        transaction_idList.clear();
        customer_idList.clear();
        order_statusList.clear();
    }

    public boolean viewOrders() {
        clearLists();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dining_db", "root", "1524");
            System.out.println("Connection Successful");

            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM order_transaction");
            ResultSet rst = pstmt.executeQuery();

            while (rst.next()) {
                transaction_idList.add(rst.getInt("transaction_id"));
                customer_idList.add(rst.getInt("customer_id"));
                order_statusList.add(rst.getString("order_status"));
                
                //debugging
                System.out.println(rst.getInt("transaction_id"));
                System.out.println(rst.getInt("customer_id"));
                System.out.println(rst.getString("order_status"));
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

    public boolean insertOrder() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dining_db", "root", "1524");
            System.out.println("Connection Successful");

            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO order_transaction (transaction_id, customer_id, order_status) VALUES (?, ?, ?)");
            pstmt.setInt(1, transaction_id);
            pstmt.setInt(2, customer_id);
            pstmt.setString(3, order_status);
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

    public static void main(String[] args) {
        Order order = new Order();

        /* Adding sample data for order_transaction table
        order.transaction_id = 2001;
        order.customer_id = 1001;
        order.order_status = "Pending";
        order.insertOrder();

        order.transaction_id = 2002;
        order.customer_id = 1002;
        order.order_status = "Pending";
        order.insertOrder();

        order.transaction_id = 2003;
        order.customer_id = 1003;
        order.order_status = "Pending";
        order.insertOrder();

        order.transaction_id = 2004;
        order.customer_id = 1004;
        order.order_status = "Pending";
        order.insertOrder();
        */
        // Displaying the orders
        //order.viewOrders();

    }
}
