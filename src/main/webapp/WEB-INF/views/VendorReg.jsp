<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
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
<%@include file="VenHome.jsp"%>
	<div class="container">
		<div class="card">
			<div class="card-header bg-info">
				<h2>Vendor RegPage!....</h2>
			</div>
			<div class="card-body">
				<form:form action="insert" method="POST" modelAttribute="vendor">
					<div class="form-group">
						<label for="venName" class="control-label col-sm-2">
							TypeVendorName :</label>
						<form:input path="venName" />
						<form:errors path="venName" cssClass="text-danger" />
					</div>
					<div class="form-group">
						<label for="venCode" class="control-label col-sm-2">Vendor
							Code :</label>
						<form:select path="venCode">
							<form:option value="">--select--</form:option>
							<form:option value="CAT">CAT</form:option>
							<form:option value="RES">RES</form:option>
						</form:select>
						<form:errors path="venCode" cssClass="text-danger" />
					</div>
					<div class="form-group">
						<label for="venDesg" class="control-label col-sm-2">VendorDesg</label>
						<form:radiobutton path="venDesg" value="sales" />
						Sales
						<form:radiobutton path="venDesg" value="service" />
						Service
						<form:radiobutton path="venDesg" value="Both" />
						Both
						<form:errors path="venDesg" cssClass="text-danger" />
						<%-- VendorPreserve:</form:/> --%>
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
	</div>
</body>
</html>