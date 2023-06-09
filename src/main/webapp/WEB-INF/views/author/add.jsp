<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add author</title>
    <link rel="stylesheet" href="<c:url value='/static/css/style.css'/>">
</head>
<body>

<h3>Add author</h3>

<form:form method="post" modelAttribute="author">

    <div>First name: <form:input path="firstName"/><form:errors path="firstName" cssClass="error"/></div>
    <div>Last name: <form:input path="lastName"/><form:errors path="lastName" cssClass="error"/></div>
    <div>PESEL: <form:input path="pesel"/><form:errors path="pesel" cssClass="error"/></div>
    <div>E-mail: <form:input path="email" type="email"/><form:errors path="email" cssClass="error"/></div>
    <input type="submit" value="Add author">
</form:form>

</body>
</html>
