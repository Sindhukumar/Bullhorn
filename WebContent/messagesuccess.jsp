<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Message Sent</title>
</head>
<body>
<jsp:include page="bootstrap.jsp"></jsp:include>
<jsp:include page="navbar.jsp"></jsp:include>

<h1>Your message has been sent successfully!</h1>
<%
		String message = (String) session.getAttribute("message");
	%>
	<div><p>
	<%=message%></p>
	</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>