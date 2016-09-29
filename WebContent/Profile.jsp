<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>My Profile</title>
</head>
<body>
	<jsp:include page="bootstrap.jsp"></jsp:include>
	<jsp:include page="navbar.jsp"></jsp:include>

	<script>
		window.onload = function() {
			$('#update').hide();
	<%if (("editprofile").equals(request.getParameter("action"))) {%>
		$("#useremail").removeAttr("disabled");
			$("#password").removeAttr("disabled");
			$("#username").removeAttr("disabled");
			$("#motto").removeAttr("disabled");
			$('#update').show();
	<%}%>
		};
	</script>

	<center>
		<form action="ProfileServlet" method="post"
			onsubmit="return verifyPassword()">
			&nbsp;&nbsp;&nbsp;&nbsp;Name: &nbsp; <input id="username" name="username" type="text"
				value="${sessionScope.user.username}" disabled /><br>
			<br>
			<br> &nbsp;&nbsp;&nbsp;Email: &nbsp; <input id="useremail" name="useremail"
				type="text" value="${sessionScope.user.useremail}" disabled /><br>
			<br>
			<br> Password: &nbsp; <input id="password" name="password"
				type="text" value="${sessionScope.user.userpassword}" disabled /><br>
				<br> &nbsp;&nbsp;&nbsp;&nbsp;Moto: &nbsp; <input id="motto" name="motto"
				type="text" value="${sessionScope.user.motto}" disabled /><br>
			<br>
			<button id="update" type="submit" value="Submit" >
				<font color="blue">Update</font>
			</button>
		</form>

	</center>
	<!-- Actual: ${pageContext.session.id}-->
	<div></div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>