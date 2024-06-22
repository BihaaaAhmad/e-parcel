package com.parcel;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Group 9
 */

public class StudentParcel extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        // Retrieve the student ID from the request parameter
        try (PrintWriter out = response.getWriter()) {
            
            // Retrieve the student ID from the request parameter
            String studid = request.getParameter("studid");
            
            // Set the studid attribute in the request
            request.setAttribute("studid", studid);
            
            out.println("<html>");
                out.println("<head>"); 
                out.println("<link rel='icon' type='img/png' href='img/delivery.png'>");
                
                out.println("<title>Parcel List</title>");
                
                    out.println("<style>");
                        out.println("@import url('https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css');");
                        out.println("@import url('https://fonts.googleapis.com/css2?family=Quicksand:wght@300;400;500;600;700&display=swap');");
                        out.println("@import url('https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css');");

                        out.println("html{");
                            out.println("   background-image: url('background1.jpg');");
                            out.println("   max-width: 100%;");
                            out.println("   max-height: 100%;");
                            out.println("   background-size: 100%;");
                            out.println("   background-position: 50% 50%;");
                            out.println("   margin: auto;");
                            out.println("   display: block;");
                        out.println("}");
                        
                        out.println("body {");
                            out.println("   padding: 0;");
                            out.println("   margin: 0;");
                            out.println("   font-family: 'Quicksand', sans-serif;");
                        out.println("}");

                        out.println("h1 {");
                            out.println("   text-align: center;");
                        out.println("}");

                        out.println("table {");
                            out.println("   border-collapse: collapse;");
                            out.println("   width: 90%;");
                            out.println("   margin: auto;");
                            out.println("   text-align: center;");
                            out.println("   border-radius: 15px;");
                        out.println("}");

                        out.println("th {");
                            out.println("   background-color: #835C3B;");
                            out.println("   color: white;");
                        out.println("}");

                        out.println("tr:nth-child(even) {");
                            out.println("   background-color: #FFFFFF");
                        out.println("}");

                        out.println("tr:nth-child(odd) {");
                            out.println("   background-color: #E6DDD8;");
                        out.println("}");
            
                        out.println("#edit {");
                            out.println("   background: #4caf50;");
                            out.println("   color: white;");
                            out.println("   border: none;");
                            out.println("   border-radius: 4px;");
                            out.println("   padding: 5px;");
                            out.println("   margin: 5px;");
                            out.println("   width: 30px;");
                            out.println("   cursor: pointer;");
                        out.println("}");
                        
                        out.println("#delete {");
                            out.println("   background: #DC7633;");
                            out.println("   color: white;");
                            out.println("   border: none;");
                            out.println("   border-radius: 4px;");
                            out.println("   padding: 5px;");
                            out.println("   margin: 5px;");
                            out.println("   width: 30px;");
                            out.println("   cursor: pointer;");
                        out.println("}");
                        
                        out.println("#delete:hover {");
                            out.println("   background: #D35400;");
                        out.println("}");
                        
                        out.println("#edit:hover {");
                            out.println("   background: green;");
                        out.println("}");
                        
                        out.println("p a {");
                            out.println("   background: #DC7633;");
                            out.println("   color: white;");
                            out.println("   border: none;");
                            out.println("   border-radius: 4px;");
                            out.println("   padding: 10px 20px;");
                            out.println("   margin: 15px 40px;");
                        out.println("}");
                            
                        out.println("p a:hover {");
                            out.println("   background: #D35400;");
                        out.println("}");
                        out.println("");
                        
                        out.println("a {");
                            out.println("   text-decoration: none;");
                        out.println("}");
                        out.println("");

                        out.println("li {");
                            out.println("   list-style-type: none;");
                        out.println("}");
                        out.println("");

                        out.println("header {");
                            out.println("   display: flex;");
                            out.println("   flex-direction: row;");
                            out.println("   align-items: center;");
                            out.println("   padding: 0px 10%;");
                            out.println("   background-color: #2C3E50;");
                            out.println("   justify-content: space-between;");
                            out.println("   height: 50px;");
                        out.println("}");
                        out.println("");

                        out.println(".logo {");
                            out.println("   color: #FFF;");
                            out.println("   font-weight: 900;");
                        out.println("}");
                        out.println("");

                        out.println("nav ul {");
                            out.println("   display: flex;");
                            out.println("   flex-direction: row;");
                        out.println("}");
                        out.println("");
            
                        out.println("nav ul li {");
                            out.println("   margin-left: 5px;");
                            out.println("   margin-right: 5px;");
                        out.println("}");
                        out.println("");

                        out.println("nav ul li a {");
                            out.println("   color: #FFF;");
                            out.println("   display: block;");
                            out.println("   padding: 10px 20px;");
                            out.println("   border-radius: 1px;");
                        out.println("}");
                        out.println("");

                        out.println("nav ul li a:hover {");
                            out.println("   color: #DC7633;");
                        out.println("}");
                        out.println("");

                        out.println(".cta {");
                            out.println("   background-color: #DC7633;");
                            out.println("   color: #FFF;");
                        out.println("}");
                        out.println("");
            
                        out.println(".cta:hover {");
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
                                out.println("<li><a href=\"studentHome.jsp\">Home</a></li>");
                                out.println("<li><a href=\"#parcel.jsp\">Parcel</a></li>");
                                out.println("<li class=\"cta\"><a href=\"editStudent.jsp?studid=" + studid + "\">");
                                out.println("Profile <i class=\"fa fa-user\" aria-hidden=\"true\">&nbsp;</i></a></li>");
                            out.println("</ul>");
                        out.println("</nav>");
                    out.println("</header>");
            
                    out.println("<h1 style=\"text-align: center; background-color: white;\">PARCEL LIST</h1>");
                    out.println("<h3 style=\"text-align: center; background-color: #FFEFD5;\">Student ID: " + studid + "</h3>");
                    
                    List <Parcel> list = ParcelDao.getParcelByStudentId(studid);
                    
                    out.print("<table border='1' width='100%'");
                        out.print("<tr><th>No Tracking</th><th>Weight (kg)</th><th>Price (RM)</th><th>Date Arrived</th><th>Status</th></tr>");

                        for (Parcel e : list) {
                            double weight = Double.parseDouble(e.getParcelWeight());
                            double price = calculatePrice(weight);

                            out.print("<tr><td style='text-align:center;'>" + e.getNoTracking()
                                + "</td><td style='text-align:center;'>" + e.getParcelWeight()
                                + "</td><td style='text-align:center;'>" + String.format("%.2f", price)
                                + "</td><td style='text-align:center;'>" + e.getArrivedDate()
                                + "</td><td style='text-align:center;'>" + e.getParcelStatus() + "</td></tr>");
                        }
                    out.print("</table>");
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