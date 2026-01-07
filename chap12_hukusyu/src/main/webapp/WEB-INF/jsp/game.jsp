<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Map Game</title>
</head>
<body>
  <table border="1">
    <c:forEach var="y" begin="0" end="${game.ysize - 1}">
      <tr>
        <c:forEach var="x" begin="0" end="${game.xsize - 1}">
          <c:choose>
            <c:when test="${player.py == y && player.px ==x }">
              <td>@</td>
            </c:when>
              <c:otherwise>
                <td>${game.map[y][x]}</td>
              </c:otherwise>
          </c:choose>
        </c:forEach>
      </tr>
    </c:forEach>
      </table>
    <hr>
    <form action="GameServlet" method="post">
      <button type="submit" name="dir" value="up">↑</button>
      <button type="submit" name="dir" value="left">←</button>
      <button type="submit" name="dir" value="right">→</button>
      <button type="submit" name="dir" value="down">↓</button>
    </form>
  
  

</body>
</html>