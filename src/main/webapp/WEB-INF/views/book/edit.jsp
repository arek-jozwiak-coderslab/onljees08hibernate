<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Edit book</h1>
<form:form method="post" modelAttribute="book">
    <%@include file="_form.jsp" %>
    <input type="submit" value="Update">
</form:form>
</body>
</html>
