<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html>
<html>
<head>
<style>
h1 {
    text-shadow: 2px 2px red;
}

ul {
    padding: 0;
}

li {
    display: inline;
}

li a:hover {
    background-color: black;
}

li a {
	color: white;
    padding: 14px 16px;
    text-decoration: none;
	border-radius: 4px 4px 0 0;
}

table, th, td {
    border: 10px solid blue;
    
}		
</style>
</head>
<body>
<%
String firstName = null;
String lastName = null;
Cookie[] cookies = request.getCookies();
if(cookies !=null){
for(Cookie cookie : cookies){
    if(cookie.getName().equals("firstName")) firstName = cookie.getValue();
    if(cookie.getName().equals("lastName")) lastName = cookie.getValue();

}
}
if(firstName == null) response.sendRedirect("login.html");
%>
<h1 style = "color: white; background-color:#faebd7; font-size: 100px;"> 
<ul style = "display: inline;">
 <li><a href = "change.log">AlumBook</a><li>
</ul>

<ul style = "font-size: 30px; display: inline;">
	
	<li><a href = "AlumPage.jsp">Alumnis</a></li>
	<li><a href = "#students">Students</a></li>
	<li><a href = "account.html">Account</a></li>
	<li><a href = "#chat">Chat</a></li>

</ul>

</h1>

<p> 
<center style = "background-color:#ffdb99; font-size: 50px;">
Welcome <%=firstName %> <%=lastName %>
<br><br>
<form style = "font-size: 30px;"; action="Browse" method="post";>
  Search:
  <input type="text" name="searchName">
  <br>
  <input type="submit" value="Submit">
</form>
<br>
</center>
</p>
<body>
<html>