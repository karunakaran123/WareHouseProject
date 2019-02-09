<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="HomeMenu.jsp"%>
	<div class="container">
		<div class="card">
			<div class="card-header">
				<h2>User Registration Page!...</h2>
			</div>
			<div class="card-body">
				<form:form action="insert" method="POST" modelAttribute="user" cssClass="form">
					<div class="form-group">
						<label for="userName" class="control-label col-sm-3">UserName</label>
						<form:input path="userName" required="required" />
						<form:errors path="userName" cssClass="text-danger" />
					</div>
					<div class="form-group">
						<label for="userEmail" class="control-label col-sm-3">UserEmail</label>
						<form:input path="userEmail" required="required" />
						<form:errors path="userEmail" cssClass="text-danger" />
					</div>
					<div class="form-group">
						<label for="userPwd" class="control-label col-sm-3">UserPassward</label>
						<form:password path="userPwd" required="required" />
						<form:errors path="userPwd" cssClass="text-danger" />
					</div>
					<div class="form-group">
						<label for="roles" class="control-label col-sm-3">UserRoles</label>
						<form:checkbox path="roles" value="admin" />
						Admin
						<form:checkbox path="roles" value="Emp" />
						Employee
						<form:errors path="roles" cssClass="text-danger" />
					</div>
					<div class="from-group">
						<input type="submit" value="Register" class="btn btn-success" />
						<input type="reset" value=" Reset " class="btn btn-warning" />
					</div>
				</form:form>
			</div>
			<c:if test="${message ne null }">
				<div class="card-footer bg-warning text-white">${message}</div>
			</c:if>
		</div>
	</div>
</body>
</html>