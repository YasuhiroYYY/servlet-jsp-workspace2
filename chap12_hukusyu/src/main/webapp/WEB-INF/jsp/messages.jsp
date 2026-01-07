<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>messages</title>
<style>
  .error {
    color: red;
  }
</style>
</head>
<body>
<ul class="error">
  <c:forEach var="msg" items="${messages}">
	<li><c:out value="${msg}" /></li>
  </c:forEach>
</ul>


</body>
</html>