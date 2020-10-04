<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="au.com.prince.bean.MovieCollector" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Prince's Theatre</title>

</head>
<body>
<%@include file="header.jsp"%>
<h2>Classic Movies At Home</h2>
<table class = "center" border="0">
	<tr>
		<th colspan="2">Please select the movie you want to buy!</th>
	</tr>
<% int i = 0; %>
<c:forEach var = "movie" items = "${moviesList.movies}">
	<% if (i == 0) { %>
	<tr>
	<% i++; %>
	<% } %>
	<% if (i <= 2) { %>
	<td><a href="/ClassicMovies/${movie.getId()}">${movie.getTitle()}</a></td>
	<% i++; %>
	<% } else { %>
	</tr>
	<% i=0; %>
	<% } %>
</c:forEach>

</table>
<%@include file="footer.jsp"%>
</body>
</html>