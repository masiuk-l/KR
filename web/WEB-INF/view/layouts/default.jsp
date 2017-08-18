<?xml version="1.0" encoding="UTF-8"?>
<html xmlns:jsp="http://java.sun.com/JSP/Page"
      xmlns:c="http://java.sun.com/jsp/jstl/core"
      xmlns:u="urn:jsptagdir:/WEB-INF/tags/utils"
      xmlns:com="urn:jsptagdir:/WEB-INF/tags/common">

<jsp:directive.page pageEncoding="UTF-8" contentType="text/html; UTF-8"/>
<head>
    <![CDATA[
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assests/css/style.css" type="text/css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/assests/js/utils.js" type="text/javascript"><jsp:text/></script>
    ]]>
    <style>
        footer {
            background-color: #eef1ff;
            padding: 25px;
        }
    </style>
    <title>${title}</title>
    <u:icon file="icon.png"/>
</head>
<body>
<com:header-navigation/>
<div style="height: 56px"></div>
<div>
    <div class="container text-center">
        <c:url var="bodyUrl" value="../login.jsp"></c:url>
        <c:if test="${not empty sessionScope.pagePath}">
            <c:url var="bodyUrl" value='../${sessionScope.pagePath}'></c:url>
        </c:if>
        <jsp:include page="${bodyUrl}"/>
    </div>
</div>
<jsp:directive.include file="../common/footer.jspx"/>
</body>
</html>