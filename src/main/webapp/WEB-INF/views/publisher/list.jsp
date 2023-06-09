<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>All publishers</title>
</head>
<body>

<table>
  <tr>
    <th>Lp.</th>
    <th>Name</th>
    <th>NIP</th>
    <th>REGON</th>
  </tr>
  <c:forEach items="${publishers}" var="publisher">
    <tr>
      <td>${publisher.id}</td>
      <td>${publisher.name}</td>
      <td>${publisher.nip}</td>
      <td>${publisher.regon}</td>
      <td><a href="edit?id=${publisher.id}">Edit</a></td>
      <td><a href="remove?id=${publisher.id}" onclick="return confirm('Are you sure?')">Remove</a></td>
    </tr>
  </c:forEach>
</table>

</body>
</html>

