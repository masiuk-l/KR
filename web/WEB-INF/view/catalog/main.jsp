<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<div class="container">
    <div class="row">
        <c:forEach var="book" items="${books}">
            <div class="col-lg-4 col-md-6 mb-4">
                <div class="card h-100">
                    <div class="card-body">
                        <h4 class="card-title"><a href="#">${book.name}</a></h4>
                        <h5>${book.year}</h5>
                        <p class="card-text">${book.genre}</p>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>