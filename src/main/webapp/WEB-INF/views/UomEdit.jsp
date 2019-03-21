<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
<%@include file="UomHome.jsp"%>
	<div class="container">
		<div class="card">
			<div class="card-header bg-primary text-white">
				<h1>Uom Edit page</h1>
			</div>
			<div class="card-body">
				<form:form action="update" method="POST" modelAttribute="uom">
					<div class="form-group">
						<label for="UOM Id" class="control-label col-sm-2">UOM Id</label>
						<form:input path="id" readOnly="true" />
					</div>
					<div class="form-group">
						<label for="type" class="control-label col-sm-2">UOM Type</label>
						<form:select path="type">
							<form:option value="">--select--</form:option>
							<form:option value="PACKING">PACKING</form:option>
							<form:option value="NOPACKING">NO PACKING</form:option>
							<form:option value="NOTHING">NA</form:option>
						</form:select>
						<form:errors path="type" cssClass="text-danger" />
					</div>

					<div class="form-group">
						<label for="model" class="control-label col-sm-2">Model</label>
						<form:input path="model" />
						<form:errors path="model" cssClass="text-danger" />
					</div>

					<div class="form-group">
						<label for="dsc" class="control-label col-sm-2">Description</label>
						<form:textarea path="dsc" />
						<form:errors path="dsc" cssClass="text-danger" />
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