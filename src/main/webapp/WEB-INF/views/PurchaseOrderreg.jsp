<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
.err
{
color:red;
}

</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Purchase Order Reg</h2>
<form:form action="insert" method="POST" modelAttribute="purchaseOrder">
<pre>
 Order code      :<form:input path="orderCode"/>
 		<form:errors path="orderCode" cssClass="err"/>
 				  
 Shipment Code   :<form:select path="shipmentCode.id">
                   <form:option value="">--select--</form:option>
                   <form:options items="${shipmentType}"  itemLabel="code" itemValue="id"/>
                   </form:select>
        <form:errors path="shipmentCode" cssClass="err"/>
                    
 Vendor          :<form:select path="vendor">
 					<form:option value="">--select--</form:option>
 					<form:options items="${whuser}" itemLabel="type" itemValue="id"/>
 				  </form:select>
 	     <form:errors path="vendor" cssClass="err"/>
Reference Number :<form:input path="referenceNumber"/>
		 <form:errors path="referenceNumber" cssClass="err"/>
Quality Check    :<form:radiobutton path="qualityCheck" value="Reqired"/>Required<form:radiobutton path="qualityCheck" value="NotReqired"/>NotRequired
		 <form:errors path="qualityCheck" cssClass="err"/>
Default status   :<form:input path="defaultStatus" value="OPEN" readOnly="true"/>
				   
Description      :<form:textarea path="description"/>
		  <form:errors path="description" cssClass="err"/>
<input type="submit" value="placeOrde"/> 
</pre>
</form:form>
${message}
</body>
</html>