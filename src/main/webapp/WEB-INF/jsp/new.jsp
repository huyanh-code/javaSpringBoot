<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add new</title>
    </head>
    <body>
    ${msg}
        <form:form action="addnew" modelAttribute="studentForNewOrUpdate">
            <form:label path="id">ID</form:label></br>
            <form:input path="id" /></br>
            <form:errors path="id"/></br>

            <form:label path="name">Name</form:label></br>
            <form:input path="name"/></br>
            <form:errors path="name"/></br>

            <form:label path="dateOfBirth">Dob</form:label></br>
            <form:input path="dateOfBirth"/></br>
            <form:errors path="dateOfBirth"/></br>

            <form:label path="tuition">Tuition Fee</form:label></br>
            <form:input path="tuition"/></br>
            <form:errors path="tuition"/></br>

            <form:label path="clazz">Clazz</form:label></br>
            <form:input path="clazz"/></br>
            <form:errors path="clazz"/></br>

            <input type="submit"/></br>
             <a href="/students">Cancel</a>
        </form:form>
    </body>
</html>
