<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<jsp:useBean id="now" class="java.util.Date" scope="page"/>

<fmt:formatDate value='${now}' pattern='yyyy-MM-dd' var="searchFormated"/>
<c:set var="strDate" value="${searchFormated}"/>

<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="messages" var="i18n"/>

<script>
    var ban = '<fmt:message bundle="${i18n}" key="reader.ban"></fmt:message>';
    var unban = '<fmt:message bundle="${i18n}" key="reader.unban"></fmt:message>';
</script>

<div class="container">
    <div class="card-columns">

        <c:forEach var="readerVO" items="${readerVOS}">
            <%--<div class="col-lg-4 col-md-6 mb-4">--%>
            <div class="card">
                <div class="card-body">
                    <h4 class="card-title">${readerVO.reader.surname} ${readerVO.reader.name} ${readerVO.reader.secondName}</h4>
                </div>
                <ul class="list-group list-group-flush">
                    <li class="list-group-item">
                        <b><fmt:message bundle="${i18n}" key="login.gender"></fmt:message>: </b>
                        <c:choose>
                            <c:when test="${readerVO.reader.gender eq 'male'}">
                                <fmt:message bundle="${i18n}" key="login.gender.male"></fmt:message>
                            </c:when>
                            <c:otherwise>
                                <fmt:message bundle="${i18n}" key="login.gender.female"></fmt:message>
                            </c:otherwise>
                        </c:choose>

                            <%--<c:forEach var="author" items="${bookVO.authors}" varStatus="status">--%>
                            <%--${author.name} ${author.surname}--%>
                            <%--<c:if test="${not status.last}">,</c:if>--%>
                            <%--</c:forEach>--%>
                    </li>
                    <li class="list-group-item">
                        <b><fmt:message bundle="${i18n}" key="login.birthday"></fmt:message>: </b>
                            ${readerVO.reader.birthday}</li>
                        <%--<li class="list-group-item">V</li>--%>
                    <li class="list-group-item">
                        <b><fmt:message bundle="${i18n}" key="reader.books"></fmt:message>: </b>
                        <ul class=" list-group list-unstyled">
                            <c:forEach var="formVO" items="${readerVO.formVOS}">
                                <li class="">
                                    <c:choose>
                                        <c:when test="${formVO.form.returnDate gt strDate}">
                                            <i class="fa fa-check-circle-o"></i> ${formVO.bookVO.book.name}
                                        </c:when>
                                        <c:otherwise>
                                            <i class="fa fa-times-circle-o"></i> ${formVO.bookVO.book.name}
                                        </c:otherwise>
                                    </c:choose>
                                </li>
                            </c:forEach>
                        </ul>
                    </li>
                </ul>
                <div class="card-body">
                    <c:choose>
                        <c:when test="${readerVO.reader.status eq 'BANNED'}">
                            <button id="${readerVO.reader.readerID}" class="btn btn-primary ban-reader">
                                <fmt:message bundle="${i18n}" key="reader.unban"></fmt:message>
                            </button>
                        </c:when>
                        <c:otherwise>
                            <button id="${readerVO.reader.readerID}" class="btn btn-primary ban-reader">
                                <fmt:message bundle="${i18n}" key="reader.ban"></fmt:message>
                            </button>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </c:forEach>
    </div>
</div>