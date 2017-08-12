<%@ page import="entities.Reader" %>
<%@ page import="service.ReaderService" %>
<%@ page import="service.impl.ReaderServiceImpl" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Readers</title>
</head>
<body>
<%
    ReaderService readerService = new ReaderServiceImpl();
    List<Reader> readers = readerService.getAll();
    request.setAttribute("readers", readers);
%>

<table border="1" about="">
    <c:forEach var="reader" items="${requestScope.get(\"readers\")}">
        <tr>
            <td>${reader.name}</td>
            <td>${reader.surname}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
