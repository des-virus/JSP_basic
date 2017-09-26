<%-- 
    Document   : user_info
    Created on : Sep 25, 2017, 11:24:13 AM
    Author     : thuctap02
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="_cdn.jsp"></jsp:include>
        </head>
        <body>
        <jsp:include page="_header.jsp"></jsp:include>
        
        <div class="container">
            <div class="text-center lead">${user} profile</div>
        </div>
        <jsp:include page="_footer.jsp"></jsp:include>
    </body>
</html>
