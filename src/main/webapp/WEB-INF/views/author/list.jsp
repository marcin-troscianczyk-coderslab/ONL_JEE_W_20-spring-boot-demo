<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>All authors</title>
</head>
<body>

<table>
  <tr>
    <th>Lp.</th>
    <th>First name</th>
    <th>Last name</th>
    <th>PESEL</th>
    <th>E-mail</th>
  </tr>
  <c:forEach items="${authors}" var="author">
    <tr>
      <td>${author.id}</td>
      <td>${author.firstName}</td>
      <td>${author.lastName}</td>
      <td>${author.pesel}</td>
      <td>${author.email}</td>
      <td><a href="<c:url value='/author/edit?id=${author.id}'/>">Edit</a></td>
      <td><a href="<c:url value='/author/remove?id=${author.id}'/>" onclick="return confirm('Are you sure?')">Remove</a></td>
    </tr>
  </c:forEach>
</table>

<a href="<c:url value='/author/add'/>">Add new author</a>
<a href="<c:url value='/author/search'/>">Search author</a>
<a href="<c:url value='/author/list'/>">List of all authors</a>
</body>
</html>
