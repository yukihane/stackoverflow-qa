<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>SpringBoot + JSP</title>
</head>
<body>
  <c:url var="editAccount" value="/editAccount" />

  <div id="profileAbout">

    <div class="row">

      <form:form modelAttribute="user">

        <div class="col-md-10 col-md-offset-1">

          <div
            style="text-align: center; font-weight: bold; font-size: x-large; margin: 1%;">
            Username:
            <c:out value="${user.email}" />
          </div>

        </div>

        <div class="profile-about-edit">
          <a href="${editAccount}">Edit</a>
        </div>

      </form:form>

    </div>

  </div>
</body>
</html>
