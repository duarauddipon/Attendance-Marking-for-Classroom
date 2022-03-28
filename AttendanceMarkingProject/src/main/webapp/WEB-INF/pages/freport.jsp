<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
    <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" 
integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</head>
<body>
<div class="container-fluid" style="margin-top:100px">
<div class="row">
<div class="col-md-1"></div>
            <div class="col-md-10">
<table class="table table-striped table-hover table-bordered">
  <thead class="bg-warning">
    <tr>
      <th scope="col">S.No</th>
      <th scope="col">Answer 1</th>
      <th scope="col">Answer 2</th>
      <th scope="col">Answer 3</th>
      <th scope="col">Answer 4[Rating]</th>
      <th scope="col">Session ID</th>
      
    </tr>
  </thead>
  <tbody>
   
  <c:forEach var="cls" items="${rlist}">
    <tr>
      
      <td>${cls.aId}</td>
      <td>${cls.anSa}</td>
       <td>${cls.anSb}</td>
        <td>${cls.anSc}</td>
         <td>${cls.anSd}</td>
          <td>${cls.sessionId}</td>
      
    </tr>
    
    </c:forEach>
    
  </tbody>
</table>

</div>
            <div class="col-md-1"></div>
</div>

</div>


</body>
</html>