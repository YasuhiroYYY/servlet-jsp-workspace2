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
      <h2>本日やること！</h2>
      <table>
        <tr>
          <th>優先事項</th>
          <th>todo</th>
          <th>結果</th>
          <th class="no-border"></th>
          <th class="no-border"></th>
        </tr>
        <c:forEach var="todo" items="${todoList}">
          <tr>
            <td><c:out value="${todo.priority}" /></td>
            <td><c:out value="${todo.text}" /></td>
            <td id="kan"><c:out value="${todo.kekka}" /></td>
            <td class="no-border">
              <form action="KanryouServlet" method="post">
                <input type="hidden" name="priority" value="<c:out value="${todo.priority}" />">
                <input type="submit" value="完了" class="btn">  
              </form>
             </td>
            <td class="no-border">
              <form action="RemoveServlet" method="post">
                <input type="hidden" name="priority" value="<c:out value="${todo.priority}" />">
                <input type="submit" value="削除" class="btn">  
              </form>
            
            </td>
          </tr>
        </c:forEach>       
      </table>
    </main>
    <jsp:include page="common/aside.jsp" />
  </div>

<jsp:include page="common/footer.jsp" />


</body>
</html>