<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<jsp:include page="bootstrap.jsp"></jsp:include>
</head>
<body>
	<script>
		function verifyPassword() {

			var password = document.getElementById("password").value;
			if (password.length > 15) {
				alert('That password is too long.');
			}
		}
		function validateEmail(email) {
			// http://stackoverflow.com/a/46181/11236

			var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
			return re.test(email);
		}
	</script>
	<!--  <h1>login</h1>-->
	<div class="container">
		<form class="form-signin" action="process_form" method="post"
			onsubmit="return verifyPassword()">
			<h2 class="form-signin-heading">${message}Please sign in</h2>
			<label for="inputEmail" class="sr-only">Email address</label>
			<input class="form-control" placeholder="Email address" type="email" id="inputEmail" name="useremail" required autofocus> 
			<br>
			<label for="inputPassword" class="sr-only">Password </label>
			<input class="form-control" placeholder="Password"  id="inputPassword" type="password" name="password" id="password"> 
			<br>
			<button class="btn btn-lg btn-primary btn-block" type="submit" value="Submit">Sign in</button>
		</form>
		<br><a href="adduser.jsp">Sign Up</a>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>>
</body>
</html>