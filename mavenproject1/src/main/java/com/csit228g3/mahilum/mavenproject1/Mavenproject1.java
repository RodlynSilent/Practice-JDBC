/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.csit228g3.mahilum.mavenproject1;

/**
 *
 * @author karin
 */

import java.sql.*;

public class Mavenproject1 {

   public static void main(String[] args) {
      
      Dbhelper dbhelper = new Dbhelper();
      
      try{
          dbhelper.addEmployees(2, "Emman", 21, 40000); 
          dbhelper.eraseEmployee(2);
          ResultSet rs = dbhelper.getEmployees();
          
      
      // Print results
      while (rs.next()) {
        int sid =rs.getInt("sid");
        String name = rs.getString("name");
        int age = rs.getInt("age");
        double salary = rs.getDouble("salary");
        System.out.println("ID: " + sid + ", Name: " + name + ", Age: " + age + ", Salary: " + salary);
      }
      
      // Close resources
 
    } catch (SQLException e) {
      System.out.println("Error: " + e.getMessage());
    }
  }
}
