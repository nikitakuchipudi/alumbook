<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/project1CSS.css">
<link href='https://fonts.googleapis.com/css?family=Lato:100' rel='stylesheet' type='text/css'>

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
<div class="title">Alumbook</div>

<ul id="nav">
	
	<li><a href = "alumni.jsp">Alumni</a></li>
	<li><a href = "#students">Students</a></li>
	<li><a href = "#account">Account</a></li>
	<li><a href = "#chat">Chat</a></li>

</ul>



<p> 
<center>
<div style="background-color:#eca400; float: left; border-radius: 20px; padding: 10px; margin-left: 500px;
margin-top: 27px; font-size: 30px;
">
<i>Welcome <%=firstName %> <%=lastName %></i>
</div>
<br><br>
<div style="background-color: white; width: 300px; border-radius: 20px; padding-bottom: 10px; padding-top: 20px; margin-top: 27px;">
<form style = "font-size: 30px;">
  Search:
  <input type="text" name="search">
  <br>
  <input type="submit" value="Submit">
</form>
</div>
<br>
</center>
</p>
<body>
<html>