<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form:hidden path="id"/>
<form:input path="title"/>
<form:input path="rating"/>
<form:input path="description"/>
<form:select path="publisher" items="${publishers}"
             itemLabel="name" itemValue="id"/>
