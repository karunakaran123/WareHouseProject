<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
			<div class="card-header bg-primary">
				<h2>Item Data!..</h2>
			</div>
			<c:choose>
				<c:when test="${!empty list}">

					<table class="table table-hover">
						<tr>
							<th>Item Id</th>
							<th>Item Code</th>
							<th>Item Dimentions</th>
							<th>Item Cost</th>
							<th>Item Currency</th>
							<th>Uom</th>
							<th>Sale</th>
							<th>Purchase</th>
							<th>Vendor</th>
							<th>customer</th>
							<th>ItemDesc</th>
							<th colspan="2">Operations</th>
						</tr>
						<c:forEach items="${list}" var="itm">
							<tr>
								<td><c:out value="${itm.itemId}"></c:out></td>

								<td><c:out value="${itm.itemCode}"></c:out></td>

								<td>W:<c:out value="${itm.width}"></c:out>,L:<c:out
										value="${itm.length}"></c:out>,H:<c:out value="${itm.hight}"></c:out></td>
								<td><c:out value="${itm.itemBaseCost}"></c:out></td>
								<td><c:out value="${itm.itemcurncy}"></c:out></td>
								<td><c:out value="${itm.uom.model}"></c:out></td>
								<td><c:out value="${itm.saleType.code}"></c:out></td>
								<td><c:out value="${itm.purchaseType.code}"></c:out></td>
								<td><c:forEach items="${itm.venuser}" var="ven">
										<c:out value="${ven.code}" />,
					</c:forEach></td>

								<td><c:forEach items="${itm.custuser}" var="cust">
										<c:out value="${cust.code}" />,
						</c:forEach></td>
								<td><c:out value="${itm.itmdsc}"></c:out></td>
								<td><a href="delete?id=${itm.itemId}">Delete</a></td>
								<td><a href="edit?id=${itm.itemId}">Edit</a></td>
							</tr>
						</c:forEach>

					</table>
				</c:when>
				<c:otherwise>
					<div class="text-info">NO Data Found in DATABASE</div>
				</c:otherwise>
			</c:choose>
			<c:if test="${message ne null }">
				<div class="card-footer bg-warning">${message}</div>
			</c:if>
		</div>
	</div>
</body>
</html>