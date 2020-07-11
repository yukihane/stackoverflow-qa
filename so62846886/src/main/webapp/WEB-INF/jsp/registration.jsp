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
<h1>Registration</h1>
<form:form action="addCandidate" method="post" modelAttribute="candidate">
First Name: <form:input path="firstName"/><br>
Last Name: <form:input path="lastName"/><br>
Email ID: <form:input path="email"/><br>
Password: <form:input path="password"/><br>
<input type="submit" value="Submit">
</form:form>
</body>
</html>