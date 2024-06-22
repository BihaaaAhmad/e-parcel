<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" type="img/png" href="img/delivery.png">
        <link rel="stylesheet" href="style1.css"/>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Quicksand:wght@300;400;500;600;700&display=swap"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        
        <title>Logout</title>

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
                width: 300px ;
                height: fit-content ;
                padding: 35px ;
                background-color: white ;
                border-radius: 10px;
                border-style: outset;
            }
            
            body{
                font-family: 'Quicksand', sans-serif;
                text-align: center;
            }
            
            h2{
                padding: 10px;
                margin: 15px;
            }

            button{
                background-color: #34282C ;
                font-size: 15px;
                color: white ;
                padding: 15px ;
                border: none ;
                cursor: pointer ;
                width: 35% ;
                border-radius: 10px;
                margin: auto;
            }
            
            button:hover{
                background: #757575;
            }
        </style>
    </head>
    
    <body>
        <%
            session.invalidate();
        %>
        <div class="bg-img " >
            <div class="container">
                
                <img src="logo_trans.png">
                <h2>&#128230; E-PARCEL UMT &#128230;</h2>
                <h3>You're Out<br>Bye-bye &#128075;</h3><br>
                
                <a href="login.jsp"><button>Login</button></a>
            </div>
        </div>
    </body>
</html>