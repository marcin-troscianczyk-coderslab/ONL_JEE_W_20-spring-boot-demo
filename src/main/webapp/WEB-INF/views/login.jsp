<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Login form</title>
</head>
<body>
<p>Login form</p>
<form method="post">
    Username: <input type="text" name="username">
    Password: <input type="password" name="password">
    <%--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>--%>
    <sec:csrfInput/>
    <input type="submit" value="Zaloguj">
</form>
</body>
</html>
