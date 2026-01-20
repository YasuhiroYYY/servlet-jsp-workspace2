<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>

<html>
<jsp:include page="common/head.jsp" />

<body>

<jsp:include page="common/header.jsp" />

  <div class="container center-align">
    <main>
      <h2>${h2text}確認</h2>
      <table>
       <tr>
         <th>ID</th>
         <td><c:out value="${emp.id}" /></td>
       </tr>
       <tr>
         <th>名前</th>
         <td><c:out value="${emp.name}" /></td>
       </tr>
       <tr>
         <th>年齢</th>
         <td><c:out value="${emp.age}" /></td>
       </tr>
      </table>
      <form action="${actionUrl}" method="post">
        <input type="hidden" name="id" value="<c:out value="${emp.id}" />">
        <input type="hidden" name="name" value="<c:out value="${emp.name}" />">
        <input type="hidden" name="age" value="<c:out value="${emp.age}" />">
        <input type="submit" formaction="${gobackUrl}" value="戻る">
        <input type="submit" value="${btnValue}">
      </form>
      <ul class="error">
        <c:forEach var="error" items="${errorList}">
          <li><c:out value="${error}" /></li>
        </c:forEach>
      </ul>
    </main>
    <jsp:include page="common/aside.jsp" />
  </div>
<jsp:include page="common/footer.jsp" />
</body>
</html>