package com.parcel;

import java.io.IOException;
import java.io.PrintWriter;

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

public class SaveParcel extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String noTracking = request.getParameter("noTracking");
        String parcelWeight = request.getParameter("parcelWeight");
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
            ex.printStackTrace();
        }

        double weight = Double.parseDouble(parcelWeight);
        double price = calculatePrice(weight);

        Parcel e = new Parcel();

        e.setNoTracking(noTracking);
        e.setParcelWeight(parcelWeight);
        e.setParcelPrice(String.format("%.2f", price)); // Format price with two decimal places
        e.setArrivedDate(arrivedDate);
        e.setParcelStatus(parcelStatus);
        e.setStudid(studid);

        int status = ParcelDao.save(e);

        if (status > 0) {
            out.println("<html><head><script>");
            out.println("alert('Record saved successfully!');");
            out.println("window.location.href = 'ViewParcel';");
            out.println("</script></head><body></body></html>");
        } 
        
        else {
            out.println("Sorry! Unable to saved record");
        }
        out.close();
    }

    private double calculatePrice(double weight) {
        double price = weight * 1.0;
        price = Math.round(price * 10.0) / 10.0; // Round to one decimal place
        return price;
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