<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>Hello World</title>
  </head>

  <body>
<div>
   <objct data="<c:url value='${requestScope.formmodel.url}'/>"></object>
</div>
  </body>
</html>
