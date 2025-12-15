<%@ page import="in.sp.model.User" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="header.jsp" %>

<%
    User user = (User) session.getAttribute("session_user");

    
    if (user == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>

<div class="container mt-5">
  <div class="card shadow-lg p-4 mx-auto" style="max-width: 500px;">
    <h2 class="text-center text-primary mb-4">Welcome, <%= user.getName() %> 👋</h2>

    <table class="table table-bordered">
      <tbody>
        <tr>
          <th scope="row">Name</th>
          <td><%= user.getName() %></td>
        </tr>
        <tr>
          <th scope="row">Email</th>
          <td><%= user.getEmail() %></td>
        </tr>
        <tr>
          <th scope="row">City</th>
          <td><%= user.getCity() %></td>
        </tr>
      </tbody>
    </table>

    <div class="text-center mt-4">
      <a href="Logout" class="btn btn-danger">Logout</a>
    </div>
  </div>
</div>

<%@ include file="footer.jsp" %>
