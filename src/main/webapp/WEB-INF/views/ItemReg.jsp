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
<%@include file="ItemHome.jsp"%>
	<div class="container">
	<div class="card">
	<div class="card-header bg-warning">
		<h2>Item Reg Page!...</h2>
	</div>
	<div class="card-body">
		<form:form action="insert" method="POST" modelAttribute="item">
			<div class="form-group">
				<label for="Item Code" class="control-label col-sm-3">Item Code</label>
				<form:input path="itemCode" />
				<form:errors path="itemCode" cssClass="text-danger" />
			</div>

			<div class="form-group">
				<label for="Item Diemention" class="control-label col-sm-3">Item Diemention</label>: 
				W
				<form:input path="width" size="5" />
				L
				<form:input path="length" size="5" />
				H
				<form:input path="hight" size="5" />
				<form:errors path="width" cssClass="text-danger" />
			</div>
			<div class="form-group">
				<label for="Base Cost" class="control-label col-sm-3">Base Cost</label>
				<form:input path="itemBaseCost" />
				<form:errors path="itemBaseCost" cssClass="text-danger"/>
			</div>
			
			<div class="form-group">
				<label for="Item UOM" class="control-label col-sm-3">Item UOM</label>
				<form:select path="uom.id">
					<form:option value="">--select--</form:option>
					<form:options items="${uom}" itemLabel="model" itemValue="id" />
				</form:select>
				<form:errors path="uom" cssClass="text-danger" />
			</div>
			
			<div class="form-group">
				<label for="Order Method(SaleType)" class="control-label col-sm-3">Order Method(SaleType)</label>
				<form:select path="saleType.id">
					<form:option value="">--select--</form:option>
					<form:options items="${sales}" itemLabel="code" itemValue="id" />
				</form:select>
				<form:errors path="saleType" cssClass="text-danger" />
			</div>
			
			<div class="form-group">
				<label for="Order
					Method(PurchaseType)" class="label-control col-sm-3">Order
					Method(PurchaseType)</label>
				<form:select path="purchaseType.id">
					<form:option value="">--select--</form:option>
					<form:options items="${purchases}" itemLabel="code" itemValue="id" />
				</form:select>
				<form:errors path="purchaseType" cssClass="text-danger"/>
			</div>
			
			<div class="form-group">
				<label for="Item Vendor" class="control-label col-sm-3">Item Vendor</label>
				<form:select path="venuser">
					<%-- <form:option value="">--select--</form:option>  --%>
					<form:options items="${vendors}" itemLabel="code" itemValue="id" />
				</form:select>
				<form:errors path="venuser" cssClass="text-danger" />
			</div>
			
			<div class="form-group">
				<label for="Item Customer" class="label-control col-sm-3">Item Customer</label>
				<form:select path="custuser">
					<%-- <form:option value="">--select--</form:option>  --%>
					<form:options items="${customers}" itemLabel="code" itemValue="id" />
				</form:select>
				<form:errors path="custuser" cssClass="text-danger" />
				</div>
			
				<div class="form-group">
					<label for="itemcurncy" class="control-label col-sm-3">Base Currecncy</label>
					<form:select path="itemcurncy">
						<form:option value="">--select--</form:option>
						<form:option value="INR">INR</form:option>
						<form:option value="USD">USD</form:option>
						<form:option value="AUS">AUS</form:option>
						<form:option value="ERU">ERU</form:option>
					</form:select>
					<form:errors path="itemcurncy" cssClass="text-danger" />
				</div>
			
				<div class="form-group">
					<label for="itmdsc" class="label-control col-sm-3">Description</label>
					<form:textarea path="itmdsc" />
					<form:errors path="itmdsc" cssClass="text-danger" />
				</div>
			
				<div class="from-group">
					<input type="submit" value="Register" class="btn btn-success"/> <input type="reset" value=" Reset " class="btn btn-warning"/>
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