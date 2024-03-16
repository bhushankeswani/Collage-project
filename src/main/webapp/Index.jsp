<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
</head>
<body>
<%
	response.setHeader("Cache-Control","no-cache,must-revalidate,no-store");
	response.setHeader("Pragma","no-cache");
	response.setHeader("Expires", "0");
	if(session.getAttribute("username")==null)
	{
		response.sendRedirect("login.jsp");
	}
	
%>
	Welcome ${username}
	<form action="Logout">
		<input type="submit" value="Logout">
	</form>
</body>
</html>