<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <aside>
      <h2>Add Todolist</h2>

      
      <form id="myForm" action="CreateServlet" method="post">
        <textarea id="myText" name="do" placeholder="things to do" rows="5" ></textarea>
        <input type="submit" value="Register" class="btn">
      </form>
      <p>${msg}</p>
    </aside>