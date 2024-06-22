<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="style1.css">
        <link rel="icon" type="img/png" href="img/delivery.png">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Quicksand:wght@300;400;500;600;700&display=swap"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="popup.js"></script> 
        
        <title>Staff Login</title>

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
            
            .container {
                position: relative;
                margin-right: auto;
                margin-left: auto;
                align-self: center;
                width: 300px;
                height: 450px;
                padding: 35px;
                background-color: white;
                border-radius: 10px;
                border-style: outset;
            }
            
            *{
                margin: 0;
                padding: 0;
            }
            
            body{
                font-family: 'Quicksand', sans-serif;
                height: 100%;
            }

            h1{
                padding: 10px;
                margin: 10px;
                text-align-last: center;
            }
            
            p{
                font-size: 12px;
                text-align: center ;
            }
            
            .error-message {
                color: red;
                font-weight:bold;
            }

            a{
                text-decoration: none ;
            }
            
            a:hover {
                color: red;
                text-decoration: underline ;
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
            
            input[type=submit]:hover {
                background: #4CAF50;
            }
            
            input[type=reset]{
                background-color: red;
                color: white;
                float: right;
            }

            input[type=reset]:hover{
                background: #F75D59;
            }
        </style>
    </head>

    <body>
        <div class="bg-img">
            <form action="doLoginStaff.jsp" class="container" >
                
                <img src="logo_trans.png"><br>
                <h2 style="text-align: center;">STAFF LOGIN</h2>

                <% String message = request.getParameter("message"); %>
                <% if (message != null) {%>
                    <p class="error-message"><%= message%></p>
                <% }%><br>
                
                <label for="staffid">Staff ID</label><br>
                <input type="text" placeholder="Enter Staff ID" name="staffid" required><br>
                
                <label for="password">Password</label><br>
                <input type="password" placeholder="Enter Password" name="password" required>

                <input type="hidden" name="action" value="loginStaff"><br>

                <input type="submit" value="Login" name="loginStaff"/>
                <input type="reset" value="Cancel" onclick="goToLoginPage()"/><br><br>   
            </form>
        </div>
    </body>
</html>