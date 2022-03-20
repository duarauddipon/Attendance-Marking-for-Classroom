<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page isELIgnored="false" %>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add new Skill!!</title>
<link rel='stylesheet' type='text/css' media='screen' href='main.css'>
    <script src='main.js'></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
     rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
     <style>
         body{
             background-color: #ecf0f3;
             backdrop-filter: saturate(180%) blur(10px);
             font-family: Arial, Helvetica, sans-serif;
         }
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
        &nbsp;&nbsp;&nbsp;<a class="navbar-brand" href="#" style="border-radius: 25px; margin-left: "><img src="https://i.pinimg.com/564x/61/6f/90/616f900fb165b3a61464d56a87f4d824.jpg" height="150" width="300" class="img-fluid" style="border-radius: 25px;"></a>
        <div class="collapse navbar-collapse" id="navigation-bar">
            <ul class="navbar-nav" style="margin-left: auto;">
            	<li class="nav-item"><a class="nav-link" href="adminhome" id="navigation">Admin Homer</a></li>
                <li class="nav-item"><a class="nav-link" href="trainerreg" id="navigation">Add Trainer</a></li>
                <li class="nav-item"><a class="nav-link" href="sessionadd" id="navigation">Add Session</a></li>
                <li class="nav-item"><a class="nav-link" href="skilladd" id="navigation">Add Skill</a></li>
                <li class="nav-item"><a class="nav-link" href="#updatetrainer" id="navigation">Update Trainer</a></li>
                <li class="nav-item"><a class="nav-link" href="#Deletetrainer" id="navigation">Delete Trainer</a></li>
            </ul>
        </div>
    </nav>

    <section class="vh-100">
        <div class="container h-100">
          <div class="row d-flex justify-content-center align-items-center h-100" > 
            <div class="col-lg-12 col-xl-11" >
              <div class="card text-black" style="border-radius: 25px;box-shadow: inset 2px 2px 4px #d1d9e6,
              inset -2px -2px 4px #f9f9f9;">
              <div class="card-header h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">Add a new Skill</div>
                <div class="card-body p-md-5" >
                  <div class="row justify-content-center">
                    <div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">
      
                      
      
                      <form class="mx-1 mx-md-4" name="form1" method="post" action="addSk">
      					
      					<!-- Skill Id -->
                        <div class="d-flex flex-row align-items-center mb-4">
                          <i class="fas fa-lock fa-lg me-3 fa-fw"></i>
                          <div class="form-outline flex-fill mb-0">
                            <label class="form-label" for="form3Example4c">Skill ID</label>
                            <input type="text" id="form3Example4c" id="skillId" name="skillId" class="form-control" placeholder="Skill ID" />
                          </div>
                        </div>                  
      
      					<!-- Skill Type -->
                        <div class="d-flex flex-row align-items-center mb-4">
                          <i class="fas fa-lock fa-lg me-3 fa-fw"></i>
                          <div class="form-outline flex-fill mb-0">
                            <label class="form-label" for="form3Example4c">Skill Type</label>
                            <input type="text" id="form3Example4c" id="skillType" name="skillType" class="form-control" placeholder="Skill Type"/>
                          </div>
                        </div>
      					
      					<!-- Add Description -->
                        <div class="d-flex flex-row align-items-center mb-4">
                          <i class="fas fa-key fa-lg me-3 fa-fw"></i>
                          <div class="form-outline flex-fill mb-0">
                            <label class="form-label" for="form3Example4cd">Add Description</label>
                            <input type="text" id="form3Example4cd" id="skillDesc" name="skillDesc" class="form-control" placeholder="Description"/>
                          </div>
                        </div>
      
                      
      
                        <div class="d-flex justify-co ntent-center mx-4 mb-3 mb-lg-4">
                          
                          <!-- Submit -->
                           <input type="submit"  value="Add Skill" class="btn btn-primary" />
                        </div>
       						<h3 style="font-family: sans-serif;color: black;font-size: 20px" class="" >${msg}</h3>
                      </form>
      
                    </div>
                    <div class="col-md-10 col-lg-6 col-xl-7 d-flex align-items-center order-1 order-lg-2">
      
                      <img src="https://assets.justinmind.com/wp-content/uploads/2019/04/top-skills-for-UX-designers-collaboration.png" style="border-radius: 25px;" class="img-fluid" alt="Sample image">
      
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </section>
</body>
</html>