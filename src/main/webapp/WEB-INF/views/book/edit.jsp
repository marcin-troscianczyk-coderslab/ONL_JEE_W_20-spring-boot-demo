<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Edit book</title>
    <link rel="stylesheet" href="<c:url value='/static/css/style.css'/>">
</head>
<body>

<h3>Edit book</h3>

<form:form method="post" modelAttribute="book">

    <div>Title: <form:input path="title"/><form:errors path="title" cssClass="error"/></div>
    <div>Description: <form:input path="description"/><form:errors path="description" cssClass="error"/></div>
    <div>Rating: <form:input path="rating" type="number" min="1" max="10"/><form:errors path="rating" cssClass="error"/></div>
    <div>Publisher: <form:select path="publisher.id" items="${publishers}" itemLabel="name" itemValue="id"/><form:errors path="publisher" cssClass="error"/></div>
    <div>Authors: <form:select path="authors" items="${authors}" itemLabel="fullName" itemValue="id"
                               multiple="true"/><form:errors path="authors" cssClass="error"/></div>
    <div>Pages: <form:input path="pages" type="number" min="1" placeholder="Podaj liczbę stron"/><form:errors path="pages" cssClass="error"/></div>
    <div>Category: <form:select path="category.id" items="${categories}" itemLabel="name" itemValue="id"/><form:errors
            path="category" cssClass="error"/></div>
    <form:hidden path="id"/>
    <input type="submit" value="Update book">
</form:form>

</body>
</html>
