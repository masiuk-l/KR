<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" %>


<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="messages" var="i18n"/>
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
                </ul>
                <div class="card-body">
                    <a href="${pageContext.request.contextPath}/frontController?command=reader&id=${readerVO.reader.readerID}"
                       class="btn btn-primary">
                        <fmt:message bundle="${i18n}" key="admin.show.reader"></fmt:message>
                    </a>
                </div>
            </div>

        </c:forEach>
    </div>
</div>