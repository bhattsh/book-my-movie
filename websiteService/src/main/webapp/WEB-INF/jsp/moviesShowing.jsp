<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jstl/core_rt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jstl:forEach var="movie" items="${movies}">
		<ul>
			<li><!-- <input type="text" name="movieName" value=${movie.movieName} -->><a href="getMovieDetails?movieName=${movie.movieName}">${movie.movieName}</a></li>
		</ul>
	</jstl:forEach>
</body>
</html>