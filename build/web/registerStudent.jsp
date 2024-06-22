<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <link rel="icon" type="img/png" href="img/delivery.png">
        <link rel="stylesheet" type="text/css" href="style1.css">
        <script src="popup.js"></script>
        
        <title>Register Student</title>
        
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
                margin: 2% auto;
                align-self: center;
                width: 350px;
                height: 700px;
                padding: 45px ;
                background: whitesmoke;
                border-radius: 10px;
                border-style: outset;
                font-family: 'Quicksand', sans-serif;
            }
            
            h2{
                text-align: center;
                font-family: 'Quicksand', sans-serif;
            }
            
            p{
                font-size: 10px;
                text-align: center ;
            }
            
            input[type=submit],input[type=reset]{
                padding: 15px 0px ;
                border: none ;
                border-radius: 4px;
                cursor: pointer ;
                width: 40% ;
                opacity: 0.9 ;
                font-size: 15px;
            }
            
            input[type=submit]{
                background-color: green;
                color: white ;
                float: left;
            }
            
            input[type=reset]{
                background-color: red;
                color: white ;
                float: right;
            }

            input[type=submit]:hover {
                background: #4CAF50;
                opacity: 1 ;
            }
            
            input[type=reset]:hover{
                background: #F75D59;
                opacity: 1 ;
            }
        </style>
    </head>

    <body>
        <div  class="bg-img">
            <form name="frmAddStudent" action="StudentController" class="container"  method="post" >

                <img src="logo_trans.png"><br>
                
                <h2>Create An Account!</h2><br>

                <label for="studid">Student ID</label> <br>
                <input type="text" placeholder="Enter Student ID" name="studid" id="studid" value="" required><br>

                <label for="name">Full Name</label> <br>
                <input type="text" placeholder="Enter Full Name" name="name" id="name" value="" required><br>

                <label for="email">Email</label> <br>
                <input type="email" placeholder="Enter Email" name="email" id="email" value="" required><br>

                <label for="phoneno">Phone Number</label> <br>
                <input type="text" placeholder="Enter Phone Number" name="phoneno" id="phoneno" value="" required><br>

                <label for="password">Password</label><br>
                <input type="password" placeholder="Enter Password" name="password" value="" required>

                <input type="hidden" name="action" value="insertStudent"><br>
                
                <input type="submit" value="Register Account" name="insertStudent" onclick="showRegister()"/>
                <input type="reset" value="Cancel" onclick="goToStudentLoginPage()"/>
                <br><br>
            </form><br>
        </div>
    </body>
</html>