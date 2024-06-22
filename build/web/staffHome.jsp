<%@page import="com.model.Staff"%>
<%@page import="com.dao.StaffDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" type="img/png" href="img/delivery.png">
        <script src="popup.js"></script>
        
        <title>Staff Home</title>
        
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
            <jsp:include page="staffNav.jsp"/>
            
            <% String staffid = (String) session.getAttribute("staffid");

                StaffDao dao = new StaffDao();
                Staff staff = dao.getStaffById(staffid);

                request.setAttribute("staff", staff);
            %>
            
            <img class="center" src="user.png"><br>
            
            <h1 class="center">Hello, Staff!</h1>
            <h1 class="center">ID : <span>${staff.staffid}</span></h1>
            <h1 class="center">Name : <span>${staff.name}</span></h1>
            
            <p style="text-align: center;"><input type="submit" value="Logout" onclick="return confirmLogout();"></p>           
        </form>
    </body>
</html>