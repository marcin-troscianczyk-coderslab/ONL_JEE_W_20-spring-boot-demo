<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Edit publisher</title>
    <link rel="stylesheet" href="<c:url value='/static/css/style.css'/>">
</head>
<body>

<h3>Edit publisher</h3>

<form:form method="post" modelAttribute="publisher">

    <div>Name: <form:input path="name"/><form:errors path="name" cssClass="error"/></div>
    <div>NIP: <form:input path="nip"/><form:errors path="nip" cssClass="error"/></div>
    <div>REGON: <form:input path="regon"/><form:errors path="regon" cssClass="error"/></div>
    <form:hidden path="id"/>
    <input type="submit" value="Update publisher">
</form:form>

</body>
</html>
