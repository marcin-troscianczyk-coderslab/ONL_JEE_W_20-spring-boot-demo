<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Search authors</title>
</head>
<body>
<h3>Search authors</h3>
<div>
    <p>Find by email</p>
    <form>
        <label for="email">Email</label><input id="email" name="email" type="text">
        <input type="submit" value="Search">
    </form>
</div>
<hr/>
<div>
    <p>Find by pesel</p>
    <form>
        <label for="pesel">PESEL</label><input id="pesel" name="pesel" type="text">
        <input type="submit" value="Search">
    </form>
</div>
<hr/>
<a href="<c:url value='/author/list'/>">Back to list of all authors</a>
</body>
</html>
