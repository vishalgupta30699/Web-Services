cvar myURL;
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
var url=$("#web-to-pdf-url").val();
if(!validateURL(url))
{
$("#web-to-pdf-incorrect-url-warning").show();
return false;
}
$("#pdf").hide();
url=encodeURIComponent(url);
$("#web-to-pdf-incorrect-url-warning").hide();
$("#web2pdf-error").hide();
$("#web2pdf-window").modal({keyboard:false,backdrop:'static'});
$.ajax({
url: "convertToPdf", 
method:"GET",
data: url,
success: function(result){
    $("#pdf").html(result);
  }
});
}