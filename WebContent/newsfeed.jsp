<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>NewsFeed</title>
</head>
<body>
	<jsp:include page="bootstrap.jsp"></jsp:include>
	<jsp:include page="navbar.jsp"></jsp:include>


	<div class="container">

		<table class="table table-bordered table-striped table-hover"
			id="myTable">
			<thead>
				<tr>
					<th>User</th>
					<th>Post</th>
					<th>Date</th>
				</tr>
			</thead>
			<tbody>
				<%if ((null==request.getParameter("searchtext"))) {%>
				<%if (("my").equals(request.getParameter("action"))) {%>
				<c:forEach var="post" items="${posts}">
					<tr>
						<td><img alt="${post.bhuser.useremail}" src="${gravatarURLsmall.getGravatarURL(post.bhuser.useremail, 25)}" /><a
							href="ProfileServlet?action=viewprofile&userid=<c:out value="${post.bhuser.bhuserid}"/>"><c:out
									value="${post.bhuser.useremail}" /></a></td>
						<td><c:out value="${post.posttext}" /></td>
						<td><fmt:formatDate value="${post.postdate}"
								pattern="yy-MMM-dd" /></td>
					</tr>
				</c:forEach>

				<%}else{ %>
				<c:forEach var="post" items="${allPosts}">
					<tr>
						<td><img alt="${post.bhuser.useremail}" src="${gravatarURLsmall.getGravatarURL(post.bhuser.useremail, 25)}" /><a
							href="ProfileServlet?action=viewprofile&userid=<c:out value="${post.bhuser.bhuserid}"/>"><c:out
									value="${post.bhuser.useremail}" /></a></td>
						<td><c:out value="${post.posttext}" /></td>
						<td><fmt:formatDate value="${post.postdate}"
								pattern="yy-MMM-dd" /></td>
					</tr>
				</c:forEach>
				<%} %>
				<%}else{ %>
				<c:forEach var="post" items="${searchPosts}">
					<tr>
						<td><img alt="${post.bhuser.useremail}" src="${gravatarURLsmall.getGravatarURL(post.bhuser.useremail, 25)}" /><a
							href="ProfileServlet?action=viewprofile&userid=<c:out value="${post.bhuser.bhuserid}"/>"><c:out
									value="${post.bhuser.useremail}" /></a></td>
						<td><c:out value="${post.posttext}" /></td>
						<td><fmt:formatDate value="${post.postdate}"
								pattern="yy-MMM-dd" /></td>
					</tr>
				</c:forEach>
				<%} %>

			</tbody>
		</table>

	</div>



	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>