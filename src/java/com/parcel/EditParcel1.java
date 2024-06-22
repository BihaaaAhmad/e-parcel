package com.parcel;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Group 9
 */

public class EditParcel1 extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String noTracking = request.getParameter("noTracking");

        Parcel e = ParcelDao.getParcelByNoTracking(noTracking);

        out.println("<html>");
            out.println("<head>");
                out.println("<link rel='icon' type='img/png' href='img/delivery.png'>");
                
                out.println("<title>Update Parcel</title>");
                
                out.println("<style>");
                    out.println("@import url('https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css');");
                    out.println("@import url('https://fonts.googleapis.com/css2?family=Quicksand:wght@300;400;500;600;700&display=swap');");
                    out.println("@import url('https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css');");

                    out.println("html{");
                        out.println("   background-image: url('background1.jpg');");
                        out.println("   max-width: 100%;");
                        out.println("   max-height: 100%;");
                        out.println("   background-size: 100%;");
                        out.println("   background-position: 50% 80%;");
                        out.println("   margin: auto;");
                        out.println("   display: block;");
                    out.println("}");

                    out.print("img {");
                        out.println("   display: block;");
                        out.println("   height: 110px;");
                        out.println("   width: 110px;");
                        out.println("   margin-left: auto;");
                        out.println("   margin-right: auto;");
                        out.println("   margin-top: 4%;");
                    out.print("}");

                    out.println("body {");
                        out.println("   padding: 0;");
                        out.println("   margin: 0;");
                        out.println("   font-family: 'Quicksand', sans-serif;");
                    out.println("}");

                    out.println("select{");
                        out.println("   text-align: center;");
                    out.println("}");

                    out.println(".center-form{");
                        out.println("   justify-content: center;");
                        out.println("   display: flex;");
                        out.println("   width: 330px;");
                        out.println("   height: 520px;");
                        out.println("   margin: auto;");
                        out.println("   margin-top:3.5%;");
                        out.println("   border-radius: 10px;");
                        out.println("   border-style: outset;");
                        out.println("   padding: 40px;");
                        out.println("   line-height: 2;");
                        out.println("   background: whitesmoke;");
                    out.println("}");

                    out.println(".center-form input[type='text'] {");
                        out.println("   font-size: 15px;");
                        out.println("   padding: 4px;");
                        out.println("   width: 100%;");
                    out.println("}");

                    out.println("input[type=submit] {");
                        out.println("   border: none");
                        out.println("   border-radius: 4px;");
                        out.println("   padding: 8px 12px;");
                        out.println("   opacity: 0.9 ;");
                        out.println("   font-size: 15px;");
                        out.println("   cursor: pointer;");
                        out.println("   width: 35%;");
                        out.println("   background-color: green;");
                        out.println("   color: white ;");
                    out.println("}");
                    
                    out.println(".btnUpdate {");
                        out.println("   border: 1px solid black;");
                        out.println("   border-radius: 5px;");
                        out.println("   padding: 8px 12px;");
                        out.println("   text-align: center;");
                        out.println("   text-decoration: none;");
                        out.println("   display: inline-block;");
                        out.println("   font-size: 13px;");
                        out.println("   background-color: #E5E4E2;");
                        out.println("    margin-top: 20px;");
                        out.println("   color: black;");
                        out.println("   position: relative;");
                        out.println("   left: 50%;");
                        out.println("   transform: translateX(-50%);");
                    out.println("}");

                    out.print("input[type=submit]:hover {");
                        out.println("   background: #4CAF50;");
                        out.println("   opacity: 1 ;");
                    out.print("}");                
                out.println("</style>");
            out.println("</head>");
        
            out.println("<body>");
                out.println("<div class='center-form'>");
                    out.print("<form action='EditParcel2' method='post'>");

                        out.print("<img class='center' src='parcel.png'>");
                            out.print("<table>");
                                out.println("<h1 style='text-align: center;'>UPDATE PARCEL</h1>");
                                //out.print("<tr><td colspan='2' style='text-align: center;'><h1>Update Parcel</h1></td></tr>");

                                out.print("<tr><td style='padding-right: 15px;'>No Tracking</td><td><input type='text' "
                                        + "id='noTracking' name='noTracking' value='" + e.getNoTracking() + "' readonly/></td></tr>");
                                out.print("<tr><td></td></tr>" + "<tr><td></td></tr>" + "<tr><td></td></tr>");

                                out.print("<tr><td style='padding-right: 15px;'>Student ID</td><td><input type='text' "
                                        + "id='studid' name='studid' value='" + e.getStudid() + "' readonly/></td></tr>");
                                out.print("<tr><td></td></tr>" + "<tr><td></td></tr>" + "<tr><td></td></tr>");

                                out.print("<tr><td style='padding-right: 15px;'>Weight (kg)</td><td><input type='text' "
                                        + "name='parcelWeight' id='parcelWeight' value='" + e.getParcelWeight() + "' oninput='calculatePrice()'/></td></tr>");
                                out.print("<tr><td></td></tr>" + "<tr><td></td></tr>" + "<tr><td></td></tr>");

                                double weight= Double.parseDouble(e.getParcelWeight());
                                out.print("<tr><td style='padding-right: 15px;'>Price (RM)</td><td><input type='text' "
                                        + "id='parcelPrice' name='parcelPrice' value='" + calculatePrice(weight) + "' readonly/></td></tr>");
                                out.print("<tr><td></td></tr>" + "<tr><td></td></tr>" + "<tr><td></td></tr>");

                                out.print("<tr><td style='padding-right: 15px;'>Date arrived</td><td><input type='date' "
                                        + "name='arrivedDate' value='" + e.getArrivedDate() + "'/></td></tr>");
                                out.print("<tr><td></td></tr>" + "<tr><td></td></tr>" + "<tr><td></td></tr>");

                                out.print("<tr><td style='padding-right: 15px;'>Status</td><td>");
                                    out.print("<select name='parcelStatus'>");
                                        out.print("<option value='Received' " + (e.getParcelStatus().equals("Received") ? "selected" : "") + ">Receive</option>");
                                        out.print("<option value='Not Received' " + (e.getParcelStatus().equals("Not Received") ? "selected" : "") + ">Not receive</option>");
                                    out.print("</select>");
                                out.print("</td></tr>");
                                out.print("<tr><td></td></tr>" + "<tr><td></td></tr>" + "<tr><td></td></tr>");

                                out.print("<tr><td colspan='2'><input class='btnUpdate' type='submit' value='Edit & Save'/></td></tr>");
                                out.print("<tr><td></td></tr>");
                            out.println("</table>");
                    out.println("</form><br>");
                out.println("</div>");
            out.println("</body>");
        out.println("</html>");

        out.close();
    }

    private double calculatePrice(double weight) {
        double price = weight * 1.0;
        price = Math.round(price * 10.0) / 10.0; // Round to one decimal place
        return price;
    }
    
    /*private double calculatePrice(String weight) {
        double weightValue = Double.parseDouble(weight);
        double price;

        if (weightValue >= 0.1 && weightValue <= 0.9) {
            price = 0.5;
        } else if (weightValue >= 1.0 && weightValue < 1.4) {
            double weightIncrement = Math.ceil((weightValue - 0.9) / 0.5);
            price = 0.5 + (weightIncrement * 0.5);
        } else {
            double weightIncrement = Math.ceil((weightValue - 1.4) / 0.5);
            price = 1.0 + (weightIncrement * 0.5);
        }

        return price;
    }*/

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