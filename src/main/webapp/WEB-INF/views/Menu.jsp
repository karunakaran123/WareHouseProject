<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="base">${pageContext.request.requestURL}</c:set>
<c:set var="url"	value="${fn:replace(base, pageContext.request.requestURI, pageContext.request.contextPath)}" />

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
 <style>
  /* Make the image fully responsive */
  .carousel-inner img {
      width: 100%;
      height: 100%;
  }
  </style>
</head>
<body>
<div class="text-center" style="width:100%" style="hieght:30%">
  <h2>LOGISTIC WAREHOUSE</h2>
</div>
<nav class="navbar navbar-expand-sm bg-primary   navbar-dark justify-content-center">
	<!-- Brand -->
	<!-- <a class="navbar-brand " href="#"><img src="../resources/imgs/logo.jpg" /></a> -->

	<!-- Links -->
	<ul class="navbar-nav">
		
		<li class="nav-item"><a class="nav-link text-white" href="${url}/uom/home">UOM</a></li>
		<li class="nav-item"><a class="nav-link text-white"  href="${url}/item/home">ITEM</a></li>
		<li class="nav-item"><a class="nav-link text-white" href="${url}/order/home">ORDERMETHOD</a></li>
		<li class="nav-item"><a class="nav-link text-white" href="${url}/purchase/home">PURCHASEORDER</a></li>
		
		<li class="nav-item"><a class="nav-link text-white" href="${url}/shipment/home">SHIPMENT</a></li>
		<li class="nav-item"><a class="nav-link text-white" href="${url}/whuser/home">WHUSER</a></li>
		<li class="nav-item"><a class="nav-link text-white" href="${url}/vendor/home">VENDOR</a></li>
		<li class="nav-item"><a class="nav-link text-white" href="${url}/logout">Logout</a></li>
		
	</ul>
	
</nav>

<div id="demo" class="carousel slide" data-ride="carousel">
<!-- Indicators -->
  <ul class="carousel-indicators">
    <li data-target="#demo" data-slide-to="0" class="active"></li>
    <li data-target="#demo" data-slide-to="1"></li>
    <li data-target="#demo" data-slide-to="2"></li>
    <li data-target="#demo" data-slide-to="3"></li>
    <li data-target="#demo" data-slide-to="4"></li>
  </ul>
  
  <!-- The slideshow -->
  <div class="carousel-inner">
    
    <div class="carousel-item">
      <img src="../resources/images/1.jpg" alt="Chicago" width="1100" height="400">
    </div>
    <div class="carousel-item">
      <img src="../resources/images/2.jpg" alt="New York" width="1000" height="400">
    </div>
    <div class="carousel-item active">
      <img src="../resources/images/3.jpg" alt="Los Angeles" width="1000" height="400">
    </div>
    
   <!--  <div class="carousel-item active">
      <img src="../resources/images/5.jpg" alt="Los Angeles" width="1000" height="400">
    </div>
    <div class="carousel-item">
      <img src="../resources/images/6.jpg" alt="New York" width="1000" height="400">
    </div>-->
  </div> 
  
  <!-- Left and right controls -->
  <a class="carousel-control-prev" href="#demo" data-slide="prev">
    <span class="carousel-control-prev-icon"></span>
  </a>
  <a class="carousel-control-next" href="#demo" data-slide="next">
    <span class="carousel-control-next-icon"></span>
  </a>
</div>


<!-- <div class="jumbotron text-center" style="height:5%" style="width:100%">
  <p><img src="../resources/images/2.jpg"/></p>
</div> -->
</body>
</html>