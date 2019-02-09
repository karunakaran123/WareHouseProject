<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="card">
			<div class="card-header bg-warning text-white">
				<h2>Order RegPage!..</h2>
			</div>
			<div class="card-body">
				<form:form action="insert" method="post"
					modelAttribute="orderMethod">

					<div class="form-group">
						<label for="mode" class="control-label col-sm-2">Order Mode</label>
						<form:radiobutton path="mode" value="sale" />
						Sale
						<form:radiobutton path="mode" value="purchase" />
						Purchase
						<form:errors path="mode" cssClass="text-warning" />
					</div>
					<div class="form-group">
						<label for="code" class="control-label col-sm-2">Order Code</label>
						<form:input path="code" />
						<form:errors path="code" cssClass="text-warning" />
					</div>
					<div class="form-group">
<label for="code" class="control-label col-sm-2">OrderMethod</label>
						<form:select path="method">
							<form:option value="">--select--</form:option>
							<form:option value="FIFO">FIFO</form:option>
							<form:option value="LIFO">LIFO</form:option>
							<form:option value="FCFO">FCFO</form:option>
							<form:option value="FEFO">FEFO</form:option>
						</form:select>
						<form:errors path="method" cssClass="text-warning" />
					</div>
					<div class="form-group">
						<label for="accept" class="control-label col-sm-2">Order Accept</label>
						<form:checkbox path="accept" value="multimodel" />
						Multi-Model
						<form:checkbox path="accept" value="acceptreturn" />
						AcceptReturn
						<form:errors path="accept" cssClass="text-warning" />
					</div>
					<div class="form-group">
						<label for="dsc" class="control-label col-sm-2">Description</label>
						<form:textarea path="dsc" />
						<form:errors path="dsc" cssClass="text-warning" />
					</div>
					<div class="form-group">
						<input type="submit" value="CreateOrderMethod"
							class="btn btn-success">
					</div>
				</form:form>
			</div>
			<c:if test="">
				<div class="card-footer bg-warning text-white">${message}</div>
			</c:if>
		</div>
	</div>
</body>
</html>