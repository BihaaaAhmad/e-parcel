package com.parcel;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Group 9
 */

public class StaffParcel extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String adminid = (String) request.getSession().getAttribute("adminid");
            String name = (String) request.getSession().getAttribute("name");

            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");

            out.println("<!DOCTYPE html>");
            out.println("<html lang=\"en\">");
                out.println("<head>");
                    out.println("<meta charset=\"UTF-8\">");
                    out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");

                    out.println("<title>Parcel List</title>");
                    
                    out.println("<link rel='icon' type='img/png' href='img/delivery.png'>");
                    out.println("<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css\" integrity=\"sha512-NhSC1YmyruXifcj/KFRWoC561YpHpc5Jtzgvbuzx5VozKpWvQ+4nXhPdFgmx8xqexRcpAglTj9sIBWINXa8x5w==\" crossorigin=\"anonymous\" />");
                    out.println("<link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css2?family=Quicksand:wght@300;400;500;600;700&display=swap\"/>");
                    out.println("<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">");

                    out.println("<style>");
                        out.println("html{");
                            out.println("   background-image: url('background1.jpg');");
                            out.println("   max-width: 100%;");
                            out.println("   max-height: 100%;");
                            out.println("   background-size: 100%;");
                            out.println("   background-position: 50% 35%;");
                            out.println("   margin: auto;");
                            out.println("   display: block;");
                        out.println("}");

                        out.println("body{");
                            out.println("   font-family: 'Quicksand', sans-serif;");
                            out.println("   padding: 0;");
                            out.println("   margin: 0;");
                        out.println("}");

                        out.println("table {");
                            out.println("   border-collapse: collapse;");
                            out.println("   width: 90%;");
                            out.println("   margin: 0 auto;");
                            out.println("   text-align: center;");
                            out.println("   border-radius: 15px;");
                        out.println("}");

                        out.println("th {");
                            out.println("   background-color: #835C3B;");
                            out.println("   color: white;");
                            out.println("   padding: 4px;");
                        out.println("}");

                        out.println("td {");
                            out.println("   padding: 7.5px;");
                        out.println("}");

                        out.println("tr:nth-child(even) {");
                            out.println("   background-color: #FFFFFF");
                        out.println("}");

                        out.println("tr:nth-child(odd) {");
                            out.println("   background-color: #E6DDD8;");
                        out.println("}");

                        out.println("a{");
                            out.println("   text-decoration: none;");
                        out.println("}");

                        out.println("li{");
                            out.println("   list-style-type: none;");
                        out.println("}");

                        out.println("header{");
                            out.println("   display: flex;");
                            out.println("   flex-direction: row;");
                            out.println("   align-items: center;");
                            out.println("   padding: 0px 5%;");
                            out.println("   background-color: #2C3E50;");
                            out.println("   justify-content: space-between;");
                            out.println("   height: 50px;");
                        out.println("}");

                        out.println(".logo{");
                            out.println("   color: #FFF;");
                            out.println("   font-weight: 900;");
                        out.println("}");

                        out.println("nav ul{");
                            out.println("   display: flex;");
                            out.println("   lex-direction: row;");
                        out.println("}");

                        out.println("nav ul li{");
                            out.println("   margin-left: 5px;");
                            out.println("   margin-right: 5px;");
                        out.println("}");

                        out.println("nav ul li a{");
                            out.println("   color: #FFF;");
                            out.println("   display: block;");
                            out.println("   padding: 10px 10px;");
                            out.println("   border-radius: 1px;");
                        out.println("}");

                        out.println("nav ul li a:hover{");
                            out.println("   color: #DC7633;");
                        out.println("}");

                        out.println(".cta{");
                            out.println("   background-color: #DC7633;");
                            out.println("   color: #FFF;");
                        out.println("}");

                        out.println(".cta:hover{");
                            out.println("   background-color: #D35400;");
                            out.println("   color: #FFF;");
                        out.println("}");
                    out.println("</style>");
                out.println("</head>");

                out.println("<body>");
                    out.println("<header>");
                        out.println("<a href=\"#\" class=\"logo\">E-PARCEL UMT</a>");
                        out.println("<nav>");
                            out.println("<ul>");
                                out.println("<li><a href=\"adminHome.jsp\">Home</a></li>");
                                out.println("<li><a href=\"StaffParcel\">Parcel</a></li>");
                                out.println("<li><a href=\"StudentController?action=listStudent\">Student</a></li>");
                                out.println("<li><a href=\"StaffController?action=listStaff\">Staff</a></li>");
                                out.println("<li><a href=\"AdminController?action=listAdmin\">Admin</a></li>");
                                out.println("<li class=\"cta\"><a href=\"AdminController?action=editAdmin&adminid=" 
                                                + adminid + "\">Profile <i class=\"fa fa-user\">&nbsp;</i></a></li>");
                            out.println("</ul>");
                        out.println("</nav>");
                    out.println("</header>");
                    
                    out.println("<h1 style=\"text-align: center; background-color: white;\">PARCEL LIST</h1>");

                    List <Parcel> list = ParcelDao.getAllParcel();

                    out.print("<div style='width: 90%; margin: 0 auto;'>");
                        out.print("<table border='1' width='100%'");
                            out.print("<tr><th>Student ID</th><th>No Tracking</th><th>Weight (kg)</th><th>Price (RM)</th><th>Date Arrived</th><th>Status</th></tr>");

                            for (Parcel e : list) {
                                double weight = Double.parseDouble(e.getParcelWeight());
                                double price = calculatePrice(weight);

                                out.print("<tr><td style='text-align:center;'>" + e.getStudid()
                                        + "</td><td style='text-align:center;'>" + e.getNoTracking()
                                        + "</td><td style='text-align:center;'>" + e.getParcelWeight()
                                        + "</td><td style='text-align:center;'>" + String.format("%.2f", price)
                                        + "</td><td style='text-align:center;'>" + e.getArrivedDate()
                                        + "</td><td style='text-align:center;'>" + e.getParcelStatus() + "</td></tr>");
                            }
                        out.print("</table>");
                    out.print("</div>");
                out.println("</body>");
            out.println("</html>");
        }
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
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Forward the request to the JSP file
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}