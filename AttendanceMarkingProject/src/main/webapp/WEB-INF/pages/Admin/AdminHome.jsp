<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Home</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
     rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<link href="https://fonts.googleapis.com/css?family=Alegreya+Sans:300,400,700" rel="stylesheet">
<!-- Font Script -->
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
    .responsive{
    	width: 100%;
    	max-width: 400px;
    	height: auto;
    }
</style>

</head>
<body>
    <nav class="navbar navbar-expand-lg fixed-top">
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navigation-bar">
            <span class="navbar-toggler-icon">&#9776;</span>
        </button>
        &nbsp;&nbsp;&nbsp;<a class="navbar-brand" href="#" style="border-radius: 25px; margin-left: "><img src="https://i.pinimg.com/564x/61/6f/90/616f900fb165b3a61464d56a87f4d824.jpg" height="100" width="200" class="img-fluid" style="border-radius: 25px;"></a>
        <div class="collapse navbar-collapse" id="navigation-bar">
            <ul class="navbar-nav" style="margin-left: auto;">
          	<li class="nav-item"><a class="nav-link" href="updatequestion" id="navigation"><i class="fa-solid fa-wrench"></i>&nbsp;&nbsp;Update Questions </a></li>
                <li class="nav-item" ><a class="nav-link" href="trainerreg" id="navigation"><i class="fa-solid fa-user-plus"></i>&nbsp;&nbsp;Add Trainer</a></li>
                <li class="nav-item" ><a class="nav-link" href="sessionadd" id="navigation"><i class="fa-solid fa-file-circle-plus"></i>&nbsp;&nbsp;Add Session</a></li>
                <li class="nav-item" ><a class="nav-link" href="updateses" id="navigation"><i class="fa-solid fa-pen-to-square"></i>&nbsp;&nbsp;Update Session</a></li>
                <li class="nav-item" ><a class="nav-link" href="skilladd" id="navigation"><i class="fa-solid fa-plus"></i>&nbsp;&nbsp;Add Skill</a></li>
                <li class="nav-item" ><a class="nav-link" href="updatetrainer" id="navigation"><i class="fa-solid fa-pen-to-square"></i>&nbsp;&nbsp;Update Trainer</a></li>
                <li class="nav-item" ><a class="nav-link" href="deletetrainer" id="navigation"><i class="fa-solid fa-trash"></i>&nbsp;&nbsp;Delete Trainer</a></li>
                <li class="nav-item" ><a class="nav-link" href="login" id="navigation" onclick="window.location.reload()"><i class="fa-solid fa-arrow-right-from-bracket"></i>&nbsp;&nbsp;LogOut</a></li> 
            </ul>
        </div>
    </nav>
	<section class="vh-100">
        <div class="container h-100" style="padding-top: 70px">
          <div class="row d-flex justify-content-center align-items-center h-100" > 
            <div class="col-lg-12 col-xl-11" >
              <br><br>            
              <div class="card text-black" style="border-radius: 25px;box-shadow: inset 2px 2px 4px #d1d9e6,
              inset -2px -2px 4px #f9f9f9;">

              <div class="card-header h1 fw-bold mb-5 mx-1 mx-md-4 mt-4" style=" border-top-left-radius: 25px;border-top-right-radius: 25px;">Welcome Home!</div>
              
                <div class="card-body" >
                  <div class="row justify-content-center">
                    <div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">
      					<!-- Inbox  -->
                        <div class="d-flex flex-row align-items-center mt-5">
                          	<a role="button" href="adminnotification" class="btn btn-primary btn-lg position-relative" style="margin-left:30px">
							                Notifications 
							                <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">${notif }<span class="visually-hidden">unread messages</span>
							                </span>
							              </a>	
                        </div>
                        <div class="d-flex flex-row align-items-center mt-5">
                          	<a class="btn btn-success btn-lg" href="feedbackreport" role="button" style="margin-left:30px">Reports</a>	
                        </div>           
                    </div>
                    <div class="col-md-10 col-lg-6 col-xl-7 d-flex order-1 order-lg-2">
                      <img src="./images/admin.png" style="width:80%" class="img-fluid" alt="Sample image">
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