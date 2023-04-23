/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.csit228g3.mahilum.mavenproject1;

import java.sql.*;


/**
 *
 * @author karin
 */
public class Dbhelper {
   
    private Connection conn;
  
    public Dbhelper(){
        getConnection();
    }
   
    public void getConnection(){
         try{
             conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "");
         }catch (SQLException e) {
      System.out.println("Error: " + e.getMessage());
        }
    }
    
    //Get records from database
    public ResultSet getEmployees() throws SQLException{
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM tbldb");
        return rs;
    }
    
    //Create new records
    public int addEmployees(int sid, String name, int age, double salary) throws SQLException{
        String sql = "INSERT INTO tbldb (sid, name, age, salary) VALUES (" + sid + ",'" + name + "'," + age + "," + salary + ")";
        Statement stmt = conn.createStatement();
        return stmt.executeUpdate(sql);
    }
    
    //Delete records
    public int eraseEmployee(int sid) {
        try{
            String sql = "DELETE from tbldb WHERE sid = "+ sid;
            Statement stmt = conn.createStatement();
            return stmt.executeUpdate(sql);
        } catch(SQLException e) {
            System.out.println("Not deleted " + e.getMessage());
        }
        return 0;
    }
}
