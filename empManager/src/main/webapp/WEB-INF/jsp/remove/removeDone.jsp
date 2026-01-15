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
      <h2>社員情報削除結果</h2>
	  <p><c:out value="${msg}" /></p>
	  <p>
	    <form action="list" method="get">
	      <input type="submit" value="もどる" class="btn">
	    </form>
	  </p>
   
    </main>
    <jsp:include page="../common/aside.jsp" />
  </div>
<jsp:include page="../common/footer.jsp" />
</body>
</html>