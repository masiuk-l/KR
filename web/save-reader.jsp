<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 13.08.2017
  Time: 23:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>save-reader</title>
</head>
<body>
<form action="/library/saveReader" method="post">
    <p>Фамилия</p>
    <input name="surname">
    <p>Имя</p>
    <input name="name">
    <p>Отчество</p>
    <input name="secondName">
    <p>Дата рождения</p>
    <input type="date" name="birthday">
    <p>Пол</p>
    <input name="gender">
    <p>Почта</p>
    <input type="email" name="email">
    <p>Пароль</p>
    <input type="password" name="password">

    <input type="submit" value="Сохранить">
</form>
</body>
</html>
