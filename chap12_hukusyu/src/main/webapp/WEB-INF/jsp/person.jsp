<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Person</title>
</head>
<body>
  <table border="1">
    <tr>
      <th>名前</th><th>年齢</th>
    </tr>
    <c:forEach var="p" items="${personList}">
    　　<tr>
          <td><c:out value="${p.name}" /></td>
          <td><c:out value="${p.age}" />歳</td>
        </tr>
    </c:forEach>
  </table>
</body>
</html>