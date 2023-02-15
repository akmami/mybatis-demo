<%--
  Created by IntelliJ IDEA.
  User: akmami
  Date: 4.02.2023
  Time: 23:08
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>List Employees</h1>
    <button onclick="window.location.href='showFormForAddEmployee.html'">Add Employee</button>
    <div>
        <table border="1">
            <tr>
                <th>Full Name</th>
                <th>Email</th>
                <th>Gender</th>
                <th>Hobbies</th>
                <th>Country</th>
                <th>Address</th>
                <th>Actions</th>
            </tr>

            <c:forEach items="${employees}" var="e">

                <c:url var="deleteLink" value="/deleteEmployee">
                    <c:param name="employeeId" value="${e.id}"/>
                </c:url>

                <c:url var="updateLink" value="/updateEmployee">
                    <c:param name="employeeId" value="${e.id}"/>
                </c:url>

                <tr>
                    <td>${e.fullname}</td>
                    <td>${e.email}</td>
                    <td>${e.gender}</td>
                    <td>${e.hobbies}</td>
                    <td>${e.country}</td>
                    <td>${e.address}</td>
                    <td>
                        <a href="${updateLink}">Update</a> |
                        <a href="${deleteLink}" onclick="if(!(confirm('Are you sure?'))) return false;">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
