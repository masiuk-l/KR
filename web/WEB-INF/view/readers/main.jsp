<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<TABLE>
    <tr>
        <th>№</th>
        <th>Surname</th>
        <th>Name</th>
    </tr>

    <c:forEach var="reader" items="${readers}">
        <tr>
            <td>${reader.readerID}</td>
            <td>${reader.surname}</td>
            <td>${reader.name}</td>
        </tr>
    </c:forEach>
</TABLE>
