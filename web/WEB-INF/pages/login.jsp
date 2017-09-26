<%-- 
    Document   : login.jsp
    Created on : Sep 25, 2017, 11:13:05 AM
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
            <h3 class="text-center"> Đăng nhập vào Simple App</h3>
            <p class="text-danger"><b>${error_string}</b></p>
            <form method="POST" action="login">
                <div class="form-group">
                    <label for="username">Username</label>
                    <input type="text" class="form-control" id="username" name="username" placeholder="Nhập vào username">
                </div>
                <div class="form-group">
                    <label for="password">Mật khẩu</label>
                    <input type="password" class="form-control" id="username" name="password" placeholder="Nhập vào mật khẩu">
                </div>
                <div class="checkbox">
                    <label>
                        <input type="checkbox" name="remember" value="Y"> Ghi nhớ
                    </label>
                </div>
                <button type="submit" class="btn btn-primary">Đăng nhập</button>
            </form>
        </div>
        <jsp:include page="_footer.jsp"></jsp:include>
    </body>
</html>
