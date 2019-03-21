<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="PurchaseHome.jsp"%>
<h2>Purchase Order Reg</h2>
<form:form action="update" method="POST" modelAttribute="purchaseOrder">
<pre>
 Order Id		 :<form:input path="purchaseId" readOnly=true/>
 Order code      :<form:input path="orderCode"/>
 Shipment Code   :<form:select path="shipmentCode">
                   <form:option value="">--select--</form:option>
                   <form:options items="${shipmentType}"  itemLabel="code" itemValue="id"/>
                   </form:select>
 Vendor          :<form:select path="vendor">
 					<form:option value="">--select--</form:option>
 					<form:options items="${whuser}" itemLabel="type" itemValue="id"/>
 				  </form:select>
 				  
Reference Number :<form:input path="referenceNumber"/>
Quality Check    :<form:radiobutton path="qualityCheck" value="Reqired"/>Required<form:radiobutton path="qualityCheck" value="NotReqired"/>NotRequired
Default status   :<form:input path="defaultStatus" value="OPEN" readOnly="true"/>
Description      :<form:textarea path="description"/>
<input type="submit" value="updateplaceOrde"/> 
</pre>
</form:form>
${message}
</body>
</html>