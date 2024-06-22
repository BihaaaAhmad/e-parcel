<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
        <title>Navigation Menu Staff</title>
        
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css" integrity="sha512-NhSC1YmyruXifcj/KFRWoC561YpHpc5Jtzgvbuzx5VozKpWvQ+4nXhPdFgmx8xqexRcpAglTj9sIBWINXa8x5w==" crossorigin="anonymous" />
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Quicksand:wght@300;400;500;600;700&display=swap"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

        <style>
            body{
                font-family: 'Quicksand', sans-serif;
            }

            a{
                text-decoration: none;
            }

            li{
                list-style-type: none;
            }

            header{
                display: flex;
                flex-direction: row;
                align-items: center;
                padding: 0px 10%;
                background-color: #2C3E50;
                justify-content: space-between;
                height: 50px;
            }

            .logo{
                color: #FFF;
                font-weight: 900;
            }

            nav ul{
                display: flex;
                flex-direction: row;
            }

            nav ul li{
                margin-left: 5px;
                margin-right: 5px;
            }

            nav ul li a{
                color: #FFF;
                display: block;
                padding: 10px 20px;
                border-radius: 1px;
            }

            nav ul li a:hover{
                color: #DC7633;
            }

            .cta{
                background-color: #DC7633;
                color: #FFF;
            }

            .cta:hover{
                background-color: #D35400;
                color: #FFF;
            }
        </style>
    </head>
    
    <body>
        <header>
            <% String staffid = (String) session.getAttribute("staffid");
                String name = (String) session.getAttribute("name");
            %>
            
            <a href="#" class="logo">E-PARCEL UMT</a>
            <nav>
                <ul>
                    <li><a href="staffHome.jsp">Home</a></li>
                    <li><a href="ViewParcel">Parcel</a></li>
                    <li class="cta"><a href="StaffController?action=editStaff&staffid=<%=staffid%>">Profile <i class="fa fa-user" aria-hidden="true"></i>&nbsp;</a></li>
                </ul>
            </nav>
        </header>
    </body>
</html>