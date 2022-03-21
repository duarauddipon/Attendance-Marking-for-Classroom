<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ page isELIgnored="false" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Available Session</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css" 
integrity="sha256-mmgLkCYLUQbXn0B1SRqzHar6dCnv9oZFPEC1g1cwlkk=" crossorigin="anonymous" />
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" 
integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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
            <li class="nav-item"><a class="nav-link" href="showAllSessions" id="navigation">Available Sessions</a></li>
                <li class="nav-item"><a class="nav-link" href="#AboutUs" id="navigation">AboutUs</a></li>
                <li class="nav-item"><a class="nav-link" href="#ContactUs" id="navigation">ContactUs</a></li>
            </ul>
        </div>
    </nav>
<div class="row">
        <div class=" col-lg-6 col-xl-5">
            <div class="table-responsive" style="padding: 40px;padding-top: 250px;">
                <table class="table table-striped">
                  <tbody><tr>
                    <th>Session Id</th>
                    <th>Session Description</th>
                  </tr>
                  <c:forEach var="sess" items="${slist }">
                  <form name="frm" method="post" action="showAllSessions">
                  <tr>
                       <td style="text-decoration: none;cursor: pointer;"><a href="sessionDetails/${sess.sessionId }"  style="text-decoration: none;color: black;">${sess.sessionId }</a></td>
                        <td>${sess.sessionDes }</td>
                  </tr>
                  </form>
                  </c:forEach>
                </tbody>
                </table>
                <p>Click Session Id to view sessions Details and to enroll</p>
              </div>
        </div>
        <div class=" col-lg-6 col-xl-5">
            <div class="table-responsive" style="padding: 40px;padding-top: 250px;">
                <table class="table table-striped">
                  <tbody><tr>
                    <th>Session Id</th>
                    <th>Session Description</th>
                    <th>SkillSet</th>
                    <th>SessionDate</th>
                    <th>SessionTime</th>
                    <th>Available Slots</th>
                  </tr>
                  <tr>
                      <td>${dlist.sessionId}</td>
                      <td>${dlist.sessionDes}</td>
                      <td>${dlist.skillSet}</td>
                      <td>${dlist.sessionDate}</td>
                      <td>${dlist.sessionTime}</td>
                      <td>${dlist.availSlots }</td>
                  </tr>
                </tbody>
                </table>
                <div style="padding-left: 25px;padding-top: 10px"><input type="submit" class="btn btn-primary" value="Enroll"></div>
        </div>
    </div> 
    </div>
</body>
</html>