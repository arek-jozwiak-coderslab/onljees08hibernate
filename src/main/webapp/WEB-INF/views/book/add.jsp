<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Add book</h1>
<form:form method="post" modelAttribute="book">
    <form:input path="title"/>
    <form:input path="rating"/>
    <form:input path="description"/>
    <form:select path="publisher" items="${publishers}"
                 itemLabel="name" itemValue="id"/>
    <input type="submit" value="Save">
</form:form>
</body>
</html>
