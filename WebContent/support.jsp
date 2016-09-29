<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Support</title>
</head>
<body>
<jsp:include page="bootstrap.jsp"></jsp:include>
<jsp:include page="navbar.jsp"></jsp:include>
<jsp:include page="footer.jsp"></jsp:include>
	<form role="form" action="support" method="post">
		<div class="form-group">
			<label for="post">Type your Message here (Maximum 200 character):</label>
			<textarea name="message" id="message" class="form-control" rows="2"
				placeholder="We value your feedback!" maxlength="200"></textarea>
		</div>
		<div class="form-group">
			<input type="submit" value="send" id="submit" /> 
			<input type="reset" value="Clear">
		</div>
</form>
</body>
</html>