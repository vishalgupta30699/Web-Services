<!DOCTYPE html>
<html lang="en">
<head> 
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" /><meta name="description" content="" />
<meta name="author" content="" />
<title>PSH Service</title>
<link href="css/styles.css" rel="stylesheet" />
<script src="js/all.min.js" crossorigin="anonymous"></script>
</head>
<body class="bg-primary">
<div id="layoutAuthentication">
<div id="layoutAuthentication_content">
<main><div class="container">
<div class="row justify-content-center">
<div class="col-lg-5">
<div class="card shadow-lg border-0 rounded-lg mt-5">
<div class="card-header"><h3 class="text-center font-weight-light my-4">Login</h3></div>
<div class="card-body">
<form action="login" method="POST">
<span>${registrationError.userName}</span>
<div class="form-group"><label class="small mb-1" for="inputUserName">User Name</label><input class="form-control py-4" id="inputUserName" name="userName" type="text" placeholder="Enter user name" /></div>
<div class="form-group"><label class="small mb-1" for="inputPassword">Password</label><input class="form-control py-4" id="inputPassword" type="password" name="password" placeholder="Enter password" /></div>
<div class="form-group">
<div class="custom-control custom-checkbox"><input class="custom-control-input" id="rememberPasswordCheck" type="checkbox" /><label class="custom-control-label" for="rememberPasswordCheck">Remember password</label></div>
</div>
<div class="form-group d-flex align-items-center justify-content-between mt-4 mb-0"><a class="small" href="password.html">Forgot Password?</a><button type="submit" class="btn btn-primary">Login</button></div>
</form>
</div>
<div class="card-footer text-center">
<div class="small"><a href="register.jsp">Need an account? Sign up!</a></div>
</div>
</div>
</div>
</div>
</div>
</main>
</div>
</div>
<script src="jquery-3.4.1/jquery-3.4.1.min.js" crossorigin="anonymous"></script>
<script src="bootstrap-4.3.1/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
<script src="js/scripts.js"></script>
</body>
</html>
