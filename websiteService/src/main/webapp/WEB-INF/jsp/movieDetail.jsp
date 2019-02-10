<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Movie Details</title>
</head>
<body>
<form action="theatreShowingMovie">
	<div>
		<div>MovieName: ${movie.movieName} </div>
		<div>Director: ${movie.director} </div>
		<div>Description: ${movie.description} </div>
		<div>Release Date: ${movie.releaseDate} </div>
		<div>Running Time ${movie.runtime.hours}:${movie.runtime.minutes} </div>
		<div> ${movie.cast.get(0).name} </div>
		<input type="submit" value="Book Ticket">
	</div>
</form>	
</body>
</html>