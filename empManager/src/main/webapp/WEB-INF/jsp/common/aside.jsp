<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <aside>
      <h2>補助機能</h2>
      <form action="CreateServlet" method="get">
        <input type="submit" value="新規登録" class="btn">
      </form>
      
      <form action="FindNameServlet" method="post">
        <input type="text" name="name" placeholder="名前">
        <input type="submit" value="検索" class="btn">
      </form>
    </aside>