<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Search books</title>
</head>
<body>
<h3>Search books</h3>
<div>
    <p>Find by title</p>
    <form>
        <label for="title">Title</label><input id="title" name="title" type="text">
        <input type="submit" value="Search">
    </form>
</div>
<hr/>
<div>
    <p>Find by rating</p>
    <form>
        <label for="rating">Rating</label><input id="rating" name="rating" type="number" min="1" step="1" max="10">
        <input type="submit" value="Search">
    </form>
</div>
<hr/>
<div>
    <p>Find by rating between</p>
    <form>
        <label for="min">Min rating</label><input id="min" name="min" type="number" min="1" step="1" max="10">
        <label for="max">Max rating</label><input id="max" name="max" type="number" min="1" step="1" max="10">
        <input type="submit" value="Search">
    </form>
</div>
<hr/>
<div>
    <p>Find by category</p>
    <form>
        <label for="id">Category id</label><input id="id" name="id" type="number" min="1">
        <input type="submit" value="Search">
    </form>
</div>
<hr/>
<div>
    <p>Find by category id</p>
    <form>
        <label for="categoryId">Category id</label><input id="categoryId" name="categoryId" type="number" min="1">
        <input type="submit" value="Search">
    </form>
</div>
<hr/>
<div>
    <p>Find first by category order by title</p>
    <form action="<c:url value='/book/search/category'/>">
        <label for="cid">Category id</label><input id="cid" name="id" type="number" min="1">
        <input type="submit" value="Search">
    </form>
</div>
<hr/>
<div>
    <p>Find by publisher</p>
    <form action="<c:url value='/book/search/publisher'/>">
        <label for="pid">Publisher id</label><input id="pid" name="id" type="number" min="1">
        <input type="submit" value="Search">
    </form>
</div>
<hr/>
<div>
    <p>Find by author</p>
    <form action="<c:url value='/book/search/author'/>">
        <label for="aid">Author id</label><input id="aid" name="id" type="number" min="1">
        <input type="submit" value="Search">
    </form>
</div>
<hr/>
<a href="<c:url value='/book/list'/>">Back to list of all books</a>
</body>
</html>
