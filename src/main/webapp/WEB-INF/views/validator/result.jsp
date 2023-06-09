<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Wynik walidacji</title>
</head>
<body>
<h2>Wynik walidacji</h2>
<table>
    <tr>
        <th>Niepoprawne pole</th>
        <th>Komunikat</th>
    </tr>
    <c:forEach items="${violations}" var="violation">
        <tr>
            <td>${violation.propertyPath}</td>
            <td>${violation.message}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
