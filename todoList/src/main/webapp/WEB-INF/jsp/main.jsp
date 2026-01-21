<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%
java.util.Date nowTime = new java.util.Date();
%>
<!DOCTYPE html>
<html>

<jsp:include page="common/head.jsp" />

<body>
<jsp:include page="common/header.jsp" />

  <div class="container center-align">
    <main>
      <h2>Things to do</h2>
      <p><%= nowTime %></p>
      <table>
        <tr>
          <th>Priority</th>
          <th>Todo</th>
          <th>Result</th>
          <th class="no-border"></th>
          <th class="no-border"></th>
        </tr>
        <c:forEach var="todo" items="${todoList}">
          <tr>
            <td><c:out value="${todo.priority}" /></td>
            <td><c:out value="${todo.text}" /></td>
            <td id="kan"><c:out value="${todo.kekka}" /></td>
            <td class="no-border haikei">
              <form action="KanryouServlet" method="post" class="haikei">
                <input type="hidden" name="priority" value="<c:out value="${todo.priority}" />">
                <input type="submit" value="UA/Done" class="btn">  
              </form>
             </td>
            <td class="no-border haikei">
              <form action="RemoveServlet" method="post" >
                <input type="hidden" name="priority" value="<c:out value="${todo.priority}" />">
                <input type="submit" value="Del." class="btn">  
              </form>
            
            </td>
          </tr>
        </c:forEach>       
      </table>
      <form action="AllDeleteServlet" method="post">
        <input type="hidden" name="tableName" value="todos">
        <input type="submit" value="All Delete" class="btn">
      </form>
    </main>
    <jsp:include page="common/aside.jsp" />
  </div>

<jsp:include page="common/footer.jsp" />

<script>
'use strict'

const textarea = document.getElementById('myText');
const form = document.getElementById('myForm');
textarea.addEventListener('keydown', function(e) {
	if (e.key === 'Enter' && !e.shiftKey) {
	    e.preventDefault(); 
	    form.requestSubmit(); 
	}
});

document.getElementById('myText').focus();

</script>


</body>
</html>