<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="vendor/jquery-easing/jquery.easing.min.js"></script>
  <script src="js/sb-admin-2.min.js"></script>
<script>
	var myURL;
         function validateURL(myURL) {
            var pattern = new RegExp('^(https?:\\/\\/)?'+ // protocol
            '((([a-z\\d]([a-z\\d-]*[a-z\\d])*)\\.?)+[a-z]{2,}|'+ // domain name
            '((\\d{1,3}\\.){3}\\d{1,3}))'+ // ip (v4) address
            '(\\:\\d+)?(\\/[-a-z\\d%_.~+]*)*'+ //port
            '(\\?[;&amp;a-z\\d%_.~+=-]*)?'+ // query string
            '(\\#[-a-z\\d_]*)?$','i');
            return pattern.test(myURL);
         }

function Webtopdf()
{
var pdfurl=$("#web-to-pdf-url").val();
if(!validateURL(pdfurl))
{
$("#web-to-pdf-incorrect-url-warning").show();
return false;
}
$("#pdf").hide();
$("#web-to-pdf-incorrect-url-warning").hide();
$("#web2pdf-error").hide();
$("#pdf").hide();
$("#web2pdf-window").modal({keyboard:false,backdrop:'static'});
$("#div2").hide();
document.getElementById("loader").style.display="block";
$.ajax({
url: "convertToPdf", 
method:"POST",
data:{
PDFURL:pdfurl
},
success: function(result){
document.getElementById("loader").style.display="none";
$("#div2").show();
$("#div2").html(result);
},
error:function(result)
{
$("#web-to-pdf-incorrect-url-warning").show();
}
});
}
</script>
</head>
	<body>
	<div class="well converter-box">
		<h1 class="converter-title"><img src="img/web-to-pdf.png" style="width:87px; height:24px" alt="">&nbsp;&nbsp; Convert Web to PDF</h1>
		<div class="alert alert-error" id="web-to-pdf-incorrect-url-warning" style="display: none">You have entered an incorrect URL</div>
		<b>Enter the URL below:</b>
		<br />
		<input type="text" style="width: 703px" id="web-to-pdf-url">&nbsp;
		<span class="btn btn-primary" style="width: 150px; margin-top: -10px;" id="web-to-pdf-button" onclick='Webtopdf()'><i class="icon-play icon-white"></i> Save to PDF!</span>
		<span style="color: #777777; font-size: 12px;">
		&nbsp;(Example: http://www.docs.zone)
		</span>
		<br />
		<br />
		<button id="loader" style="display: none" class="btn btn-primary" disabled>
  		<span class="spinner-border spinner-border-sm"></span>
  		Convert To PDF..
		</button>

	</div>
	</body>
</html>