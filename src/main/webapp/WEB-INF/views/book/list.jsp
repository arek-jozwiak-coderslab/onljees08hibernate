<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: arek
  Date: 28.06.2022
  Time: 14:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="<c:url  value="/book-form/add"/> ">Dodaj </a>
<table>
  <tr>
    <th>Id</th>
    <th>title</th>
    <th>rating</th>
    <th>description</th>
    <th>publisher</th>
    <th>Akcje</th>
  </tr>
  <c:forEach var="book" items="${books}">
    <tr>
      <td>${book.id}</td>
      <td>${book.title}</td>
      <td>${book.rating}</td>
      <td>${book.description}</td>
      <td>${book.publisher.name}</td>
      <td>
        <a href="<c:url  value="/book-form/confirm?id=${book.id}"/> ">Usuń </a>
        <a href="<c:url  value="/book-form/edit?id=${book.id}"/> ">Edytuj </a>
      </td>
    </tr>
  </c:forEach>
</table>
</body>
</html>
