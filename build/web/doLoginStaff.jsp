<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DoLogin Staff</title>
    </head>
    
    <body>
        <%
            String staffid = request.getParameter("staffid");
            String password = request.getParameter("password");

            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/parcelsystem", "root", "admin");
                
                Statement statement = connection.createStatement();
                String query = "SELECT * FROM staff WHERE staffid='" + staffid + "' " + "AND password='" + password + "'";
                ResultSet resultSet = statement.executeQuery(query);

                if (resultSet.next()) {
                    String name = resultSet.getString("name");
                    session.setAttribute("staffid", staffid);
                    session.setAttribute("name", name);
                    response.sendRedirect("staffHome.jsp");
                } 
                
                else {
                    response.sendRedirect("loginStaff.jsp?message=Invalid staff ID or password..!");
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