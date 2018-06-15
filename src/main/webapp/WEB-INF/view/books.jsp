<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet"
          href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title>Books</title>
</head>
<body>
<section>
    <div class="row">
        <div class="col-xs-12 col-sm-9">
            <div class="jumbotron">
                <div class="container text-center">
                    <h1>My book list</h1>
                    <p>
                        <a href="<spring:url value="/books/add?currentPage=${currentPage}" />" class="btn btn-primary">
                            <span class="glyphicon-hand-left glyphicon"> </span>
                            Add New Book
                        </a>
                    </p>
                </div>
            </div>
        </div>
        <div class="col-xs-12 col-sm-3">
            <div class="jumbotron">
                <div class="container text-center">
                    <spring:url value="/books/filter" var="url"/>
                    <form method="GET" class="form-horizontal" action="${url}">
                        <fieldset>
                            <div class="form-group">
                                <label class="control-label col-*-1" for="searchFromYear">
                                    <p><spring:message code="addBook.form.minprintyear.label"/></p>

                                </label>
                                <div class="col-*-2">
                                    <input id="searchFromYear" name="searchFromYear" type="text"
                                           class="form:input-medium"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-*-1" for="searchToYear">
                                    <p>
                                        <spring:message code="addBook.form.maxprintyear.label"/>
                                    </p>
                                </label>
                                <div class="col-*-2">
                                    <input id="searchToYear" name="searchToYear" type="text" class="form:input-medium"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-*-offset-2 col-*-1">
                                    <input type="submit" id="btnAdd" class="btn btn-primary" value="Find"/>
                                </div>
                            </div>
                        </fieldset>
                    </form>
                </div>
            </div>
        </div>
    </div>
</section>
<section class=" container        ">
    <div class="row">
        <c:forEach items="${books}" var="book">
            <div class="col-sm-6 col-md-3 text-center" style="padding-bottom: 15px">
                <div class="thumbnail">
                    <div class="caption justify-content-center">
                        <h3>${book.title}</h3>
                        <p>${book.author}</p>
                        <p>${book.printYear}</p>
                        <p>
                            <a href=" <spring:url value="/books/book?id=${book.id}&currentPage=${currentPage}" /> "
                               class="btn btn-primary"> <span
                                    class="glyphicon-info-sign glyphicon"/></span>
                                Description
                            </a>
                        </p>
                        <p>
                            <a href=" <spring:url value="/books/edit?id=${book.id}&currentPage=${currentPage}" />"
                               class="btn btn-primary">
                                <span class="glyphicon glyphicon-pencil"> Edit </span>
                            </a>
                        </p>
                        <p>
                            <a href=" <spring:url value="/books/mark?id=${book.id}&currentPage=${currentPage}" /> "
                               class="btn btn-primary">
                                <span class="glyphicon glyphicon-ok"> Mark </span>
                            </a>
                        </p>
                        <p>
                            <a href=" <spring:url value="/books/remove?id=${book.id}&currentPage=${currentPage}" /> "
                               class="btn btn-primary" style="color: black;">
                                                            <span class="glyphicon glyphicon-trash"
                                                                  style="color: red;"/> Delete
                            </a>
                        </p>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
    <nav class="text-center">
        <ul class="pagination">
            <c:forEach items="${pages}" var="page">
                <li>
                    <a href="<spring:url value="/books/page?page=${page}"/>"> ${page} </a>
                </li>
            </c:forEach>
        </ul>
    </nav>
</section>
</body>
</html>