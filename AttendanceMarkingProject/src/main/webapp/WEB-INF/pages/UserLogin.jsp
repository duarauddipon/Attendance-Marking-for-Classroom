<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<div class="container py-5 h-100">
        <div class="card bg-success text-white" style="border-radius: 1rem;">
          <div class="card-body p-5 text-center">

            <div class="mb-md-2">

              <h2 class="fw-bold mb-2">User Login</h2>
              <br>
              <div class="form-outline form-white mb-4">
                <input type="email" id="email" name="email" class="form-control form-control-md" placeholder="Email"/>
              </div>

              <div class="form-outline form-white mb-4">
                <input type="password" id="password" name="password" class="form-control form-control-md" placeholder="Password" />
              </div>

              <p class="small mb-5 pb-lg-2"><a class="text-white-50" href="#!">Forgot password?</a></p>

              <button class="btn btn-outline-light btn-lg px-5" type="submit">Login</button>
            </div>
            <br>
            <div>
              <p class="mb-0">Don't have an account? <a href="userregister" class="text-white-50 fw-bold">Sign Up</a></p>
            </div>

          </div>
        </div>
  </div>
</body>
</html>