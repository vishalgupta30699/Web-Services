<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>PSH Service</title>
<link href="css/styles.css" rel="stylesheet" />
<script src="js/all.min.js" crossorigin="anonymous"></script>
<script>
function refresh()
{
var el=document.getElementById('CaptchaCode');
el.setAttribute('src','');
var today = new Date();
var date = today.getFullYear()+'-'+(today.getMonth()+1)+'-'+today.getDate();
var time = today.getHours() + ":" + today.getMinutes() + ":" + today.getSeconds();
var dateTime = date+' '+time;
el.setAttribute('src','/service/CaptchaCode');
}

</script>
</head>
<body class="bg-primary">
<div id="layoutAuthentication">
<div id="layoutAuthentication_content">
<main>
<div class="container">
<div class="row justify-content-center">
<div class="col-lg-7">
<div class="card shadow-lg border-0 rounded-lg mt-5">
<div c-lass="card-header"><h3 class="text-center font-weight-light my-4">Create Account</h3></div>
<div class="card-body">
<form action='register' method='POST'>

<div class="form-group"><label class="small mb-1" for="inputUserName">User Name</label><input class="form-control py-4" id="userName" type="text" name="userName" value="${userBean.userName}" placeholder="Enter user name" required /><span style="color:red">${registrationError.userName}</span></div>



<div class="form-group"><label class="small mb-1" for="inputEmailAddress">Email</label><input class="form-control py-4" id="emailId" type="email" name="emailId" value="${userBean.emailId}" aria-describedby="emailHelp" placeholder="Enter email address" required /><span style="color:red" color='red'>${registrationError.emailId}</span></div>

<div class="form-row">
<div class="col-md-6">
<div class="form-group"><label class="small mb-1" for="password">Password</label><input class="form-control py-4" id="inputPassword" name="password" type="password" placeholder="Enter password" required /></div>
</div>
<div class="col-md-6">
<div class="form-group"><label class="small mb-1" for="rpassword">Confirm Password</label><input class="form-control py-4" id="inputConfirmPassword" name="rpassword"  type="password" placeholder="Confirm password" required /></div>
</div>
</div>
<span style="color:red">${registrationError.password}</span>

<div class="form-row">
<div class="col-md-6">
<div class="form-group"><label class="small mb-1" for="captcha">Captcha</label>
<input class="form-control py-4" id="inputCaptcha" name="captcha"  type="text" required /></div>
</div>
<div class="col-md-6">
<div class="form-group"><label class="small mb-1" for="captcha">&nbsp;</label>
<img  class=" py-4" src='CaptchaCode' id='CaptchaCode' >
<img src='img/refresh.png' height="20px" width="20px" onclick='refresh()' ></div>
</div>
</div>
<span style="color:red">${registrationError.captchaCode}</span>
<div class="form-group mt-4 mb-0"><center><button type="submit">Create Account</button></center></div>
</form>
</div>
<div class="card-footer text-center">
<div class="small"><a href="index.jsp">Have an account? Go to login</a></div>
</div>
</div>
</div>
</div>
</div>
</main>
</div>
<div id="layoutAuthentication_footer">
<footer class="py-4 bg-light mt-auto">
<div class="container-fluid">
<div class="d-flex align-items-center justify-content-between small">
<div class="text-muted">Copyright &copy; Your Website 2019</div>
<div>
<a href="#">Privacy Policy</a>
&middot;
<a href="#">Terms &amp; Conditions</a>
</div>
</div>
</div>
</footer>
</div>
<script src="jquery-3.4.1/jquery-3.4.1.min.js" crossorigin="anonymous"></script>
<script src="bootstrap-4.3.1/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
<script src="js/scripts.js"></script>
</body>
</html>