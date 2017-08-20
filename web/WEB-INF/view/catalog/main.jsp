<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" %>


<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="messages" var="i18n"/>
<div class="container">
    <div class="row">
        <c:forEach var="bookVO" items="${bookVOS}">
            <div class="col-lg-4 col-md-6 mb-4">
                <div class="card">
                    <div class="card-body">
                        <h4 class="card-title">${bookVO.book.name}</h4>
                        <p class="card-text">
                            <b>
                                <fmt:message bundle="${i18n}" key="catalog.genre"></fmt:message>:
                            </b>
                                ${bookVO.book.genre}
                        </p>
                    </div>
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item">
                            <b><fmt:message bundle="${i18n}" key="catalog.author"></fmt:message>: </b>
                            <c:forEach var="author" items="${bookVO.authors}" varStatus="status">
                                ${author.name} ${author.surname}
                                <c:if test="${not status.last}">,</c:if>
                            </c:forEach>
                        </li>
                        <li class="list-group-item">
                            <b><fmt:message bundle="${i18n}" key="catalog.year"></fmt:message>: </b>
                                ${bookVO.book.year}</li>
                            <%--<li class="list-group-item">Vestibulum at eros</li>--%>
                    </ul>
                    <div class="card-body">
                        <a href="${pageContext.request.contextPath}/frontController?command=book&id=${bookVO.book.bookID}"
                           class="btn btn-primary">
                            <fmt:message bundle="${i18n}" key="catalog.reserve"></fmt:message>
                        </a>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>