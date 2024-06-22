<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="icon" type="img/png" href="img/delivery.png">
        <link rel="stylesheet" href="style1.css"/>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Quicksand:wght@300;400;500;600;700&display=swap"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        
        <title>User Type</title>

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
            
            body{
                font-family: 'Quicksand', sans-serif;
                text-align: center;
            }
            
            h1{
                padding: 10px;
                margin: 15px;
            }
            
            .container {
                position: relative;
                margin-right: auto;
                margin-left: auto;
                align-self: center;
                width: 300px;
                height: 530px;
                padding: 35px;
                background-color: white;
                border-radius: 10px;
                border-style: outset;
            }
            
            button{
                background-color: #82CAFF;
                color: black;
                padding: 15px 10px;
                border: none;
                cursor: pointer;
                width: 50%;
                border-radius: 10px;
                font-size: 15px;
            }

            button:hover {
                background: #151B54;
                color: white;
            }
        </style>
    </head>
    
    <body>
        <div class="bg-img">
            <div class="container">
                
                <img src="logo_trans.png">
                
                <br><h2>Welcome to</h2>
                <h2>&#128230; E-PARCEL UMT &#128230;</h2><br><br>
                <h4>Choose your user type:</h4><br><br>
                
                <a href="loginStudent.jsp"><button>Student</button></a>
                <br><br>
                
                <a href="loginStaff.jsp"><button>Staff</button></a>
                <br><br>
                
                <a href="loginAdmin.jsp"><button>Manager</button></a>
                <br><br>
            </div>
        </div>
    </body>
</html>