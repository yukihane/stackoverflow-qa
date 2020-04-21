<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>user page</title>
</head>
<body>
<form:form method="POST" action="/user"
  modelAttribute="listForm">
<c:forEach items="${list}" var="user">
    <tr>
        <td><form:label path="id">${user.id}"</form:label><td>
        <td><form:label path="name">${user.name}</form:label><td>
        <td><form:label path="age">${user.age}</form:label><td>
        <td><form:label path="address">${user.address}</form:label><td>
        <td><input type="submit" value="更新" name="update" /><td>
    </tr>
</c:forEach>
</form:form>
</body>
</html>