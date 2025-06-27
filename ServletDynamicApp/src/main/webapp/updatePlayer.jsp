<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Player</title>
<style>
  body {
    font-family: Arial, sans-serif;
    text-align: center;
    padding-top: 80px;
  }
  form {
    display: inline-block;
    padding: 20px;
    border: 1px solid #ccc;
    border-radius: 10px;
  }
  input {
    display: block;
    margin: 10px auto;
    padding: 10px;
    width: 250px;
  }
  input[type="submit"] {
    background-color: #007bff;
    color: white;
    border: none;
    cursor: pointer;
  }
  input[type="submit"]:hover {
    background-color: #0056b3;
  }
</style>
</head>
<body>

<%
  ResultSet rs = (ResultSet) request.getAttribute("player");
  rs.next(); // Move cursor to first row
%>

<h1>Enter Updated Player Details</h1>

<form action="update-player" method="post">
  <input type="number" name="playerId" value="<%= rs.getInt(1) %>" readonly><br>
  <input type="text" name="title" value="<%= rs.getString(2) %>" required><br>
  <input type="number" name="age" value="<%= rs.getInt(3) %>" required><br>
  <input type="text" name="team" value="<%= rs.getString(4) %>" required><br>
  <input type="text" name="nationality" value="<%= rs.getString(5) %>" required><br>
  <input type="submit" value="Update Player">
</form>

</body>
</html>
