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
      <h2>新規社員登録</h2>
      <form action="CreatConfirm" method="post">
        <table>
         <tr>
           <th>ID</th>
           <td><input type="text" name="id" value=""></td>
         </tr>
         <tr>
           <th>名前</th>
           <td><input type="text" name="name" value=""></td>
         </tr>
         <tr>
           <th>年齢</th>
           <td><input type="text" name="age" value=""></td>
         </tr>
        </table>
        <input type="submit" formaction="" value="取消">
        <input type="submit" value="確認">
      </form>
    
    </main>
    <jsp:include page="../common/aside.jsp" />
  </div>
<jsp:include page="../common/footer.jsp" />
</body>
</html>