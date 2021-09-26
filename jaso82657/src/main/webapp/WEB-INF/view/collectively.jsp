<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<style type="text/css">
select {
 width: 150px;
}
</style>
<style>
table {
 border-collapse: collapse;
 text-align: center;
}

th, td {
 padding: 1px;
 border: 1px solid #333;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>売上登録</title>
</head>
<body>
 <h2>売上登録</h2>


 <p>売上日:${dtsql}</p>

 <!-- <form action="/B31/CollectivelyPost" method="post">-->
 <form action="Collectively" method=Post>
  <select name="DropDownList">
   <c:forEach var="item" items="${list}">
    <option value="${item.getProduct_code()}">${item.getProduct_name()}</option>
   </c:forEach>
  </select> 数量<input type="text" size="1" name="quantity">
  <button type="submit">追加</button>
  <hr width="280" align="left">
  <table border="1" width="280" height="2">
   <tr>
    <th width="200">商品名</th>
    <th>数量</th>
   </tr>
   <c:forEach var="item" items="${collectively}">
   <tr>
   <td><c:out value="${item.getProduct_name()}" /></td>
    <td><c:out value="${item.getQuantity()}" /></td></tr>
    </c:forEach>
  </table>

 </form>
 <form action="/B31/Read" method=GET>
  <button type="submit">登録</button>
  </form>
</body>
</html>