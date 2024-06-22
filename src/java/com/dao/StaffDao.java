package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

import com.model.Staff;
import com.util.DBConnection;

public class StaffDao {

    private Connection connection;

    public StaffDao() throws ClassNotFoundException {
        connection = DBConnection.getConnection();
    }

       public void addStaff(Staff staff) {
        try {           
            PreparedStatement ps = connection.prepareStatement("INSERT INTO staff (staffid, name, email, phoneno, password) VALUES (?,?,?,?,?)");
            //Parameters start with 1
            ps.setString(1, staff.getStaffid());
            ps.setString(2, staff.getName());
            ps.setString(3, staff.getEmail());
            ps.setString(4, staff.getPhoneno());
            ps.setString(5, staff.getPassword());
            
            ps.executeUpdate(); 
        } 
        
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteStaff(String staffid) {
        try {          
            PreparedStatement ps = connection.prepareStatement("DELETE FROM staff WHERE staffid=?");
            ps.setString(1, staffid);
            ps.executeUpdate();   
        } 
        
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateStaff(Staff staff) {
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE staff SET name=?, email=?, phoneno=?, password=? WHERE staffid=?");
            // Parameters start with 1
               ps.setString(1, staff.getName());
               ps.setString(2, staff.getEmail());
               ps.setString(3, staff.getPhoneno());
               ps.setString(4, staff.getPassword());
               ps.setString(5, staff.getStaffid());
               
               ps.executeUpdate();  
        } 
        
        catch (SQLException e) {
            e.printStackTrace();          
        }
    }

    public List <Staff> getAllStaffs() {
        List <Staff> staffs = new ArrayList <Staff>();
        try {          
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM staff");
            
            while (rs.next()) {            
                Staff staff = new Staff();
                
                staff.setStaffid(rs.getString("staffid"));
                staff.setName(rs.getString("name"));
                staff.setEmail(rs.getString("email"));
                staff.setPhoneno(rs.getString("phoneno"));
                staff.setPassword(rs.getString("password"));
                
                staffs.add(staff);           
            }
        } 
        
        catch (SQLException e) {   
            e.printStackTrace();        
        }
        return staffs;
    }

    public Staff getStaffById(String staffid) {    
        Staff staff = new Staff();
        
        try { 
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM staff WHERE staffid=? ");
            ps.setString(1, staffid);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {   
                staff.setStaffid(rs.getString("staffid"));
                staff.setName(rs.getString("name"));
                staff.setEmail(rs.getString("email"));
                staff.setPhoneno(rs.getString("phoneno"));
                staff.setPassword(rs.getString("password"));              
            }
        } 
        
        catch (SQLException e) {  
            e.printStackTrace();
        }
        return staff;
    }
}