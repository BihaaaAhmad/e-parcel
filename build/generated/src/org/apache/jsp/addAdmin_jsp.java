package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class addAdmin_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"icon\" type=\"img/png\" href=\"img/delivery.png\">\n");
      out.write("        <script src=\"popup.js\"></script>\n");
      out.write("        \n");
      out.write("        <title>Add Manager</title>      \n");
      out.write("        \n");
      out.write("        <style>\n");
      out.write("            html{\n");
      out.write("                background-image: url(\"background1.jpg\");\n");
      out.write("                max-width: 100%;\n");
      out.write("                max-height: 100%;\n");
      out.write("                background-size: 100%;\n");
      out.write("                background-position: 50% 50%;\n");
      out.write("                margin: auto;\n");
      out.write("                display: block;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            *{\n");
      out.write("                padding: 0;\n");
      out.write("                margin: 0;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            h2{\n");
      out.write("                text-align: center;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            form{\n");
      out.write("                background: whitesmoke;\n");
      out.write("                width: 260px;\n");
      out.write("                margin : auto;\n");
      out.write("                border-radius: 15px;\n");
      out.write("                padding: 2px 5%;\n");
      out.write("                line-height: 2;\n");
      out.write("                justify-content: center;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            img {\n");
      out.write("                display: block;\n");
      out.write("                height: 110px;\n");
      out.write("                width: 110px;\n");
      out.write("                margin-left: auto;\n");
      out.write("                margin-right: auto;\n");
      out.write("                margin-top: 4%;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            input[type=text],input[type=email],input[type=password]{\n");
      out.write("                display: inline-block;\n");
      out.write("                box-sizing: border-box;\n");
      out.write("                border: 1px solid #ccc;\n");
      out.write("                border-radius: 4px;\n");
      out.write("                margin: auto;\n");
      out.write("                font-size: 15px;\n");
      out.write("                text-indent: 2px;\n");
      out.write("                width: 100%;\n");
      out.write("                padding: 8px 0;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            input[type=submit],input[type=reset]{\n");
      out.write("                padding: 15px 0px;\n");
      out.write("                border: none;\n");
      out.write("                border-radius: 4px;\n");
      out.write("                cursor: pointer;\n");
      out.write("                width: 30%;\n");
      out.write("                font-size: 15px;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            input[type=submit]{\n");
      out.write("                background-color: green;\n");
      out.write("                color: white;\n");
      out.write("                float: left;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            input[type=reset]{\n");
      out.write("                background-color: red;\n");
      out.write("                color: white;\n");
      out.write("                float: right;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            input[type=submit]:hover {\n");
      out.write("                background: #4CAF50;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            input[type=reset]:hover{\n");
      out.write("                background: #F75D59;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    \n");
      out.write("    <body>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "adminNav.jsp", out, false);
      out.write("<br>\n");
      out.write("\n");
      out.write("        <form  name=\"frmEditStudent\" action=\"AdminController\" method=\"post\">\n");
      out.write("\n");
      out.write("            <img class=\"center\" src=\"user.png\">\n");
      out.write("            \n");
      out.write("            <h2>NEW MANAGER</h2><br>\n");
      out.write("\n");
      out.write("            <label for=\"adminid\">Manager ID</label><br>\n");
      out.write("            <input type=\"text\" name=\"adminid\" value=\"\" required>\n");
      out.write("            \n");
      out.write("            <label for=\"name\">Full Name</label><br>\n");
      out.write("            <input type=\"text\" name=\"name\"  value=\"\" required><br>\n");
      out.write("\n");
      out.write("            <label for=\"email\">Email</label><br>\n");
      out.write("            <input type=\"text\" name=\"email\" value=\"\" required><br>\n");
      out.write("\n");
      out.write("            <label for=\"phoneno\">Phone Number</label><br>\n");
      out.write("            <input type=\"text\" name=\"phoneno\"  value=\"\" required><br>\n");
      out.write("\n");
      out.write("            <label for=\"password\">Password</label><br>\n");
      out.write("            <input type=\"password\" name=\"password\" value=\"\" required><br><br>\n");
      out.write("            \n");
      out.write("            <input type=\"hidden\" name=\"action\" value=\"addAdmin\">\n");
      out.write("            \n");
      out.write("            <input type=\"submit\" value=\"Add\" onclick=\"showAdd()\"/>\n");
      out.write("            <input type=\"reset\" value=\"Cancel\"/><br><br>\n");
      out.write("        </form><br>\n");
      out.write("    </body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
