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
	<div class="container">
		<div class="card">
			<div class="card-header bg-primary text-white">
				<h2>WhUserType Reg Page!.....</h2>
			</div>
			<div class="card-body">
				<form:form action="update" method="POST" modelAttribute="whUserType">
					<div class="form-group">
						<label for="whuser Id">whuser Id</label>
						<form:input path="id" readOnly="true" />
					</div>
					<div class="form-group">
						<label for="User Type" class="label-control col-sm-3">User
							Type</label>
						<form:radiobutton path="type" value="vendor" />
						Vendor
						<form:radiobutton path="type" value="customer" />
						Customer
						<form:errors path="type" cssClass="text-danger" />
					</div>
					<div class="form-group">
						<label for="User Code" class="label-control col-sm-3">User
							Code</label>
						<form:input path="code" />
						<form:errors path="code" cssClass="text-danger" />
					</div>
					<div class="form-group">
						<label for="Userfor" class="label-control col-sm-3">Userfor</label>
						<form:input path="forType" />
						<form:errors path="forType" cssClass="text-danger" />
					</div>
					<div class="form-group">
						<label for="User Email" class="label-control col-sm-3">User
							Email</label>
						<form:input path="email" />
						<form:errors path="email" cssClass="text-danger" />
					</div>
					<div class="fprm-group">
						<label for="User Contact" class="label-control col-sm-3">User
							Contact</label>
						<form:input path="contact" />
						<form:errors path="contact" cssClass="text-danger" />
					</div>
					<div class="form-group">
						<label for="UserIdType" class="label-control col-sm-3">UserIdType</label>
						<form:select path="idType">

							<form:option value="">--select--</form:option>
							<form:option value="pancard">PANCARD</form:option>
							<form:option value="ADR">ADDAR</form:option>
							<form:option value="credit">CEDITCARD</form:option>
							<form:option value="other">OTHER</form:option>
						</form:select>
						<form:errors path="idType" cssClass="text-danger" />
					</div>
					<div class="form-group">
						<label for="*If Other" class="label-control col-sm-3">*If
							Other</label>
						<form:input path="ifOther" />
					</div>
					<div class="form-group">
						<label for="Id Number" class="label-control col-sm-3">Id
							Number</label>
						<form:input path="idNum" />
						<form:errors path="idNum" cssClass="text-danger" />
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