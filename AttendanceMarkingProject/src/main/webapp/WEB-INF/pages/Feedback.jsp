<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
    <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Feedback</title>
 <link href="CSS/admin.css" rel="stylesheet">
 
 
<style>

.cls2{
	margin-top:10px;
	margin-left:auto;
	margin-right:auto;
}



</style>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">


</head>
<body style="background-image: url(Images/vector-AUG-2020-98_generated.jpg)">

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>




<div class="container-fluid" style="margin-top:90px">
        <div class="row">
            <div class="col-md-3"></div>
            <div class="col-md-6">

			<form name="form5" method="post" action="resp">
                <div class="card">
                    <div class="card-header">
                        FeedBack form <br>
                        Please Enter the Following Details.
                    </div>
                    <div class="card-body">
                    <c:forEach var="lls" items="${qwlist}">
                      	
                      	 <label for="forUser" class="form-label" value="${dls.queSa}">${lls.queSa}</label>
                      </c:forEach>
                       
                        <input type="text" id="ansa" name="ansa" class="form-control" placeholder="We value your opinion!!">
                    <c:forEach var="lls" items="${polist}">
                      	
                      	 <label for="forUser" class="form-label" value="${dls.queSb}">${lls.queSb}</label>
                      </c:forEach>    
                        <input type="text" id="ansb" name="ansb" class="form-control" placeholder="We value your opinion!!">
                          <c:forEach var="lls" items="${polist}">
                      	
                      	 <label for="forUser" class="form-label" value="${dls.queSc}">${lls.queSc}</label>
                      </c:forEach>
                          <select class="form-control" name="review" id="review">
                      <option value="yes" id="yes" label="Yes"></option>
                      <option value="no" id="no" label="No"></option>
                      <option value="maybe" id="maybe" label="Maybe"></option>
                      
            </select>
              <c:forEach var="lls" items="${polist}">
                      	
                      	 <label for="forUser" class="form-label" value="${dls.queSd}">${lls.queSd}</label>
                      </c:forEach>
                          <select class="form-control" name="rating" id="rating">
                      <option value="poor" id="poor" label="Poor"></option>
                      <option value="satisfactory" id="Satisfactory" label="Satisfactory"></option>
                      <option value="good" id="good" label="Good"></option>
                      <option value="excellent" id="excellent" label="Excellent"></option>
                      
            </select>
            
             <label for="forUser" class="form-label">Session ID</label>
                        
                      <select class="form-control" name="sessionid" id="sessionid">
                      <option Selected>Select ID</option>
                      <c:forEach var="dls" items="${salist}">
                      	<option value="${dls.sessionId}">${dls.sessionDes}</option>
                      </c:forEach>
                      
            
            
             </select>
                        <h3 style="font-style:italic;color:red" class="">${msg}</h3>
                   
                        <div class="row">
                            <div class="col-md-12" style="text-align: center;">
                                <input type="submit"  value="Submit" class="btn btn-primary" />
                                
                            </div>
                        </div>
                    </div>
                </div>

               
                </form>

            </div>
            <div class="col-md-3"></div>
        </div>
    </div>




</body>
</html>