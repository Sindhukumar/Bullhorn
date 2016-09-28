<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%model.Bhuser us = (model.Bhuser)session.getAttribute("user");%>
<%=us.getUsername()%>
<form action="Home" method="get">
 Comment:<br>
 <input type="text" maxlength="141" name="comment">
 <br>
 <input type="submit" value="Submit">
</form>

</body>
</html>