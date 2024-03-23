<%@ page contentType="text/html;charset=UTF-8" %>
<%! String msg ="こんにちは、世界!"; %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8" />
  <title><%=msg  %></title>
</head>
<body>
  <%
  for(int i=0;i<5;i++) {
    out.println(msg+"<br/>");
  }
  %>
  <jsp:include page="include.jsp" />
</body>
</html>
