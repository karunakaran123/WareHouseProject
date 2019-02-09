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
<h2> Vendor RegPage!....</h2>
<form:form action="insert" method="POST" modelAttribute="vendor">
 VendorName    :<form:input path="venName"/>
 VendorCode    :<form:select path="venCode">
 			   <form:option value="">--select--</form:option>
               <form:option value="CAT">CAT</form:option>
               <form:option value="RES">RES</form:option>
              </form:select>
 VendorDesg    :<form:radiobutton path="venDesg" value="sales"/>Sales<form:radiobutton path="venDesg" value="service"/>Service<form:radiobutton path="venDesg" value="Both"/>Both
 <%-- VendorPreserve:</form:/> --%>
</form:form>
</body>
</html>