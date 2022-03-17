<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script type="text/javascript">
            $(document).ready(function()
            {
                $("#userbtn").click(function()
                {
                    $.get("UserLogin.jsp",function(data,status)
                    {
                    	alert("Testing....");
                        $("#loginpanel").html(data);
                    });
                    
                });
            });
        </script>
        <style>
            body
            {
                background-image: url("112346083.jpg");
                background-size: 1280px 900px;
            }
            .navbar
            {
                display: inline-block;
                margin-left: auto;
                margin-right: auto;
                width: 90%;
            }
            .left
            {
                display: inline-block;
                width: 50%;
            }
            #loginpanel
            {
                
            }
        </style>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

</head>
<body>
<header>
            <div class="navbar">
                <div class="left">
                    <img src="EDUCATIOUS-removebg-preview-removebg-preview.png" width="40%" height="40%">
                </div>
            </div>
        </header>
        <div class="container-fluid">
            <div class="row">
            <div class="col-md-2"></div>
            <div class="col-md-4">
                <br>
                <div class="container py-5 h-100">
                    <div class="card bg-success text-white" style="border-radius: 1rem;">
                      <div class="card-body p-5">
            
                        <div class="mb-md-2">
                          <button class="btn btn-outline-light btn-lg px-5 pb-3 pt-3" id="userbtn">&nbsp;User&nbsp;&nbsp;</button>
                          &nbsp;&nbsp;&nbsp;
                          <img src="pngfind.com-copyright-png-938050.png" width="60px" height="60px">
                        </div>
                        <br><br>
                        <div class="mb-md-2">
                            <button class="btn btn-outline-light btn-lg px-5 pb-3 pt-3" id="adminbtn">Admin</button>
                            &nbsp;&nbsp;&nbsp;
                            <img src="PinClipart.com_wet-weather-clipart_1221261.png" width="60px" height="60px">
                          </div>
                        <br><br>
                        <div class="mb-md-2">
                            <button class="btn btn-outline-light btn-lg px-4 pb-3 pt-3" id="superbtn">Super User</button>
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <img src="557-5576207_chanuka-clip-art.png" width="60px" height="60px">
                          </div>
                      </div>
                      </div>
                    </div>
              </div>
            <div class="col-md-5" id="loginpanel">
                    
            </div>
            <div class="col-md-1"></div>
            </div>
        </div>
</body>
</html>