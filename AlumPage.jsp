<!DOCTYPE html>
<html>
<head>
<style>
h1 {
    text-shadow: 2px 2px red;
}

ul {
    padding: 0;
	overflow: auto;
	list-style-type: none;
}

div.shadow {
	width: 250px;
	box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
	text-align: center;
	text-decoration: none;
	background-color: white;
}
div.container {
	text-size: 30px;
	color: black;
	padding: 10px;
}

li {
    display: inline;
}

li a.active {
    background-color: #4CAF50;
    color: white;
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
<h1 style = "color: white; background-color:#faebd7; font-size: 100px;"> 
<ul style = "display: inline;">
 <li><a href = "change.log">AlumBook</a><li>
</ul>

<ul style = "font-size: 30px; display: inline;">
	
	<li><a class = "active" href = "AlumPage.jsp">Alumnis</a></li>
	<li><a href = "#students">Students</a></li>
	<li><a href = "account.html">Account</a></li>
	<li><a href = "#chat">Chat</a></li>
	<li><a href = "change.log">Sign Out</a></li>

</ul>
</h1>
<p >
<center style = "background-color:#ffdb99;">
<br>
<div class = "shadow">
	<img src="image/face1.jpg" alt="Ariel" style="width:100%;">
	<div class = "container">
		<p><a style = "text-decoration: none;" href = "#ariel">Ariel</a></P>
	</div>
</div>
<br>
<div class = "shadow">
	<img src="image/face2.jpg" alt="Gabe" style="width:100%;">
	<div class = "container">
	<p><a style = "text-decoration: none;" href = "#gabe">Gabe</a></P>
	</div>
</div>
<br>
<div class = "shadow">
	<img src="image/face3.jpg" alt="Max" style="width:100%;">
	<div class = "container">
	<p><a style = "text-decoration: none;" href = "#maX">Max</a></P>
	</div>
</div>
<br>
<div class = "shadow">
	<img src="image/face4.jpg" alt="Tom" style="width:100%;">
	<div class = "container">	
	<p><a style = "text-decoration: none;" href = "#tom">Tom</a></P>
	</div>
</div>
<br>
</center>
</p>
<body>
<html>