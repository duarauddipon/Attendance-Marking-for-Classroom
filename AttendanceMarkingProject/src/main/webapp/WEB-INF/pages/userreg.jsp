<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Registration</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
     rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<section class="vh-100">
        <div class="container h-100">
          <div class="row d-flex justify-content-center align-items-center h-100" > 
            <div class="col-lg-12 col-xl-11" >
            
              <div class="card text-black" style="border-radius: 25px;box-shadow: inset 2px 2px 4px #d1d9e6,
              inset -2px -2px 4px #f9f9f9;">
              
              <div class="card-header h1 fw-bold mb-5 mx-1 mx-md-4 mt-4" style=" border-top-left-radius: 25px;border-top-right-radius: 25px;">User Registration</div>
                <div class="card-body p-md-5" >
                  <div class="row justify-content-center">
                    <div class="col-md-10 col-lg-4 col-xl-5 order-2 order-lg-1">
      
                      <form class="mx-1 mx-md-4" name="form1" method="post" action="">
      
      					<%--Firstname Field--%>
                        <div class="d-flex flex-row align-items-center mb-4">
                          <i class="fas fa-lock fa-lg me-3 fa-fw"></i>
                          <div class="form-outline flex-fill mb-0">
                            <label class="form-label" for="form3Example4c">First Name</label>
                            <input type="text" id="firstname" name="firstname" class="form-control" placeholder="Ex.Jhon" required/>
                          </div>
                        </div>                  
      
      					<%--Lastname Field--%>
                        <div class="d-flex flex-row align-items-center mb-4">
                          <i class="fas fa-lock fa-lg me-3 fa-fw"></i>
                          <div class="form-outline flex-fill mb-0">
                            <label class="form-label" for="form3Example4c">Last Name</label>
                            <input type="text" id="lastname" name="lastname" class="form-control" placeholder="Ex.Miller" required/>
                          </div>
                        </div>
      					
      					<%--Email Id  Field--%>
                        <div class="d-flex flex-row align-items-center mb-4">
                          <i class="fas fa-key fa-lg me-3 fa-fw"></i>
                          <div class="form-outline flex-fill mb-0">
                            <label class="form-label" for="form3Example4cd">Email Id</label>
                            <input type="email" id="email" name="email" class="form-control" 
                             placeholder="Ex.miller@gmail.com" required/>
                          </div>
                        </div>
                        
                        
                        <%-- Password Field--%>
                        <div class="d-flex flex-row align-items-center mb-4">
                          <i class="fas fa-key fa-lg me-3 fa-fw"></i>
                          <div class="form-outline flex-fill mb-0">
                            <label class="form-label" for="form3Example4cd">Password</label>
                            <input type="password" id="password" name="password" class="form-control" placeholder="Password" required/>
                          </div>
                        </div>            
                        
                        <%--Register Button--%>          
                        <div class="d-flex justify-co ntent-center mx-4 mb-3 mb-lg-4">
                           <input type="submit"  value="Register" class="btn btn-primary" />
                        </div>
                        
                        <%--Login Button--%>
                        <div>
							  Already have an account? <a href="Userlogin" class="btn btn-primary"> Login!</a>
                        </div>
       						<h3 style="font-style:italic;color:red" class="">${msg}</h3>
                      </form>
                    </div>
                    <div class="col-md-10 col-lg-6 col-xl-7 d-flex align-items-center order-1 order-lg-2">
      
                      <img src="https://cdni.iconscout.com/illustration/premium/thumb/account-sign-up-4489354-3723262.png" 
                      style="border-radius: 25px;" class="img-fluid" alt="Sample image">
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

