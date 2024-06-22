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

import com.dao.StaffDao;
import com.model.Staff;

public class StaffController extends HttpServlet {

    private static String ADD = "/addStaff.jsp";
    private static String EDIT = "/editStaff.jsp";
    private static String LIST_STAFF = "/listStaff.jsp";
    
    private StaffDao dao;

    public StaffController() throws ClassNotFoundException {
        super();
        dao = new StaffDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String forward = "";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("deleteStaff")) {
            String staffid = request.getParameter("staffid");
            dao.deleteStaff(staffid);
            forward = LIST_STAFF;
            request.setAttribute("staffs", dao.getAllStaffs());
        } 
        
        else if (action.equalsIgnoreCase("editStaff")) {
            forward = EDIT;
            String staffid = request.getParameter("staffid");
            Staff staff = dao.getStaffById(staffid);
            request.setAttribute("staff", staff);
        } 
        
        else if (action.equalsIgnoreCase("listStaff")) {
            forward = LIST_STAFF;
            request.setAttribute("staffs", dao.getAllStaffs());
        } 
        
        else if (action.equalsIgnoreCase("addStaff")) {
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
        Staff staff = new Staff();
        
        staff.setStaffid(request.getParameter("staffid"));
        staff.setName(request.getParameter("name"));
        staff.setEmail(request.getParameter("email"));
        staff.setPhoneno(request.getParameter("phoneno"));
        staff.setPassword(request.getParameter("password"));

        if (action.equalsIgnoreCase("editStaff")) {
            dao.updateStaff(staff);
            forward = EDIT; // Set the forward URL to the same editStudent.jsp page
        } 
        
        else if (action.equalsIgnoreCase("addStaff")) {
            dao.addStaff(staff);
            forward = LIST_STAFF;
        }
        RequestDispatcher viewStaff = request.getRequestDispatcher(forward);
        request.setAttribute("staffs", dao.getAllStaffs());
        viewStaff.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}