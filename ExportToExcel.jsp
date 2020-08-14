<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="vendor/jquery-easing/jquery.easing.min.js"></script>
  <script src="js/sb-admin-2.min.js"></script>
<script>
   //form Submit
   $("form").submit(function(evt){	 
      evt.preventDefault();
      var formData = new FormData($(this)[0]);
   $.ajax({
       url: 'SqlToExcel',
       type: 'POST',
       data: formData,
       async: false,
       cache: false,
       contentType: false,
       enctype: 'multipart/form-data',
       processData: false,
       success: function (result) {
$("#div2").show();
$("#div2").html(result);
       }
   });
   return false;
 });
</script>
</head>
<body>
<div class="container">
<h1 style="color:blue;">Export To Excel</h1>
<br>
<br>
<center>
<form>
  <table>
    <tr>
      <td colspan="2">File Upload</td>
    </tr>
    <tr>
      <th>Select Sql File </th>
      <td><input id="file" name="file" type="file" /></td>
    </tr>
    <tr>
      <td colspan="2">
        <input type="submit" value="submit"/> 
      </td>
    </tr>
  </table>
</form>
<center>
</div>
</body>
</html>