<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HomePage</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" 
    integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<style type="text/css">
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
        body{
			background-image: url("https://img.freepik.com/free-vector/concept-new-team-member_132971-312.jpg?size=626&ext=jpg");
			background-repeat: no-repeat;        
			padding: 200px;
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
           <li class="nav-item"><a class="nav-link" href="taskpage" id="navigation">Tasks</a></li>
               <li class="nav-item"><a class="nav-link" href="#AboutUs" id="navigation">AboutUs</a></li>
           </ul>
       </div>
   </nav>
   <section class="vh=100">
   <div class="container" style="color: black;padding-top: 200px;font-weight: bold">
   		Welcome Home Admin!
   </div>
   </section>
</body>
</html>

