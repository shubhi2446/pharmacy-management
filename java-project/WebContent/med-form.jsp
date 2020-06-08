<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <html>

        <head>
            <title>Pharmacy Management Application</title>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        </head>

        <body>

            <header>
                <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
                    <div>
                        <a href="https://www.javaguides.net" class="navbar-brand"> Pharmacy Management App </a>
                    </div>

                    <ul class="navbar-nav">
                        <li><a href="<%=request.getContextPath()%>/list">Med</a></li>
                    </ul>
                </nav>
            </header>
            <br>
            <div class="container col-md-5">
                <div class="card">
                    <div class="card-body">
                        <c:if test="${med != null}">
                            <form action="update" method="post">
                        </c:if>
                        <c:if test="${med == null}">
                            <form action="insert" method="post">
                        </c:if>

                        <caption>
                            <h2>
                                <c:if test="${med != null}">
                                    Edit Med details
                                </c:if>
                                <c:if test="${med == null}">
                                    Add New Med
                                </c:if>
                            </h2>
                        </caption>

                        <c:if test="${med != null}">
                            <input type="hidden" name="med_id" value="<c:out value='${med.med_id}' />" />
                        </c:if>

                        <fieldset class="form-group">
                            <label>Med Name</label> <input type="text" value="<c:out value='${med.med_name}' />" class="form-control" name="med_name" required="required">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>med Category</label> <input type="text" value="<c:out value='${med.category}' />" class="form-control" name="category">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Med Price</label> <input type="text" value="<c:out value='${med.price}' />" class="form-control" name="price">
                        </fieldset>
                        <fieldset class="form-group">
                            <label>Exp Date</label> <input type="text" value="<c:out value='${med.exp_date}' />" class="form-control" name="exp_date">
                        </fieldset>

                        <button type="submit" class="btn btn-success">Save</button>
                        </form>
                    </div>
                </div>
            </div>
        </body>

        </html>