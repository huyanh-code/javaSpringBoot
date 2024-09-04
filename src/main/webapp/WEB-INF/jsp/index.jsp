<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <a href="students/chuanbinew">New New</a>
        <c:if test="${empty sinhViens}">
            no data
        </c:if>
        <c:if test="${not empty sinhViens}">
            <table border = "1">
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Dob</th>
                    <th>Tuition Fee</th>
                    <th>Class</th>
                    <th>Xoa</th>
                    <th>Edit</th>
                </tr>
                <c:forEach items="${sinhViens}" var="sv">
                    <tr>
                        <td>${sv.id}</td>
                        <td>${sv.name}</td>
                        <td><fmt:formatDate value="${sv.dob}" pattern="dd-MM-yyyy"/></td>
                        <td>
                            <fmt:formatNumber value="${sv.tuition}" type="currency"/>
                        </td>
                        <td>${sv.clazz}</td>
                        <td>
                            <a href="students/delete?id=${sv.id}">Xoa</a>
                        </td>
                        <td>
                            <a href="students/chuanbiedit?id=${sv.id}">Edit</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
    </body>
</html>
