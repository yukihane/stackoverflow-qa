<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.example.*"%>
<%! String msg ="こんにちは、世界!"; %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8" />
</head>
<body>
<% InfoBean infoBean = new InfoBean(); %>
<% String Kjnymd = "20231231"; %>
<%   String Message = "日付をご確認ください"; %>
<%
if (JspUtil.notNull(infoBean.getDate()).equals(Kjnymd)) {
    return Message;
} else {
    return infoBean.getDate();
}
%>
</body>
</html>
