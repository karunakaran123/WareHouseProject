<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>ShipmentType Edit Page !..</h2>
<form:form action="update" method="POST" modelAttribute="shipmentType">
<pre>
Shipment Id   :<form:input path="id" readOnly="true"/>
ShipMent Mode :<form:select path="mode">
               <form:option value="">--select--</form:option>
               <form:option value="air">AIR</form:option>
               <form:option value="truck">Truck</form:option>
               <form:option value="ship">SHIP</form:option>
               <form:option value="train">Train</form:option>
               </form:select>
 Shipment Code :<form:input path="code"/>
 EnableShipment:<form:checkbox path="enabled"  value="Yes"/>YES
 Shipment Grade:<form:radiobutton path="grade" value="A"/>A<form:radiobutton path="grade" value="B"/>B<form:radiobutton path="grade" value="C"/>C
 Description   :<form:textarea path="dsc"/>
 <input type="submit" value="submit"/>
</pre>
</form:form>
${message}
</body>
</html>