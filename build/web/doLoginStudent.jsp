<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DoLogin Student</title>
    </head>
    
    <body>
        <%
            String studid = request.getParameter("studid");
            String password = request.getParameter("password");
            
            session = request.getSession();
            
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/parcelsystem", "root", "admin");
                
                Statement statement = connection.createStatement();
                String query = "SELECT * FROM student WHERE studid='" + studid + "' " + "AND password='" + password + "'";
                ResultSet resultSet = statement.executeQuery(query);

                if (resultSet.next()) {
                    String name = resultSet.getString("name");
                    session.setAttribute("studid", studid);
                    session.setAttribute("name", name);
                    response.sendRedirect("studentHome.jsp");
                } 
                
                else {
                    response.sendRedirect("loginStudent.jsp?message=Invalid student ID or password..!");
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