<!DOCTYPE html>
<html>
    <head>
        <title>WaterMark</title>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="vendor/jquery-easing/jquery.easing.min.js"></script>
  <script src="js/sb-admin-2.min.js"></script>
<script>
   //form Submit
   $("#form").submit(function(evt){	 
      evt.preventDefault();
      var formData = new FormData($(this)[0]);
   $.ajax({
       url: 'addWatermark',
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
    <body style="text-align: center;">
        <div class="main-div">
            <h1>WaterMark</h1>
            <div id="image_frame"></div>
            <form>
		Select Video File(.mp4):<input type="file" name="videoData" required="required"> 
                <br>
Select image file:<input type="file" name="imageData" required="required">
                <br><input type="submit" value="Upload">
            </form>
        </div>
    </body>
</html>