package com.dao;

import com.model.Student;
import com.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

import com.model.Admin;
import com.util.DBConnection;

public class AdminDao {

    private Connection connection;

    public AdminDao() throws ClassNotFoundException {
        connection = DBConnection.getConnection();
    }

    public void addAdmin(Admin admin) {
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO admin (adminid, name, email, phoneno, password) VALUES (?,?,?,?,?)");
            //Parameters start with 1
            ps.setString(1, admin.getAdminid());
            ps.setString(2, admin.getName());
            ps.setString(3, admin.getEmail());
            ps.setString(4, admin.getPhoneno());
            ps.setString(5, admin.getPassword());
            
            ps.executeUpdate();
        } 
        
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAdmin(String adminid) {
        try {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM admin WHERE adminid=?");
            ps.setString(1, adminid);
            ps.executeUpdate();
        } 
        
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateAdmin(Admin admin) {
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE admin SET name=?, email=?, phoneno=?, password=? WHERE adminid=?");
            // Parameters start with 1
            ps.setString(1, admin.getName());
            ps.setString(2, admin.getEmail());
            ps.setString(3, admin.getPhoneno());
            ps.setString(4, admin.getPassword());
            ps.setString(5, admin.getAdminid());
            
            ps.executeUpdate();
        } 
        
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List <Admin> getAllAdmins() {
        List <Admin> admins = new ArrayList <Admin>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM admin");

            while (rs.next()) {
                Admin admin = new Admin();
                
                admin.setAdminid(rs.getString("adminid"));
                admin.setName(rs.getString("name"));
                admin.setEmail(rs.getString("email"));
                admin.setPhoneno(rs.getString("phoneno"));
                admin.setPassword(rs.getString("password"));
                
                admins.add(admin);
            }
        } 
        
        catch (SQLException e) {
            e.printStackTrace();
        }
        return admins;
    }

    public Admin getAdminById(String adminid) {

        Admin admin = new Admin();

        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM admin WHERE adminid=? ");
            ps.setString(1, adminid);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                admin.setAdminid(rs.getString("adminid"));
                admin.setName(rs.getString("name"));
                admin.setEmail(rs.getString("email"));
                admin.setPhoneno(rs.getString("phoneno"));
                admin.setPassword(rs.getString("password"));
            }
        } 
        
        catch (SQLException e) {
            e.printStackTrace();
        }
        return admin;
    }
}