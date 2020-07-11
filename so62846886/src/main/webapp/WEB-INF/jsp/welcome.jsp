<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color:cyan">

<h1>Welcome to Online Assessment Page</h1><br>
<h2>Login</h2><br>
<form:form action="processForm" method="post" modelAttribute="employee">
Email ID: <form:input path="email"/><br>
Password: <form:input path="password"/><br>
<input type="submit" value= "Login">
</form:form>

New user? <a href="${pageContext.request.contextPath}/registration">Register Here</a>
</body>
</html>