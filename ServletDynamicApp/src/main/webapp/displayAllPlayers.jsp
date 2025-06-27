<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Players List</title>
<style>
  body {
    font-family: Arial, sans-serif;
    text-align: center;
    padding: 20px;
  }
  table {
    margin: auto;
    border-collapse: collapse;
    width: 80%;
  }
  th, td {
    border: 1px solid #ccc;
    padding: 10px;
  }
  th {
    background-color: #f2f2f2;
  }
  a {
    color: #007bff;
    text-decoration: none;
  }
  a:hover {
    text-decoration: underline;
  }
  h2 a {
    display: inline-block;
    margin-top: 20px;
  }
</style>
</head>
<body>

<%
  ResultSet rs = (ResultSet) request.getAttribute("players");
%>

<h1>All Player Details</h1>

<table>
  <tr>
    <th>Player ID</th>
    <th>Title</th>
    <th>Age</th>
    <th>Team</th>
    <th>Nationality</th>
    <th>Update</th>
    <th>Delete</th>
  </tr>

  <%
    while (rs != null && rs.next()) {
  %>
    <tr>
      <td><%= rs.getInt("playerId") %></td>
      <td><%= rs.getString("title") %></td>
      <td><%= rs.getInt("age") %></td>
      <td><%= rs.getString("team") %></td>
      <td><%= rs.getString("nationality") %></td>
      <td><a href="find-by-id?id=<%= rs.getInt("playerId") %>">UPDATE</a></td>
      <td><a href="delete-by-id?id=<%= rs.getInt("playerId") %>">DELETE</a></td>
    </tr>
  <%
    }
  %>
</table>

<h2><a href="index.jsp">Go Back to Dashboard</a></h2>

</body>
</html>
