<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" %>


<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="messages" var="i18n"/>

<%--<TABLE>--%>
<%--<tr>--%>
<%--<th>№</th>--%>
<%--<th>Surname</th>--%>
<%--<th>Name</th>--%>
<%--</tr>--%>

<%--<c:forEach var="reader" items="${readers}">--%>
<%--<tr>--%>
<%--<td>${reader.readerID}</td>--%>
<%--<td>${reader.surname}</td>--%>
<%--<td>${reader.name}</td>--%>
<%--</tr>--%>
<%--</c:forEach>--%>
<%--</TABLE>--%>
<div class="container text-center">
    <div class="page-header center-block">
        <h1>
            <small><fmt:message bundle="${i18n}" key="error.page_under_construction"/></small>
        </h1>
    </div>
    <img src="assests/img/build.gif" class="rounded w-50">
</div>

<%--<div class="card-columns">--%>
<%--<div class="card">--%>
<%--<div class="card-body">--%>
<%--<h4 class="card-title">Card title that wraps to a new line</h4>--%>
<%--<p class="card-text">This is a longer card with supporting text below as a natural lead-in to additional--%>
<%--content. This content is a little bit longer.</p>--%>
<%--</div>--%>
<%--</div>--%>
<%--<div class="card p-3">--%>
<%--<blockquote class="blockquote mb-0 card-body">--%>
<%--<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer posuere erat a ante.</p>--%>
<%--<footer class="blockquote-footer">--%>
<%--<small class="text-muted">--%>
<%--Someone famous in <cite title="Source Title">Source Title</cite>--%>
<%--</small>--%>
<%--</footer>--%>
<%--</blockquote>--%>
<%--</div>--%>
<%--<div class="card">--%>
<%--<img class="card-img-top" src="${pageContext.request.contextPath}/assests/img/book1.jpg" alt="Card image cap">--%>
<%--<div class="card-body">--%>
<%--<h4 class="card-title">Card title</h4>--%>
<%--<p class="card-text">This card has supporting text below as a natural lead-in to additional content.</p>--%>
<%--<p class="card-text">--%>
<%--<small class="text-muted">Last updated 3 mins ago</small>--%>
<%--</p>--%>
<%--</div>--%>
<%--</div>--%>
<%--<div class="card bg-primary p-3 text-center">--%>
<%--<blockquote class="blockquote mb-0">--%>
<%--<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer posuere erat.</p>--%>
<%--<footer class="blockquote-footer">--%>
<%--<small>--%>
<%--Someone famous in <cite title="Source Title">Source Title</cite>--%>
<%--</small>--%>
<%--</footer>--%>
<%--</blockquote>--%>
<%--</div>--%>
<%--<div class="card text-center">--%>
<%--<div class="card-body">--%>
<%--<h4 class="card-title">Card title</h4>--%>
<%--<p class="card-text">This card has supporting text below as a natural lead-in to additional content.</p>--%>
<%--<p class="card-text">--%>
<%--<small class="text-muted">Last updated 3 mins ago</small>--%>
<%--</p>--%>
<%--</div>--%>
<%--</div>--%>
<%--<div class="card">--%>
<%--<img class="card-img" src="${pageContext.request.contextPath}/assests/img/book1.jpg" alt="Card image">--%>
<%--</div>--%>
<%--<div class="card p-3 text-right">--%>
<%--<blockquote class="blockquote mb-0">--%>
<%--<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer posuere erat a ante.</p>--%>
<%--<footer class="blockquote-footer">--%>
<%--<small class="text-muted">--%>
<%--Someone famous in <cite title="Source Title">Source Title</cite>--%>
<%--</small>--%>
<%--</footer>--%>
<%--</blockquote>--%>
<%--</div>--%>
<%--<div class="card">--%>
<%--<div class="card-body">--%>
<%--<h4 class="card-title">Card title</h4>--%>
<%--<p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional--%>
<%--content. This card has even longer content than the first to show that equal height action.</p>--%>
<%--<p class="card-text">--%>
<%--<small class="text-muted">Last updated 3 mins ago</small>--%>
<%--</p>--%>
<%--</div>--%>
<%--</div>--%>
<%--</div>--%>
