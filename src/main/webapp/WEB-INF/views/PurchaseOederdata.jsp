<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<%@include file="PurchaseHome.jsp"%>
<div class="container">
<div class="card">
<div class="card-header bg-warning">
<h2>PurchaseOrder Data!...</h2>
</div>
<div class="card-body">
<a href="pdf">PDF export</a> | <a href="excel">Excel Export</a>

<c:choose>
<c:when test="${!empty list}">
<table class="table table-hover">
	<tr>
	 <th>PurchaseId</th>
	 <th>OrderCode</th>
	 <th>ShipmentCode</th>
	 <th>Vendor</th>
	 <th>ReferenceNumber</th>
	 <th>QualityCheck</th>
	 <th>DefaultStatus</th>
	 <th>Description</th>
	</tr>
    <c:forEach items="${list}" var="pur">
     <tr>
       <td><c:out value="${pur.purchaseId}"></c:out> </td>
       <td><c:out value="${pur.orderCode}"></c:out> </td>
       <td><c:out value="${pur.shipmentCode}"></c:out> </td>
       <td><c:out value="${pur.vendor}"></c:out> </td>
       <td><c:out value="${pur.referenceNumber}"></c:out> </td>
       <td><c:out value="${pur.qualityCheck}"></c:out> </td>
       <td><c:out value="${pur.defaultStatus}"></c:out> </td>
       <td><c:out value="${pur.description}"></c:out> </td>
     </tr>
    </c:forEach>
</table>
</c:when>
<c:otherwise>
<div class="text-form">NO Data FOUND in DB</div>
</c:otherwise>
</c:choose>
</div>
<c:if test="${message ne null}">
${message}
</c:if>
</div>
</div>
</body>
</html>