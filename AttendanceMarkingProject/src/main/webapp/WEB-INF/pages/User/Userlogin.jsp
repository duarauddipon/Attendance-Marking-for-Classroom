<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Login</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
     rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    
    	<link href="https://fonts.googleapis.com/css?family=Alegreya+Sans:300,400,700" rel="stylesheet">
    
    	<script src="https://kit.fontawesome.com/9ca98498b5.js" crossorigin="anonymous"></script>
<style>
      #navigation{
        color: black;
        text-align: center;
        border-radius: 25px;
    }
    .navbar{
        background-color: rgb(215, 226, 235);
        font-family: 'Alegreya Sans',sans-serif;
        font-weight: bold;
        border-bottom-left-radius: 25px;
        border-bottom-right-radius: 25px;
    }
</style>
</head>
<body>
   <nav class="navbar navbar-expand-lg fixed-top">
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navigation-bar">
            <span class="navbar-toggler-icon">&#9776;</span>
        </button>
        &nbsp;&nbsp;&nbsp;<a class="navbar-brand" href="#" style="border-radius: 25px; margin-left: ">
        <img src="https://i.pinimg.com/564x/61/6f/90/616f900fb165b3a61464d56a87f4d824.jpg" height="100" width="200" class="img-fluid" style="border-radius: 25px;"></a>
        <div class="collapse navbar-collapse" id="navigation-bar">
            <ul class="navbar-nav" style="margin-left: auto;margin-right:10px">
	         	<li class="nav-item"><a class="nav-link" href="login" id="navigation"><i class="fa-solid fa-house"></i>&nbsp;&nbsp;Home</a></li>
	            <li class="nav-item"><a class="nav-link" href="#AboutUs" id="navigation"><i class="fa-solid fa-circle-info"></i>&nbsp;&nbsp;AboutUs</a></li>
	            <li class="nav-item"><a class="nav-link" href="#ContactUs" id="navigation"><i class="fa-duotone fa-at"></i>&nbsp;&nbsp;ContactUs</a></li>
            </ul>
        </div>
    </nav>
	 <section class="vh-100">
        <div class="container h-100">
          <div class="row d-flex justify-content-center align-items-center h-100" > 
            <div class="col-lg-12 col-xl-11" >
            <br>
              <div class="card text-black" style="border-radius: 25px;box-shadow: inset 2px 2px 4px #d1d9e6,
              inset -2px -2px 4px #f9f9f9;">
              
              <div class="card-header h1 fw-bold mx-1 mx-md-4 mt-4" style=" border-top-left-radius: 25px;border-top-right-radius: 25px;">User Login</div>
              
                <div class="card-body p-md-5" >
                  <div class="row justify-content-center">
                    <div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">
                      <form class="mx-1 mx-md-4" name="form1" method="post" action="userloginprocess">
      					
      					<!-- User Id -->
                        <div class="d-flex flex-row align-items-center mb-4">
                          <i class="fas fa-lock fa-lg me-3 fa-fw"></i>
                          <div class="form-outline flex-fill mb-0">
                            <label class="form-label" for="form3Example4c">User Id</label>
                            <input type="number" id="userid" name="userid" class="form-control" placeholder="Id" />
                          </div>
                        </div>             
                             
                         <!-- Password -->
                        <div class="d-flex flex-row align-items-center mb-4">
                          <i class="fas fa-key fa-lg me-3 fa-fw"></i>
                          <div class="form-outline flex-fill mb-0">
                            <label class="form-label" for="form3Example4c">Password</label>
                            <input type="password" id="password" name="password" class="form-control" placeholder="Password"/>
                          </div>
                        </div>      
                        <div class="d-flex justify-co ntent-center mx-4 mb-3 mb-lg-4">
                          	
                          	<!-- Submit -->
                           <input type="submit" id="loginuser" value="Login" class="btn btn-primary" />
                        </div>
                         <div class="d-flex justify-co ntent-center mx-4 mb-3 mb-lg-4">
                           <p>Forgot Password ? <a href="userresetpassword" style="text-decoration:none;cursor: pointer;">Reset here!</a></p>
                    </div>
                      </form>
                      <div>Don't have an account? <a href="Userreg" class="btn btn-primary"> Register!</a>
                      </div>
      				<br>
      				<br>
      				<h3 style="font-style:italic;color:red" class="">${msg}</h3>
                    </div>
                    <br>
                    <br>
                    <div class="col-md-10 col-lg-6 col-xl-7 d-flex align-items-center order-1 order-lg-2">
                      <img src="https://cdni.iconscout.com/illustration/premium/thumb/account-log-in-4268411-3551758.png" style="border-radius: 25px;" class="img-fluid" alt="Sample image">
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </section>
            <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" 
          integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script> 
</body>
</html>