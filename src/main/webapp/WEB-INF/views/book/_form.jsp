<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form:hidden path="id"/>
<label>
    Podaj tytuł:
<form:input path="title"/>
</label>
<form:errors path="title"/><br/>
<form:input path="rating"/><br/>
<form:errors path="rating"/><br/>
<form:input path="description"/><br/>
<form:select path="publisher" items="${publishers}"
             itemLabel="name" itemValue="id"/>

<form:checkboxes path="authors" items="${authors}"
             itemLabel="lastName" itemValue="id"/>
<form:errors path="authors"/><br/>

