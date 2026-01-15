<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>    
<!DOCTYPE html>
<html>
<jsp:include page="../common/head.jsp" />
<body>
<jsp:include page="../common/header.jsp" />

<div class="container center-align">
  <main>  
    <h2>社員情報削除確認</h2>
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
    <form action="RemoveDoneServlet" method="post">
      <input type="hidden" name="id" value="<c:out value="${emp.id}" />">
      <input type="submit" formaction="list" formmethod="get" value="もどる">
      <input type="submit" value="削除"> 
    </form>
    <p>このデータを削除します。よろしいですか？</p>
    <ul class="error">
      <c:forEach var="error" items="${errorList}">
    	  <li><c:out value="${error}" /></li>
      </c:forEach>
    </ul>
  </main>
	<jsp:include page="../common/aside.jsp" />
</div>  

<jsp:include page="../common/footer.jsp" />
</body>
</html>