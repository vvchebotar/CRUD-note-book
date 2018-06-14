<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Welcome</title>
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/ bootstrap/3.3.5/css/bootstrap.min.css">
</head>
<body>
<div class="jumbotron">
    <h1>${greeting}</h1>
    <h2>${tagline}</h2>
    <h2>
        <a href="<spring:url value="/books/page?page=1"/>"
           class="btn btn-primary"> <span class="glyphicon-hand-left glyphicon">
			</span> Books
        </a>
    </h2>
</div>
</body>
</html>
