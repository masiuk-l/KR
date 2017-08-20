<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" %>


<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="messages" var="i18n"/>

<div class="container text-center">
    <div style="font-size: large">
        <c:if test="${not empty requestScope.errorMsg}">INFO : ${message}</c:if> <br/>
    </div>
    <form action="frontController?command=login" method="post">
        <b>Login</b><input name="login" maxlength="30" required/>
        <b>Password</b><input type="password" name="password" maxlength="20" required/><br/>
        <input type="submit" value="Войти">
    </form>
</div>
