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

import com.dao.AdminDao;
import com.model.Admin;

public class AdminController extends HttpServlet {

    private static String ADD = "/addAdmin.jsp";
    private static String EDIT = "/editAdmin.jsp";
    private static String LIST_ADMIN = "/listAdmin.jsp";
    
    private AdminDao dao;

    public AdminController() throws ClassNotFoundException {
        super();
        dao = new AdminDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String forward = "";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("deleteAdmin")) {
            String adminid = request.getParameter("adminid");
            dao.deleteAdmin(adminid);
            forward = LIST_ADMIN;
            request.setAttribute("admins", dao.getAllAdmins());  
        } 
        
        else if (action.equalsIgnoreCase("editAdmin")) {
            forward = EDIT;
            String adminid = request.getParameter("adminid");
            Admin admin = dao.getAdminById(adminid);
            request.setAttribute("admin", admin);
        } 
        
        else if (action.equalsIgnoreCase("listAdmin")) {
            forward = LIST_ADMIN;
            request.setAttribute("admins", dao.getAllAdmins());  
        } 
        
        else if (action.equalsIgnoreCase("addAdmin")) {
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
        Admin admin = new Admin();
        
        admin.setAdminid(request.getParameter("adminid"));
        admin.setName(request.getParameter("name"));
        admin.setEmail(request.getParameter("email"));
        admin.setPhoneno(request.getParameter("phoneno"));
        admin.setPassword(request.getParameter("password"));

        if (action.equalsIgnoreCase("editAdmin")) {
            dao.updateAdmin(admin);
            forward = EDIT; // Set the forward URL to the same editStudent.jsp page  
        } 
        
        else if (action.equalsIgnoreCase("addAdmin")) {
            dao.addAdmin(admin);
            forward = LIST_ADMIN;
        }
        RequestDispatcher view = request.getRequestDispatcher(forward);
        request.setAttribute("admins", dao.getAllAdmins());
        view.forward(request, response);
    }
}