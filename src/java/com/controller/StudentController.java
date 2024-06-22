package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import java.text.ParseException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.StudentDao;
import com.model.Student;

public class StudentController extends HttpServlet {

    private static String ADD = "/addStudent.jsp";
    private static String INSERT = "/registerStudent.jsp";
    private static String EDIT = "/editStudent.jsp";
    private static String LIST_STUDENT = "/listStudent.jsp";
    private static String LOGIN = "/loginStudent.jsp";
    
    private StudentDao dao;

    public StudentController() throws ClassNotFoundException {
        super();
        dao = new StudentDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String forward = "";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("deleteStudent")) {
            String studid = request.getParameter("studid");
            dao.deleteStudent(studid);
            forward = LIST_STUDENT;
            request.setAttribute("students", dao.getAllStudents());
        } 
        
        else if (action.equalsIgnoreCase("editStudent")) {
            forward = EDIT;
            String studid = request.getParameter("studid");
            Student student = dao.getStudentById(studid);
            request.setAttribute("student", student);
        } 
        
        else if (action.equalsIgnoreCase("listStudent")) {
            forward = LIST_STUDENT;
            request.setAttribute("students", dao.getAllStudents());
        } 
        
        else if (action.equalsIgnoreCase("insertStudent")) {
            forward = INSERT;
        } 
        
        else if (action.equalsIgnoreCase("addStudent")) {
            forward = ADD;
        }
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        String forward = "";
        Student student = new Student();
        
        student.setStudid(request.getParameter("studid"));
        student.setName(request.getParameter("name"));
        student.setEmail(request.getParameter("email"));
        student.setPhoneno(request.getParameter("phoneno"));
        student.setPassword(request.getParameter("password"));

        if (action.equalsIgnoreCase("editStudent")) {
            dao.updateStudent(student);
            forward = EDIT; // Set the forward URL to the same editStudent.jsp page    
        } 
        
        else if (action.equalsIgnoreCase("insertStudent")) {
            dao.addStudent(student);
            forward = LOGIN; 
        } 
        
        else if (action.equalsIgnoreCase("addStudent")) {
            dao.addStudent(student);
            forward = LIST_STUDENT;
        }
        RequestDispatcher view = request.getRequestDispatcher(forward);
        request.setAttribute("students", dao.getAllStudents());
        view.forward(request, response);
    }
}