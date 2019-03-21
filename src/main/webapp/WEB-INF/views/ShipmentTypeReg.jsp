<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
<%@include file="ShipmentHome.jsp"%>
	<div class="container">
		<div class="card">
			<div class="card-header bg-warning text-white">
				<h2>ShipmentType Reg Page!...</h2>
			</div>
			<div class="card-body"></div>
			<form:form action="insert" method="POST" modelAttribute="shipmentType">
				<div class="form-group">
					<label for="mode" class="label-control col-sm-2">ShipMent Mode</label>
					<form:select path="mode">
						<form:option value="">--select--</form:option>
						<form:option value="air">AIR</form:option>
						<form:option value="truck">Truck</form:option>
						<form:option value="ship">SHIP</form:option>
						<form:option value="train">Train</form:option>
					</form:select>
					<form:errors path="mode" cssClass="text-danger" />
				</div>
				<div class="form-group">
					<label for="code" class="label-control col-sm-2">Shipment
						Code</label>
					<form:input path="code" />
					<form:errors path="code" cssClass="text-danger" />
				</div>
				<div class="form-group">
					<label for="enabled" class="label-control col-sm-2">EnableShipment</label>
					<form:checkbox path="enabled" value="Yes" /> YES
					<form:errors path="enabled" cssClass="text-danger" />
				</div>
				<div class="form-group">
					<label for="grade" class="label-control col-sm-2">Shipment Grade</label>
					<form:radiobutton path="grade" value="a" />A
					<form:radiobutton path="grade" value="b" />B
					<form:radiobutton path="grade" value="c" />C
					<form:errors path="grade" cssClass="text-danger" />
				</div>
				<div class="form-group">
					<label for="dsc" class="label-control col-sm-2">Description</label>
					<form:textarea path="dsc" />
					<form:errors path="dsc" cssClass="text-danger" />
				</div>

				<div class="from-group">
					<input type="submit" value="Register" class="btn btn-success" /> 
					<input type="reset" value="Reset" class="btn btn-warning" />
				</div>

			</form:form>
		</div>
		<c:if test="${message ne null }">
			<div class="card-footer bg-warning text-white">${message}</div>
		</c:if>
	</div>
</body>
</html>