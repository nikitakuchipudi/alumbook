<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
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
<body>
<h1 style = "color: white; background-color:#faebd7; font-size: 100px;"> 
<ul style = "display: inline;">
 <li><a href = "change.log">AlumBook</a><li>
</ul>

<ul style = "font-size: 30px; display: inline;">
	
	<li><a href = "alumni.html">Alumnis</a></li>
	<li><a href = "#students">Students</a></li>
	<li><a href = "account.html">Account</a></li>
	<li><a href = "#chat">Chat</a></li>

</ul>

</h1>
<c: out value="WITH JSTL"/><br>
    <table>
        <tr>
          <%-- WITH JSTL: Assume that the array list was set from a servlet, and not from above --%>
          <c:forEach var="names" items="${requestScope['namesList']}">
            <c: out value="${names},"/>
          </c:forEach>        
        </tr>
    </table>
</body>
</html>