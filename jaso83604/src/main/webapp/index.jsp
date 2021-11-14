<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>Hello World</title>
  </head>

  <body>
    <div>
      Hello World!<br />
      <% out.println("Your IP address is " + request.getRemoteAddr()); %>
    </div>

<div>
<!-- https://qiita.com/sculptcat/items/53d1a3a2d3b973354085#curl-url%E3%82%A8%E3%83%B3%E3%82%B3%E3%83%BC%E3%83%89 -->
<c:url value="http://www.google.com/search" var="searchURL" >
<c:param name="q" value="sample" />
</c:url>
<a href="<c:out value="${searchURL}" />">search</a>
</div>
  </body>
</html>
