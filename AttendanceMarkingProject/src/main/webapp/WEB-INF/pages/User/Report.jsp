<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Sessions</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
     rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
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
           <ul class="navbar-nav" style="margin-left: auto;">
            <li class="nav-item"><a class="nav-link" href="userhome" id="navigation"><i class="fa-solid fa-house"></i>&nbsp;&nbsp;Home</a></li>
            <li class="nav-item" ><a class="nav-link" href="login" id="navigation" onclick="window.location.reload()" style="padding-left: 30px"><i class="fa-solid fa-arrow-right-from-bracket"></i>&nbsp;&nbsp;LogOut</a></li> 
           </ul>
        </div>
    </nav>
<section class="vh-100">
        <div class="container h-100" style="padding-top: 70px">
          <div class="row d-flex justify-content-center align-items-center h-100" > 
            <div class="col-lg-12 col-xl-11" >
            
              <div class="card text-black" style="border-radius: 25px;box-shadow: inset 2px 2px 4px #d1d9e6,
              inset -2px -2px 4px #f9f9f9;">
              
              <div class="card-header h1 fw-bold mb-5 mx-1 mx-md-4 mt-4" style=" border-top-left-radius: 25px;border-top-right-radius: 25px;">Sessions</div>
              
                <div class="card-body p-md-7" >
                	<div class="table-responsive">
          <table class="table table-striped" style="width:1150px">
            <tbody><tr class="table-dark">
              <th>Session Id</th>
              <th>Session Name</th>
              <th>Skillset</th>
              <th>Date</th>
              <th>Time</th>
            </tr>
            <c:forEach var="usr" items="${slist }">
            <tr>
              	
              	<td style="height:55px" class="align-middle">${usr.sessionId}</td>
              	
              	<td style="height:55px" class="align-middle">${usr.sessionDes}</td>
              
	            <td style="height:55px" class="align-middle">${usr.skillSet}</td>
              	
              	<td style="height:55px" class="align-middle">${usr.sessionDate}</td> 
              	
              	<td style="height:55px" class="align-middle">${usr.sessionTime}</td>
            </tr>
            </c:forEach>
          </tbody>
          </table>
        </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </section>
</body>
</html>