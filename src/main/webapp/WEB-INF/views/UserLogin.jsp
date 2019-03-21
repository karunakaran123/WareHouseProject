<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
	 <%@include file="HomeMenu.jsp"%>
	<div class="container ">

		<!-- card start -->
		<div class="card col-10">


			<!-- card Header -->
			<div class="card-header  col-14 bg-warning content-center">
				<center><h4>WELCOME TO USER LOGIN PAGE</h4></center>
			</div>


			<!-- card body -->
			<div class="card-body">
				
				<form action='<spring:url value="/signin"/>' method="POST" >
					<div class="form-group">
						<label for="username" class="control-label text-left col-sm-3">USER ID  :</label>
						<input type="text"  id="username" name="username" Required="required" />
					</div>
					<div class="form-group">
						<label for="userPwd" class="control-label text-left col-sm-3"> PASSWORD :</label>
						<input type="password"  id="password" name="password" required="required" />
					</div>
					<div class="form-group">
						<input type="submit" value="Login" class="btn btn-success"/> <input type="submit" value="Reset" class="btn btn-warning"/>
					</div>
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
				</form>
				
			</div>


			<c:if test="${param.error}">
				<div class="card-footer bg-danger text-white">Invalid Username and password.</div>
			</c:if>
			<c:if test="${param.logout}">
				<div class="card-footer bg-success text-white">You have been logged out.</div>
			</c:if>
		</div>
		
	</div>
	</center>
</body>
</html>