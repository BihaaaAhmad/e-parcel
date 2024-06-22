<%@page import="com.model.Student"%>
<%@page import="com.dao.StudentDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" type="img/png" href="img/delivery.png">
        <script src="popup.js"></script>
        
        <title>Student Home</title>
        
        <style>
            span {
                color: cornflowerblue;
                font-size: 30px;
            }
            
            .center {
                text-align: center;
            }
            
            input[type=submit] {
                background-color: #34282C;
                color: white;
                padding: 15px;
                border: none;
                cursor: pointer;
                width: 8%;
                border-radius: 10px;
                margin-top: 15%;
            }
            
            input[type=submit]:hover {
                background: #757575;
            }
            
            img {
                display: block;
                height: 110px;
                width: 110px;
                margin-left: auto;
                margin-right: auto;
                margin-top: 4%;
            }
        </style>
    </head>
    
    <body>
        <form method="post" action="logoutProcess.jsp">
            <jsp:include page="studentNav.jsp"/>
            
            <% String studid = (String) session.getAttribute("studid");

                StudentDao dao = new StudentDao();
                Student student = dao.getStudentById(studid);

                request.setAttribute("student", student);
            %>
            
            <img class="center" src="user.png"><br>
            
            <h1 class="center">Hello, Student!</h1>
            <h1 class="center">ID : <span>${student.studid}</span></h1>
            <h1 class="center">Name : <span>${student.name}</span></h1>
        
            <p style="text-align: center;"><input type="submit" value="Logout" onclick="return confirmLogout();" >
        </form>
    </body>
</html>