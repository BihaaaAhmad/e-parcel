<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DoLogin Manager</title>
    </head>
    
    <body>
        <%
            String adminid = request.getParameter("adminid");
            String password = request.getParameter("password");
            
            session = request.getSession();
            
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/parcelsystem", "root", "admin");
                
                Statement statement = connection.createStatement(); 
                String query = "SELECT * FROM admin WHERE adminid='" + adminid + "' " + "AND password='" + password + "'";
                ResultSet resultSet = statement.executeQuery(query);

                if (resultSet.next()) {
                    String name = resultSet.getString("name");
                    session.setAttribute("adminid", adminid);
                    session.setAttribute("name", name);
                    response.sendRedirect("adminHome.jsp");
                } 
                
                else {
                    response.sendRedirect("loginAdmin.jsp?message=Invalid admin ID or password..!");
                }
                resultSet.close();
                statement.close();
                connection.close();
            } 
            
            catch (Exception e) {
                e.printStackTrace();
            }
        %>
    </body>
</html>