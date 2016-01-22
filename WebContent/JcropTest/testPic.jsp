<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../Jcrop/demos/demo_files/main.css" type="text/css" />
<link rel="stylesheet" href="../Jcrop/demos/demo_files/demos.css" type="text/css" />
<link rel="stylesheet" href="../Jcrop/css/jquery.Jcrop.css" type="text/css" />
<script src="../Jcrop/js/jquery.min.js"></script>
<script src="../Jcrop/js/jquery.Jcrop.js"></script>
<script type="text/javascript">
  jQuery(function($){

    // How easy is this??
    $('#ad').Jcrop();

  });

</script>
<style>
	img{width:300px;height:300px;}
</style>
</head>
<body>

<img src="../ProductPicture/20141212195500920.jpg" id="ad" />
</body>
</html>