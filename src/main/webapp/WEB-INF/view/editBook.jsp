<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet"
          href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title>Edit Book</title>
</head>
<body>

<section>
    <div class="jumbotron">
        <div class="container">
            <h1>Books</h1>
            <p>Edit book</p>
        </div>
    </div>
</section>
<section class="container">
    <spring:url value="/books/edit" var="url">
        <spring:param name="id" value="${editBook.id}"/>
        <spring:param name="author" value="${editBook.author}"/>
        <spring:param name="currentPage" value="${currentPage}"/>
    </spring:url>
    <form:form method="POST" modelAttribute="editBook" class="form-horizontal" action="${url}">
        <fieldset>
            <legend>Edit book</legend>
            <div class="form-group">
                <label class="control-label col-lg-2" for="title">
                    <spring:message code="addBook.form.title.label"/>
                </label>
                <div class="col-lg-10">
                    <form:input id="title" path="title" type="text" class="form:input-large" />
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-2" for="printYear">
                    <spring:message code="addBook.form.printyear.label"/>
                </label>
                <div class="col-lg-10">
                    <form:input id="printYear" path="printYear" type="text" class="form:input-large"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-2" for="description">
                    <spring:message code="addBook.form.description.label"/>
                </label>
                <div class="col-lg-10">
                    <form:textarea id="description" path="description" rows="2"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-2" for="isbn">
                    <spring:message code="addBook.form.isbn.label"/>
                </label>
                <div class="col-lg-10">
                    <form:input id="isbn" path="isbn" type="text" class="form:input-large"/>
                </div>
            </div>
            <div class="form-group">
                <div class="col-lg-offset-2 col-lg-10">
                    <input type="submit" id="btnAdd" class="btn btn-primary" value="Edit"/>
                </div>
            </div>
        </fieldset>
    </form:form>
</section>
</body>
</html>