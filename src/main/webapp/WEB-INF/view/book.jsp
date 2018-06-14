<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet"
          href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title>Products</title>
</head>
<body>
<section>
    <div class="jumbotron">
        <div class="container">
            <h1>Book</h1>
        </div>
    </div>
</section>
<section class="container">
    <div class="row">
        <div class="col-md-5">
            <h3>${book.title} (${book.printYear}) by ${book.author}</h3>
            <p>
                <strong>description</strong>: ${book.description}
            </p>
            <p>
                <strong>ISBN</strong> : ${book.isbn}
            </p>
            <p>
                <a href="<spring:url value="/books/page?page=${currentPage}" />" class="btn btn-default">
                    <span class="glyphicon-hand-left glyphicon"></span> back to Books
                </a>
            </p>
        </div>
    </div>
</section>
</body>
</html>