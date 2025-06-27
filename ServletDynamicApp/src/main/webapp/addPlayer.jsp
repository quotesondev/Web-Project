<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add New Player</title>
<style>
  body {
    font-family: Arial, sans-serif;
    text-align: center;
    margin-top: 80px;
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
    background-color: #4CAF50;
    color: white;
    border: none;
    cursor: pointer;
  }
  input[type="submit"]:hover {
    background-color: #45a049;
  }
</style>
</head>
<body>
	<h1>Enter the Player Details</h1>
	
	<form action="add-player" method="post">
		<input type="number" placeholder="Player ID" name="playerId" required><br>
		<input type="text" placeholder="Title" name="title" required><br>
		<input type="number" placeholder="Age" name="age" required><br>
		<input type="text" placeholder="Team" name="team" required><br>
		<input type="text" placeholder="Nationality" name="nationality" required><br>
		<input type="submit" value="Add Player">
	</form>
</body>
</html>
