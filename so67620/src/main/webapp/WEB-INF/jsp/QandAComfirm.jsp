<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8" %>
<%@ page import="java.util.Date,java.text.SimpleDateFormat" %>
<%@ page import="model.Question"%>
<%@ page import="java.util.List"%>
<%
  @SuppressWarnings("unchecked")
  List<Question> elist = (List<Question>) session.getAttribute("EditQuestionList");
%>

<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content=“width=device-width,initial-scale=1.0”>
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <title>質問編集画面</title>
  <link rel="stylesheet" href="css/QandAEdit.css">
</head>
<body>
<header>
  <div class="container">
    <div class="header-flex">
      <div class="header-left">
        <h3>質問編集</h3>
      </div>
      <div class="header-right">
        <a href="#" class="btn">戻る</a>
      </div>
   </div>
  </div>
</header>
<section class="regist-form">
 <div class="container">
 <form action="EditQuestionServlet" method="post">
  <table border="1">
  <% for (int i=0; i<elist.size(); i++) { %>
    <tr>
      <th>名前(ハンドルネーム)</th>
      <td><input type="text" value=<%=elist.get(i).getHandle_name()%> class="inp"></td>
    </tr>
    <tr>
      <th>タイトル</th>
      <td><input type="text" value=<%=elist.get(i).getTitle()%> class="inp"></td>
    </tr>
    <tr>
      <th class="contents">内容</th>
      <td><textarea rows="16"><%=elist.get(i).getContents()%></textarea></td>
    </tr>
    <tr class="urgency">
      <th>緊急度</th>
      <td>
        <label><input type="radio" name="urgency" value="1">急いでいます</label>
        <label><input type="radio" name="urgency" value="2">困ってます</label>
        <label><input type="radio" name="urgency" value="3">いつでも</label>
      </td>
    </tr>
    <tr>
      <th>編集・削除キー</th>
      <td><input type="text" value=<%=elist.get(i).getEdit_delete_key()%> class="inp"></td>
    </tr>
    <% } %>
  </table>
  <input type="submit" value="編集する">
  </form>
  </div>
</section>
<script src="js/QandAEdit.js"></script>
</body>
</html>
