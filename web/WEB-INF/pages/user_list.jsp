<%-- 
    Document   : user_list
    Created on : Oct 3, 2017, 9:43:15 AM
    Author     : thuctap02
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="model.UserAccount"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <jsp:include page="_cdn.jsp"></jsp:include>

        </head>
        <body>
        <jsp:include page="_header.jsp"></jsp:include>

            <div class="container">
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th>STT</th>
                            <th>Tên người dùng</th>
                            <th>Username</th>
                            <th>Password</th>
                            <th>Giới tính</th>
                            <th>Ghi chú</th>
                            <th>Hành động</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${userList}" var="user">
                    <td>${user.id}</td>
                    <td>${user.name}</td>
                    <td>${user.username}</td>
                    <td>${user.password}</td>
                    <td>${user.gender}</td>
                    <td>${user.note}</td>
                    <td>Sua xoa</td>
                </c:forEach>
                </tbody>
            </table>
        </div>

        <jsp:include page="_footer.jsp"></jsp:include>
    </body>
</html>
