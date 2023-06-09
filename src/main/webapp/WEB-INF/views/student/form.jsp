<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Student Form</title>
</head>
<body>
<h1>Student Form</h1>
<form:form method="post" modelAttribute="student">
    <div>
        Imię: <input type="text" name="firstName"/>
    </div>
    <div>
        Nazwisko: <input type="text" name="lastName"/>
    </div>
    <div>
        Płeć:
        <input type="radio" name="gender" value="M"> Mężczyzna
        <input type="radio" name="gender" value="F"> Kobieta
    </div>
    <div>
        Kraj:
        <select name="country">
            <c:forEach items="${countries}" var="country">
                <option value="${country}">${country}</option>
            </c:forEach>
        </select>
    </div>
    <div>
        Kraj 2:
        <form:select path="country">
            <form:option value="-" label="--Please Select--"/>
            <form:options items="${countries}"/>
        </form:select>
    </div>
    <div>
        Notatka:
        <textarea name="notes" cols="20" rows="20"></textarea>
    </div>
    <div>
        Zgoda na otrzymywanie poczty e-mail:
        <input type="checkbox" name="mailingList">
    </div>
    <div>
        Znajomość:
        <select name="programmingSkills" multiple>
            <option value="java"> Java</option>
            <option value="php"> PHP</option>
            <option value="ruby"> Ruby</option>
            <option value="python"> Python</option>
            <option value="c#"> C#</option>
        </select>
    </div>
    <div>
        Hobby:
        <input type="checkbox" name="hobbies" value="pływanie"> Pływanie
        <input type="checkbox" name="hobbies" value="programowanie"> Programowanie
        <input type="checkbox" name="hobbies" value="jazda na rowerze"> Jazda na rowerze
        <input type="checkbox" name="hobbies" value="kino"> Kino
    </div>
    <input type="submit" value="Wyślij">
</form:form>
</body>
</html>
