/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package diningmanagement;
/**
 *
 * @author YES
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Payment {
    public int transaction_id;
    public float totalDue;
    public float cash;
    public float change;
    public int authorizing_staff_id;

    public ArrayList<Integer> transaction_idList = new ArrayList<>();
    public ArrayList<Float> totalDueList = new ArrayList<>();
    public ArrayList<Float> cashList = new ArrayList<>();
    public ArrayList<Float> changeList = new ArrayList<>();
    public ArrayList<Integer> authorizing_staff_idList = new ArrayList<>();

    public Payment() {}

    public void clearLists() {
        transaction_idList.clear();
        totalDueList.clear();
        cashList.clear();
        changeList.clear();
        authorizing_staff_idList.clear();
    }

    public boolean viewPayments() {
        clearLists();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dining_db", "root", "1524");
            System.out.println("Connection Successful");

            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM payment");
            ResultSet rst = pstmt.executeQuery();

            while (rst.next()) {
                transaction_idList.add(rst.getInt("transaction_id"));
                totalDueList.add(rst.getFloat("totalDue"));
                cashList.add(rst.getFloat("cash"));
                changeList.add(rst.getFloat("amount_change"));
                authorizing_staff_idList.add(rst.getInt("authorizing_employee_id"));
                
                //debugging
                System.out.println(rst.getInt("transaction_id"));
                System.out.println(rst.getFloat("totalDue"));
                System.out.println(rst.getFloat("cash"));
                System.out.println(rst.getFloat("amount_change"));
                System.out.println(rst.getInt("authorizing_employee_id"));
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

    public boolean insertPayment() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dining_db", "root", "1524");
            System.out.println("Connection Successful");

            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO payment (transaction_id, totalDue, cash, change, authorizing_staff_id) VALUES (?, ?, ?, ?, ?)");
            pstmt.setInt(1, transaction_id);
            pstmt.setFloat(2, totalDue);
            pstmt.setFloat(3, cash);
            pstmt.setFloat(4, change);
            pstmt.setInt(5, authorizing_staff_id);
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

    public static void main(String args[]) {
        Payment payment = new Payment();
        /*
        payment.transaction_id = 2001;
        payment.totalDue = 120;
        payment.cash = 150;
        payment.change = 30;
        payment.authorizing_staff_id = 3001;
        payment.insertPayment();
        */
        payment.viewPayments();

    }
}
