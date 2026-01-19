<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>todoリスト</title>
</head>
<body>
<h1>todoリスト</h1>
<p>
<c:out value="${loginUser.name}" />さん、おはようございます。

</p>

      <table>
        <tr>
          <th>優先事項</th>
          <th>todo</th>
          <th>結果</th>
          <th class="no-border"></th>
          <th class="no-border"></th>
        </tr>
        <c:forEach var="emp" items="${todoList}">
          <tr>
<!--            <td><c:out value="${todo.priority}" /></td>-->
<!--            <td><c:out value="${todo.todo}" /></td>-->
<!--            <td><c:out value="${todo.kekka}" /></td>-->
            <td>1</td>
            <td>夕飯の材料を買いに行く</td>
            <td>未定</td>
            <td class="no-border">
              <form action="UpdateServlet" method="post">
                <input type="hidden" name="id" value="<c:out value="${todo.priority}" />">
                <input type="submit" value="編集" class="btn">  
              </form>
             </td>
            <td class="no-border">
              <form action="RemoveServlet" method="post">
                <input type="hidden" name="id" value="<c:out value="${todo.priority}" />">
                <input type="submit" value="削除" class="btn">  
              </form>
            
            </td>
          </tr>
        </c:forEach>       
      </table>




</body>
</html>