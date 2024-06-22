import com.parcel.Parcel;
import com.parcel.ParcelDao;

import java.io.IOException;
import java.io.PrintWriter;

import java.text.DecimalFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class receiptPage extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String noTracking = request.getParameter("noTracking");
        Parcel parcel = ParcelDao.getParcelByNoTracking(noTracking);

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
            out.println("<head>");
            out.println("<link rel='icon' type='img/png' href='img/delivery.png'>");

            out.println("<title>Receipt</title>");

            out.println("<style>");
                out.println("html{");
                    out.println("   background-image: url('background1.jpg');");
                    out.println("   max-width: 100%;");
                    out.println("   max-height: 100%;");
                    out.println("   background-size: 100%;");
                    out.println("   background-position: 50% 50%;");
                    out.println("   margin: auto;");
                    out.println("   display: block;");
                out.println("}");

                out.println("* {");
                    out.println("   margin: 0;");
                    out.println("   padding: 0;");
                    out.println("   font-family: \"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif;");
                    out.println("   box-sizing: border-box;");
                    out.println("   font-size: 14px;");
                out.println("}");

                out.println("img {");
                    out.println("   height: 45%;");
                    out.println("   width: 45%;");
                out.println("}");

                out.println("body {");
                    out.println("   -webkit-font-smoothing: antialiased;");
                    out.println("   -webkit-text-size-adjust: none;");
                    out.println("   width: 100% !important;");
                    out.println("   height: 100%;");
                    out.println("   line-height: 1.6;");
                out.println("}");

                out.println("/* Let's make sure all tables have defaults */");

                out.println("table td {");
                    out.println("   vertical-align: top;");
                out.println("}");

                out.println("/*-------------------------------------");
                out.println("    BODY & CONTAINER");
                out.println("------------------------------------- */");

                out.println(".body-wrap {");
                    out.println("   width: 100%;");
                out.println("}");

                out.println(".container {");
                    out.println("   display: block !important;");
                    out.println("   max-width: 500px !important;");
                    out.println("   margin: 0 auto !important;");
                    out.println("   /* makes it centered */");
                    out.println("   clear: both !important;");
                out.println("}");

                out.println(".content {");
                    out.println("   max-width: 600px;");
                    out.println("   margin: 0 auto;");
                    out.println("   display: block;");
                    out.println("   padding: 20px;");
                out.println("}");

                out.println("/*-------------------------------------");
                out.println("    HEADER, FOOTER, MAIN");
                out.println("------------------------------------- */");

                out.println(".main {");
                    out.println("   background: #fff;");
                    out.println("   border: 1px solid #e9e9e9;");
                    out.println("   border-radius: 3px;");
                    out.println("   border-style: groove;");
                    out.println("   border-width: 7px;");
                out.println("}");

                out.println(".content-wrap {");
                    out.println("   padding: 20px;");
                out.println("}");

                out.println(".content-block {");
                    out.println("   padding: 0 20px;");
                out.println("}");

                out.println(".header {");
                    out.println("   width: 100%;");
                    out.println("   margin-bottom: 20px;");
                out.println("}");

                out.println(".footer {");
                    out.println("   width: 100%;");
                    out.println("   clear: both;");
                    out.println("   color: black;");
                    out.println("   padding: 20px;");
                out.println("}");

                out.println(".footer a {");
                    out.println("   color: black;");
                out.println("}");

                out.println(".footer p, .footer a, .footer unsubscribe, .footer td {");
                    out.println("   font-size: 12px;");
                out.println("}");

                out.println("/*-------------------------------------");
                out.println("    TYPOGRAPHY");
                out.println("------------------------------------- */");

                out.println("h1, h2, h3 {");
                    out.println("   font-family: \"Helvetica Neue\", Helvetica, Arial, \"Lucida Grande\", sans-serif;");
                    out.println("   color: #000;");
                    out.println("   margin: 40px 0 0;");
                    out.println("   line-height: 1.2;");
                    out.println("   font-weight: 400;");
                out.println("}");

                out.println("h1 {");
                    out.println("   font-size: 32px;");
                    out.println("   font-weight: 500;");
                out.println("}");

                out.println("h2 {");
                    out.println("   font-size: 24px;");
                out.println("}");

                out.println("h3 {");
                    out.println("   font-size: 18px;");
                out.println("}");

                out.println("h4 {");
                    out.println("   font-size: 14px;");
                    out.println("   font-weight: 600;");
                out.println("}");

                out.println("p, ul, ol {");
                    out.println("   margin-bottom: 10px;");
                    out.println("   font-weight: normal;");
                out.println("}");

                out.println("p li, ul li, ol li {");
                    out.println("   margin-left: 5px;");
                    out.println("   list-style-position: inside;");
                out.println("}");

                out.println("/*-------------------------------------");
                out.println("    LINKS & BUTTONS");
                out.println("------------------------------------- */");

                out.println("a {");
                    out.println("   color: #1ab394;");
                    out.println("   text-decoration: underline;");
                out.println("}");

                out.println(".btn-primary {");
                    out.println("   text-decoration: none;");
                    out.println("   color: #FFF;");
                    out.println("   background-color: #1ab394;");
                    out.println("   border: solid #1ab394;");
                    out.println("   border-width: 5px 10px;");
                    out.println("   line-height: 2;");
                    out.println("   font-weight: bold;");
                    out.println("   text-align: center;");
                    out.println("   cursor: pointer;");
                    out.println("   display: inline-block;");
                    out.println("   border-radius: 5px;");
                    out.println("   text-transform: capitalize;");
                out.println("}");

                out.println("/*-------------------------------------");
                out.println("    OTHER STYLES THAT MIGHT BE USEFUL");
                out.println("------------------------------------- */");

                out.println(".last {");
                    out.println("   margin-bottom: 0;");
                out.println("}");

                out.println(".first {");
                    out.println("   margin-top: 0;");
                out.println("}");

                out.println(".aligncenter {");
                    out.println("   text-align: center;");
                out.println("}");

                out.println(".alignright {");
                    out.println("   text-align: right;");
                out.println("}");

                out.println(".alignleft {");
                    out.println("   text-align: left;");
                out.println("}");

                out.println(".clear {");
                    out.println("   clear: both;");
                out.println("}");

                out.println("/*-------------------------------------");
                out.println("    ALERTS");
                out.println("    Change the class depending on warning email, good email or bad email");
                out.println("------------------------------------- */");

                out.println(".alert {");
                    out.println("   font-size: 16px;");
                    out.println("   color: #fff;");
                    out.println("   font-weight: 500;");
                    out.println("   padding: 20px;");
                    out.println("   text-align: center;");
                    out.println("   border-radius: 3px 3px 0 0;");
                out.println("}");

                out.println(".alert a {");
                    out.println("   color: #fff;");
                    out.println("   text-decoration: none;");
                    out.println("   font-weight: 500;");
                    out.println("   font-size: 16px;");
                out.println("}");

                out.println(".alert.alert-warning {");
                    out.println("   background: #f8ac59;");
                out.println("}");

                out.println(".alert.alert-bad {");
                    out.println("   background: #ed5565;");
                out.println("}");

                out.println(".alert.alert-good {");
                    out.println("   background: #1ab394;");
                out.println("}");

                out.println("/*-------------------------------------");
                out.println("    INVOICE");
                out.println("    Styles for the billing table");
                out.println("------------------------------------- */");

                out.println(".invoice {");
                    out.println("  margin: 40px auto;");
                    out.println("  text-align: left;");
                    out.println("  width: 80%;");
                out.println("}");

                out.println(".invoice td {");
                    out.println("  padding: 5px 0;");
                out.println("}");

                out.println(".invoice .invoice-items {");
                    out.println("  width: 100%;");
                out.println("}");

                out.println(".invoice .invoice-items td {");
                    out.println("  border-top: #eee 1px solid;");
                out.println("}");

                out.println(".invoice .invoice-items .total td {");
                    out.println("  border-top: 2px solid #333;");
                    out.println("  border-bottom: 2px solid #333;");
                    out.println("  font-weight: 700;");
                out.println("}");

                out.println("/*-------------------------------------");
                out.println("    RESPONSIVE AND MOBILE FRIENDLY STYLES");
                out.println("------------------------------------- */");

                out.println("@media only screen and (max-width: 640px) {");

                out.println("h1, h2, h3, h4 {");
                    out.println("   font-weight: 600 !important;");
                    out.println("   margin: 20px 0 5px !important;");
                out.println("}");

                out.println("h1 {");
                    out.println("   font-size: 22px !important;");
                out.println("}");

                out.println("h2 {");
                    out.println("   font-size: 18px !important;");
                out.println("}");

                out.println("h3 {");
                    out.println("   font-size: 16px !important;");
                out.println("}");

                out.println(".container {");
                    out.println("   width: 100% !important;");
                out.println("}");

                out.println(".content, .content-wrap {");
                    out.println("   padding: 10px !important;");
                    out.println("   margin: auto;");
                out.println("}");

                out.println(".invoice {");
                    out.println("  width: 100% !important;");
                out.println("}");

                /*out.println(" input[type=reset]{");
                    out.println("   padding: 15px 0px ;");
                    out.println("   border: none ;");
                    out.println("   border-radius: 4px;");
                    out.println("   cursor: pointer ;");
                    out.println("   width: 30% ;");
                    out.println("   font-size: 15px;");
                    out.println("   background-color: red;");
                    out.println("   color: white ;");
                    out.println("   float: right;");
                out.println("   }");

                out.println("   input[type=reset]:hover{");
                    out.println("   background: #F75D59;");
                out.println("   }");*/
            out.println("</style>");
            out.println("</head>");

            out.println("<body>");
                out.println("<div class=\"bg-img\">");
                    out.println("<center><table class=\"body-wrap\">");
                        out.println("<tr>");
                            out.println("<td></td>");
                            out.println("<td class=\"container\" width=\"600\">");
                            out.println("<div class=\"content\">");
                                out.println("<table class=\"main\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\">");
                                    out.println("<tr>");
                                        out.println("<td class=\"content-wrap aligncenter\">");
                                        out.println("<table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\">");
                                            out.println("<tr>");
                                                out.println("<td class=\"content-block\">");
                                                out.println("<img src=\"logo_trans.png\">");
                                                out.println("<h4>E-PARCEL UMT</h4>");
                                                out.println("<h4>SISWA POST KOLEJ KEDIAMAN UMT</h4>");
                                                out.println("</td>");
                                            out.println("</tr>");

                                            out.println("<tr>");
                                                out.println("<td class=\"content-block\">");
                                                out.println("<table class=\"invoice\">");
                                                    out.println("<tr>");
                                                        out.println("<td>&#10145; No Tracking : " + parcel.getNoTracking()
                                                            + "<br>&#10145; Student ID : " + parcel.getStudid()
                                                            + "<br>&#10145; Status : " + parcel.getParcelStatus() + "</td>");
                                                    out.println("</tr>");

                                                    out.println("<tr>");
                                                        out.println("<td>");
                                                        out.println("<table class=\"invoice-items\" cellpadding=\"0\" cellspacing=\"0\">");
                                                            out.println("<tr>");
                                                                out.println("<td>Weight (kg)</td>");
                                                                out.println("<td class=\"alignright\">" + parcel.getParcelWeight() + "</td>");
                                                            out.println("</tr>");

                                                            out.println("<tr class=\"total\">");
                                                                out.println("<td>Price (RM)</td>");
                                                                double weight = Double.parseDouble(parcel.getParcelWeight());
                                                                double total = calculatePrice(weight);
                                                                DecimalFormat df = new DecimalFormat("0.00");
                                                                String formattedTotal = df.format(total);
                                                                out.println("<td class=\"alignright\">" + formattedTotal + "</td>");
                                                            out.println("</tr>");
                                                        out.println("</table>");
                                                        out.println("</td>");
                                                    out.println("</tr>");
                                                out.println("</table>");
                                                out.println("</td>");
                                            out.println("</tr>");

                                            out.println("<tr>");
                                                out.println("<td class=\"content-block\">");
                                                out.println("Thank you for using our service");
                                                out.println("</td>");
                                            out.println("</tr>");
                                            
                                        out.println("</table>");
                                        out.println("</td>");
                                    out.println("</tr>");
                                out.println("</table>");
                            out.println("<div class=\"footer\">");
                                out.println("<table width=\"100%\">");
                                    out.println("<tr>");
                                        out.println("<td class=\"aligncenter content-block\">Questions? Email <a href=\"mailto:support@company.inc\">siswapostumt@gmail.com</a></td>");
                                    out.println("</tr>");
                                out.println("</table>");
                            out.println("</div>");
                            
                            out.println("</div>");
                            out.println("</td>");
                        out.println("<td></td>");
                        out.println("</tr>");
                    out.println("</table></center>");
                out.println("</div>");
                /*out.println("<input type='reset' value='Back' onclick='history.back()'/>");*/
            out.println("</body>");
        out.println("</html>");

        out.close();
    }

    private double calculatePrice(double weight) {
        double price = weight * 1.0;
        price = Math.round(price * 10.0) / 10.0; // Round to one decimal place
        return price;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    public String getServletInfo() {
        return "Receipt Page Servlet";
    }
}