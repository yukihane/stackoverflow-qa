<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../header.html" %>

<p>...</p>
<select id="learningOptions" name="learningOptions">
    <option value="csharp">C#</option>
    <option value="java">Java</option>
    <option value="python">Python</option>
</select>

<p>...</p>
<select id="actionOptions" name="actionOptions" onchange="updateSubOptions()">
     <option value="calc_text" <%= "calc_text".equals(request.getParameter("actionOptions")) ? "selected" : "" %>>テキストを表示/計算</option>
     <option value="app" <%= "app".equals(request.getParameter("actionOptions")) ? "selected" : "" %>>アプリ</option>
</select>
 <form action="../Servlet" method="post">
    <div id="calcTextInput" style="display:<%= "calc_text".equals(request.getParameter("actionOptions")) ? "block" : "none" %>;">
        <label for="inputBox">テキスト入力ボックス:</label>
        <input type="text" id="inputBox" name="inputBox">
        <br>
        <label for="calculation">計算(半角数字と+,-,*,/のみ使用可能)</label>
        <input type="text" id="calculation" name="calculation" onkeypress="return isAllowedCharacter(event)">
    </div>
    <input type="submit" value="計算">
</form>

 <div id="appOptions" style="display:<%= "app".equals(request.getParameter("actionOptions")) ? "block" : "none" %>;">
    <label for="appSubOptions">詳細を選択してください:</label>
    <select id="appSubOptions" name="appSubOptions">
        <option value="quiz">クイズ</option>
        <option value="fastestFinger">早押し</option>
    </select>
</div>

<script>
    function updateSubOptions(){
        var actionDropdown = document.getElementById("actionOptions");
        var selectedValue = actionDropdown.value;

        var calcTextInput = document.getElementById("calcTextInput");
        var appOptions = document.getElementById("appOptions");

        if (selectedValue === "calc_text"){
            calcTextInput.style.display = "block";
            appOptions.style.display = "none";
        } else if (selectedValue === "app") {
            calcTextInput.style.display = "none";
            appOptions.style.display = "block";
        } else {
            calcTextInput.style.display = "none";
            appOptions.style.display = "none";
        }
    }

    function isAllowedCharacter(event) {
        var char = String.fromCharCode(event.which);
        if (!/[0-9+\-*/%]/.test(char)){
            event.preventDefault();
        }
    }

    window.onload = function(){
        updateSubOptions();
    };
</script>

<%@include file="../footer.html" %>
