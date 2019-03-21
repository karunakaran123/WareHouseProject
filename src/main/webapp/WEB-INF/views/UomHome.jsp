<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="base">${pageContext.request.requestURL}</c:set>
<c:set var="url" value="${fn:replace(base, pageContext.request.requestURI, pageContext.request.contextPath)}" />



<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>


<nav class="navbar navbar-expand-sm bg-primary navbar-dark justify-content-center">
	
	<ul class="navbar-nav nav">
		
		<li class="nav-item"><a class="nav-link text-white"   href="${url}/uom/reg">UOM REG</a></li>
		<li class="nav-item"><a class="nav-link text-white"   href="${url}/uom/all">UOM DATA</a></li>
		<li class="nav-item"><a class="nav-link text-white"   href="${url}/home/home">HOME</a></li>
		
	</ul>
	
</nav>