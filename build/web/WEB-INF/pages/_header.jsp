<%-- 
    Document   : _header
    Created on : Sep 25, 2017, 5:14:08 AM
    Author     : thuctap02
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
       
        <ul class="nav navbar-nav">
            <li><a class="navbar-brand" href="home">Simple app</a></li>
            <li ><a href="user">Danh sách tài khoản</a></li>
            <li ><a href="product">Danh sách sản phẩm</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="login"><span class="glyphicon glyphicon-user"></span> Đăng nhập</a></li>
            <li><a href="logout"><span class="glyphicon glyphicon-log-in"></span> Đăng xuất</a></li>
        </ul>
    </div>
</nav>

<script>
    $(document).ready(function () {
        $("li a[href='" + window.location.pathname.split('/')[2] + "']").parent().addClass('active');
    });
</script>