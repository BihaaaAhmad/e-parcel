<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" type="img/png" href="img/delivery.png">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="popup.js"></script>
        
        <title>Staff List</title>

        <style>
            html{
                background-image: url("background1.jpg");
                max-width: 100%;
                max-height: 100%;
                background-size: 100%;
                background-position: 50% 40%;
                margin: auto;
                display: block;
            }
            
            body{
                padding: 0;
                margin: 0;
            }

            h1{
                text-align: center;
            }
            
            table{
                border-collapse:collapse;
                width: 90%;
                margin: auto;
                text-align: center;
                border-radius: 15px;
            }
            
            th{
                background: #E5788F;
                color: white;
                padding: 4px;
            }

            tr:nth-child(even) {
                background-color:  #FFFFFF;
            }
            
            tr:nth-child(odd) {
                background-color:  #FFE6E8;
            }

            #delete{
                background: red;
                color: white;
                border: none;
                border-radius: 4px;
                padding: 5px;
                margin: 5px;
                width: 50px;
                cursor: pointer ;
            }
            
            #delete:hover{
                background: #F75D59;
            }

            p a{
                background: #FFE6E8;
                color: black;
                border: none;
                border-radius: 4px;
                padding: 10px 20px;
                margin: 15px 40px;
            }
            
            p a:hover{
                background: #E5788F;
                color: white;
            }
        </style>
    </head>
    
    <body>
        <jsp:include page="adminNav.jsp"/>
        <div id="panel"><br>
            
            <h1 style="background-color:white;">STAFF LIST</h1>
            <table border="1">
                <thead>
                    <tr>
                        <th>Staff ID</th>
                        <th>Name</th>
                        <th>Email</th>
                        <th>Phone No</th>
                        <th>Password</th>
                        <th>Action</th>
                    </tr>
                </thead>
                
                <tbody>
                    <c:forEach items="${staffs}" var="staff">
                        <tr>
                            <td><c:out value="${staff.staffid}" /></td>
                            <td><c:out value="${staff.name}" /></td>
                            <td><c:out value="${staff.email}" /></td>
                            <td><c:out value="${staff.phoneno}" /></td>
                            <td><c:out value="${staff.password}" /></td>
                            <td><a href="StaffController?action=deleteStaff&staffid=<c:out value="${staff.staffid}" />" onclick="return confirmDelete();"><button id="delete"><i class="fa fa-trash" aria-hidden="true"></i></button></a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table><br>
            <p style='text-align: center;'><a href="StaffController?action=addStaff">New Staff</a></p><br>
        </div>
    </body>
</html>