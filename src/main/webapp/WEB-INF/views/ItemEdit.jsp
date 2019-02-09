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
<h2>Item Edit Page!...</h2>
<form:form action="update" method="POST" modelAttribute="item">
<pre>
Item Id        :<form:input path="itemId" readOnly="true"/>
Item Code      :<form:input path="itemCode"/>

Item Diemention: W<form:input path="width" size="5"/> L<form:input path="length" size="5"/> H<form:input path="hight" size="5"/>

Base Cost      :<form:input path="itemBaseCost"/>

Item Uom       :<form:select path="uom.id">
                <form:option value="">--select--</form:option>
				<form:options items="${uom}" itemLabel="model" itemValue="id"/>
                </form:select>
                
                
Order Method(SaleType)   :<form:select path="saleType.id">
                <form:option value="">--select--</form:option> 
                <form:options items="${sales}" itemLabel="code"  itemValue="id"/>
                </form:select>
                <form:errors path="saleType" cssClass="err"/>
                
Order Method(PurchaseType):<form:select path="purchaseType.id">
			    <form:option value="">--select--</form:option>
				<form:options items="${purchases}" itemLabel="code" itemValue="id"/>
				</form:select>
				
Item Vendor    :<form:select path="venuser">
                 <%--  <form:option value="">--select--</form:option>  --%>
                 <form:options items="${vendors}" itemLabel="code" itemValue="id"/>
				</form:select>
	
				
Item Customer  :<form:select path="custuser">
                 <%--  <form:option value="">--select--</form:option>  --%>
                 <form:options items="${customers}" itemLabel="code" itemValue="id"/>
				</form:select>
	
Base Currecncy :<form:select path="itemcurncy">
				<form:option value="">--select--</form:option> 
				<form:option value="INR">INR</form:option>
				<form:option value="USD">USD</form:option>
				<form:option value="AUS">AUS</form:option>
				<form:option value="ERU">ERU</form:option>
                </form:select> 
               
Description    :<form:textarea path="itmdsc"/>             
</pre>
</form:form>
${message}
</body>

</html>