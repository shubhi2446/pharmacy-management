<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <html>

        <head>
            <title>Book Management Application</title>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        </head>

        <body>

            <header>
                <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
                    <div>
                        <a href="https://www.javaguides.net" class="navbar-brand"> Book Management App </a>
                    </div>

                    <ul class="navbar-nav">
                        <li><a href="<%=request.getContextPath()%>/list" class="nav-link">books</a></li>
                    </ul>
                </nav>
            </header>
            <br>
            <div class="container col-md-5">
                <div class="card">
                    <div class="card-body">
                        <c:if test="${book != null}">
                            <form action="update" method="post">
                        </c:if>
                        <c:if test="${book == null}">
                            <form action="insert" method="post">
                        </c:if>

                        <caption>
                            <h2>
                                <c:if test="${book != null}">
                                    Edit book
                                </c:if>
                                <c:if test="${book == null}">
                                    Add New book
                                </c:if>
                            </h2>
                        </caption>

                        <c:if test="${book != null}">
                            <input type="hidden" title="id" value="<c:out value='${book.id}' />" />
                        </c:if>

                        <fieldset class="form-group">
                            <label>book title</label> <input type="text" value="<c:out value='${book.title}' />" class="form-control" title="title" required="required">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>book author</label> <input type="text" value="<c:out value='${book.author}' />" class="form-control" title="author">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>book status</label> <input type="text" value="<c:out value='${book.status}' />" class="form-control" title="status">
                        </fieldset>

                        <button type="submit" class="btn btn-success">Save</button>
                        </form>
                    </div>
                </div>
            </div>
        </body>

        </html>