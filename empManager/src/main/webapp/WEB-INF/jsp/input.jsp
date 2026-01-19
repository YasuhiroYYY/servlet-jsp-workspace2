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
      <h2>${h2text}</h2>
      <form action="${actionURL}" method="post">
        <table>
         <tr>
           <th>ID</th>
           <td><input type="text" name="id" 
                       value="<c:out value="${emp.id}" />"></td>
         </tr>
         <tr>
           <th>名前</th>
           <td><input type="text" name="name" 
                       value="<c:out value="${emp.name}" />"</td>
         </tr>
         <tr>
           <th>年齢</th>
           <td><input type="text" name="age" 
                       value="<c:out value="${emp.age}" />"></td>
         </tr>
        </table>
        <input type="submit" formaction="list" formmethod="get" value="取消">
        <input type="submit" value="確認">
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