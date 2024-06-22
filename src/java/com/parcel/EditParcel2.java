package com.parcel;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Group 9
 */

public class EditParcel2 extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String noTracking = request.getParameter("noTracking");
        String parcelWeight = request.getParameter("parcelWeight");
        String parcelPrice = request.getParameter("parcelPrice");
        String parcelStatus = request.getParameter("parcelStatus");
        String studid = request.getParameter("studid");
        
        String dateString = request.getParameter("arrivedDate");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date arrivedDate = null;

        try {
            java.util.Date utilDate = format.parse(dateString);
            arrivedDate = new java.sql.Date(utilDate.getTime());
        } 
        
        catch (ParseException ex) {
            out.println("Error parsing date: " + ex.getMessage());
            return;
        }

        Parcel e = new Parcel();

        e.setNoTracking(noTracking);
        e.setParcelWeight(parcelWeight);
        e.setParcelPrice(parcelPrice);
        e.setArrivedDate(arrivedDate);
        e.setParcelStatus(parcelStatus);
        e.setStudid(studid);
        
        int status = ParcelDao.update(e);

        if (status > 0) {
            out.println("<html><head><script>");
            out.println("alert('Record updated successfully!');");
            out.println("window.location.href = 'ViewParcel';");
            out.println("</script></head><body></body></html>");
        } 
        
        else {
            out.println("Sorry! Unable to update record");
        }
        out.close();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}