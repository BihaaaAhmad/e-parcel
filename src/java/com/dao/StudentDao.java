package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

import com.model.Student;
import com.util.DBConnection;

public class StudentDao {

    private Connection connection;

    public StudentDao() throws ClassNotFoundException {
        connection = DBConnection.getConnection();
    }

    public void addStudent(Student student) {
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO student (studid, name, email, phoneno, password) VALUES (?, ?, ?, ?, ?)");
            //Parameters start with 1
            ps.setString(1, student.getStudid());
            ps.setString(2, student.getName());
            ps.setString(3, student.getEmail());
            ps.setString(4, student.getPhoneno());
            ps.setString(5, student.getPassword());
            
            ps.executeUpdate(); 
        } 
        
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteStudent(String studid) {
        try {  
            PreparedStatement ps = connection.prepareStatement("DELETE FROM student WHERE studid=?");
            ps.setString(1, studid);
            ps.executeUpdate(); 
        } 
        
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateStudent(Student student) {
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE student SET name=?, email=?, phoneno=?, password=? WHERE studid=?");
            // Parameters start with 1    
            ps.setString(1, student.getName());
            ps.setString(2, student.getEmail());
            ps.setString(3, student.getPhoneno());
            ps.setString(4, student.getPassword());
            ps.setString(5, student.getStudid());
            
            ps.executeUpdate();
        }
        
        catch (SQLException e) {
            e.printStackTrace();      
        }
    }

    public List <Student> getAllStudents() {
        List <Student> students = new ArrayList <Student>();
        try {      
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM student");
            
            while (rs.next()) {
                Student student = new Student();
                
                student.setStudid(rs.getString("studid"));
                student.setName(rs.getString("name"));
                student.setEmail(rs.getString("email"));
                student.setPhoneno(rs.getString("phoneno"));
                student.setPassword(rs.getString("password"));
                
                students.add(student);   
            }
        } 
        
        catch (SQLException e) {     
            e.printStackTrace();     
        }
        return students;
    }

    public Student getStudentById(String studid) {
        Student student = new Student();
        
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM student WHERE studid=? ");
            ps.setString(1, studid);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                student.setStudid(rs.getString("studid"));
                student.setName(rs.getString("name"));
                student.setEmail(rs.getString("email"));
                student.setPhoneno(rs.getString("phoneno"));
                student.setPassword(rs.getString("password")); 
            }
        } 
        
        catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }
}