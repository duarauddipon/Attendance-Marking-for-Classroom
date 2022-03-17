<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Page Title</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link rel='stylesheet' type='text/css' media='screen' href='main.css'>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" 
    integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script type="text/javascript">
    	$(document).ready(function(){
    		$("#btn1").mouseenter(function(){
    			$("#img1").hide();
    			$("#img3").hide();
    			$("#img2").fadeIn(300);
    		});
    		$("#btn2,#btn4").mouseenter(function(){
    			$("#img2").hide();
    			$("#img3").hide();
    			$("#img1").fadeIn(300);
    		});
    		$("#btn3,#btn5").mouseenter(function(){
    			$("#img1").hide();
    			$("#img2").hide();
    			$("#img3").fadeIn(300);
    		});
    	});
    </script>
    <script src='main.js'></script>
    
    <style>
        .divider:after,
        .divider:before {
        content: "";
        flex: 1;
        height: 1px;
        background: #eee;
        }
        .h-custom {
        height: calc(100% - 73px);
        }
        @media (max-width: 450px) {
        .h-custom {
            height: 100%;
        }
        }
    </style>
</head>
<body>
    <section class="vh-100">
        <div class="container-fluid h-custom">
          <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-md-9 col-lg-6 col-xl-5">
              <img src="https://media.licdn.com/media//AAYQAgSrAAgAAQAAAAAAADCLr3coQt8AQiyj4giyWxfjsg.svg" class="img-fluid"
                alt="Sample image" id="img1">
                <img src="https://i.pinimg.com/564x/64/b6/63/64b663713de1cf9327be55e7aa4f92aa.jpg" class="img-fluid"
                alt="Sample image" style="display:none" id="img2">
                <img src="https://i.pinimg.com/564x/e6/0b/0c/e60b0cedbf8e454232b313c35a2fe398.jpg" class="img-fluid"
                alt="Sample image" style="display:none" id="img3">
            </div>
            <div class="col-md-8 col-lg-6 col-xl-4 offset-xl-1">
              <form>
                <div class="d-flex flex-row align-items-center justify-content-center justify-content-lg-start">
                  <p class="lead fw-normal mb-0 me-3">Sign in as</p>
                  
                  <a class="btn btn-primary" href="#" role="button" id="btn1">Super User</a>
      				&nbsp;&nbsp;
                  <a class="btn btn-primary" href="#" role="button" id="btn2">User</a>
      				&nbsp;&nbsp;
                  <a class="btn btn-primary" href="#" role="button" id="btn3">Admin</a>
                  
                </div>
      
                <div class="divider d-flex align-items-center my-4">
                  <p class="text-center fw-bold mx-3 mb-0">Or</p>
                </div>
                <div class="d-flex flex-row align-items-center justify-content-center justify-content-lg-start">
                    <p class="lead fw-normal mb-0 me-3">Register for</p>
        			&nbsp;&nbsp;&nbsp;
        			
                    <a class="btn btn-warning" href="#" role="button" id="btn4">User</a>
        				&nbsp;&nbsp;
                    <a class="btn btn-warning" href="#" role="button" id="btn5">Admin</a>
                    
                  </div>
              </form>
            </div>
          </div>
        </div>
      </section>
</body>
</html>