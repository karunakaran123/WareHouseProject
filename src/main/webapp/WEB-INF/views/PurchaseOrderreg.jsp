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
</head>
<body>
	<%@include file="PurchaseHome.jsp"%>
	<div class="container">
		<div class="card">
			<div class="card-header bg-warning">
				<center>
					<h2>Purchase Order Reg</h2>
				</center>
			</div>
			<div class="card-body">
				<form:form action="insert" method="POST"
					modelAttribute="purchaseOrder">
					<div class="form-group">
						<label for="orderCode" class="control-label col-sm-2">Order
							code :</label>
						<form:input path="orderCode" />
						<form:errors path="orderCode" cssClass="text-danger" />
					</div>
					<div class="fprm-group">
						<label for="shipmentCode" class="control-label col-sm-2">Shipment
							code :</label>
						<form:select path="shipmentCode">
							<form:option value="">--select--</form:option>
							<form:options items="${shipmenttype}" itemLabel="code"
								itemValue="id" />
						</form:select>
						<form:errors path="shipmentCode" cssClass="text-danger" />
					</div>
					<div class="form-group">
						<label for="vendor" class="control-label col-sm-2">Vendor
							:</label>
						<form:select path="vendor">
							<form:option value="">--select--</form:option>
							<form:options items="${whuser}" itemLabel="type" itemValue="id" />
						</form:select>
						<form:errors path="vendor" cssClass="text-danger" />
					</div>
					<div class="form-group">
						<label for="referenceNumber" class="control-label col-sm-2">Reference
							Number :</label>
						<form:input path="referenceNumber" />
						<form:errors path="referenceNumber" cssClass="text-danger" />
					</div>
					<div class="form-group">
						<label for="qualityCheck" class="control-label col-sm-2">Quality
							Check :</label>

						<form:radiobutton path="qualityCheck" value="Reqired" />
						Required
						<form:radiobutton path="qualityCheck" value="NotReqired" />
						NotRequired
						<form:errors path="qualityCheck" cssClass="text-danger" />
					</div>
					<div class="form-group">
						<label for="defaultStatus" class="control-label col-sm-2">Default
							status :</label>
						<form:input path="defaultStatus" value="OPEN" readOnly="true" />
					</div>

					<div class="form-group">
						<label for="description" class="control-label col-sm-2">Description
							:</label>
						<form:textarea path="description" />
						<form:errors path="description" cssClass="text-danger" />
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