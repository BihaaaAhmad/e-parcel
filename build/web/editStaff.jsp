<%@page import="com.model.Staff"%>
<%@page import="com.dao.StaffDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" type="img/png" href="img/delivery.png">
        <script src="popup.js"></script>
        
        <title>Profile Staff</title>
        
        <style>
            html{
                background-image: url("background1.jpg");
                max-width: 100%;
                max-height: 100%;
                background-size: 100%;
                background-position: 50% 50%;
                margin: auto;
                display: block;
            }
            
            *{
                padding: 0;
                margin: 0;
            }

            h2{
                text-align: center;
            }
            
            form{
                background: whitesmoke;
                width: 260px;
                margin : auto;
                border-radius: 15px;
                padding: 2px 5%;
                line-height: 2;
                justify-content: center;
            }
            
            img {
                display: block;
                height: 110px;
                width: 110px;
                margin-left: auto;
                margin-right: auto;
                margin-top: 4%;
            }
            
            input[type=text],input[type=email],input[type=password]{
                display: inline-block;
                box-sizing: border-box;
                border: 1px solid #ccc;
                border-radius: 4px;
                margin: auto;
                font-size: 15px;
                text-indent: 2px;
                width: 100%;
                padding: 8px 0;
            }
            
            input[type=submit],input[type=reset]{
                padding: 15px 0px;
                border: none ;
                border-radius: 4px;
                cursor: pointer;
                width: 30%;
                font-size: 15px;
            }
            
            input[type=submit]{
                background-color: green;
                color: white;
                float: left;
            }
            
            input[type=reset]{
                background-color: red;
                color: white;
                float: right;
            }

            input[type=submit]:hover {
                background: #4CAF50;
            }
            
            input[type=reset]:hover{
                background: #F75D59;
            }
        </style>
    </head>
    
    <body>
        <jsp:include page="staffNav.jsp"/><br>
        
        <% String staffid = (String) session.getAttribute("staffid");

            StaffDao dao = new StaffDao();
            Staff staff = dao.getStaffById(staffid);
            
            request.setAttribute("staff", staff);
        %>
        
        <form  name="frmEditStudent" action="StaffController" method="post">
            
            <img class="center" src="user.png">
            
            <h2>PROFILE STAFF</h2><br>

            <label for="staffid">Staff ID</label><br>
            <input type="text" name="staffid" readonly="readonly" value="<c:out value="${staff.staffid}"/>"/><br>

            <label for="name">Full Name</label><br>
            <input type="text" name="name" readonly="readonly" value="<c:out value="${staff.name}"/>"/><br>

            <label for="email">Email</label><br>
            <input type="text" name="email" value="<c:out value="${staff.email}"/>"/><br>

            <label for="phoneno">Phone Number</label><br>
            <input type="text" name="phoneno"  value="<c:out value="${staff.phoneno}"/>"/><br>

            <label for="password">Password</label><br>
            <input type="password" name="password" value="<c:out value="${staff.password}"/>"/><br><br>

            <input type="hidden" name="action" value="editStaff"/>
            
            <input type="submit" value="Edit" onclick="showUpdate()"/>
            <input type="reset" value="Cancel"/><br><br>
        </form><br>
    </body>
</html>