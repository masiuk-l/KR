<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<TABLE>
    <tr>
        <th>№</th>
        <th>Order Id</th>
        <th>User id</th>
        <th>Sum</th>
    </tr>

    <c:forEach var="reader" items="${readers}" varStatus="status">
        <tr>
            <td>${status.index + 1}</td>
            <td>${reader.id}</td>
            <td>${reader.surname}</td>
            <td>${reader.name}</td>
        </tr>
    </c:forEach>
</TABLE>
