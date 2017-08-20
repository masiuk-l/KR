<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="messages" var="i18n"/>

<div class="col-sm-12">
    <div class="card">
        <div class="card-header p-b-0">
            <h5 class="card-title"><i class="fa fa-book"></i> ${bookVO.book.name}</h5>
        </div>

        <div class="list-group list-group-flush">
            <li class="list-group-item"><b><fmt:message bundle="${i18n}" key="catalog.author"></fmt:message>: </b>
                <c:forEach var="author" items="${bookVO.authors}" varStatus="status">
                    ${author.name} ${author.surname}
                    <c:if test="${not status.last}">,</c:if>
                </c:forEach>
            </li>
            <li class="list-group-item"><b><fmt:message bundle="${i18n}" key="catalog.genre"></fmt:message>: </b>
                ${bookVO.book.genre}
            </li>
            <li class="list-group-item"><b><fmt:message bundle="${i18n}" key="catalog.year"></fmt:message>: </b>
                ${bookVO.book.year}
            </li>
            <li class="list-group-item"><b><fmt:message bundle="${i18n}" key="catalog.isbn"></fmt:message>: </b>
                ${bookVO.book.isbn}
            </li>

        </div>
        <!-- логика! -->
        <c:set var="flag" value="false"></c:set>
        <c:if test="${not empty user}">
            <c:forEach var="reader" items="${bookVO.readers}">
                <c:if test="${reader.readerID eq user.readerID}">
                    <c:set var="flag" value="true"></c:set>
                </c:if>
            </c:forEach>
        </c:if>
        <!-- логика! -->

        <c:choose>
            <c:when test="${flag eq \"true\"}">
                <button class="btn  disabled">Вы уже заказали эту книгу</button>
            </c:when>
            <c:when test="${bookVO.book.quantity eq 0}">
                <button class="btn disabled">Нет в наличии</button>
            </c:when>
            <c:otherwise>
                <button class="btn btn-primary">Заказать</button>
            </c:otherwise>
        </c:choose>

    </div>
</div>
