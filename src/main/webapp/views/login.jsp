<%--
  Created by IntelliJ IDEA.
  User: 13557
  Date: 2019/12/24
  Time: 12:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
    <link rel="stylesheet" href="https://ajax.aspnetcdn.com/ajax/bootstrap/4.2.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/style.default.css" id="theme-stylesheet">
</head>
<body>
<div class="page login-page">
    <div class="container d-flex align-items-center">
        <div class="form-holder has-shadow">
            <div class="row">
                <div class="col-lg-6">
                    <div class="info d-flex align-items-center">
                        <div class="content">
                            <div class="logo">
                                <h1>欢迎登录</h1>
                            </div>
                            <p>用户登录界面</p>
                        </div>
                    </div>
                </div>
                <div class="col-lg-6 bg-white">
                    <div class="form d-flex align-items-center">
                        <div class="content">
                            <form method="post" action="${pageContext.request.contextPath}/common/info" class="form-validate" id="loginFrom">
                                <p style="color: red">${msg}</p>
                                <div class="form-group">
                                    <input type="hidden" name="action" value="login">
                                    <input id="login-username" type="text" name="username" required data-msg="请输入用户名" placeholder="用户名" value="admin" class="input-material">
                                </div>
                                <div class="form-group">
                                    <input id="login-password" type="password" name="password" required data-msg="请输入密码" placeholder="密码" class="input-material">
                                </div>
                                <div class="form-group">
                                    <input  type="radio" name="checked" value="student" checked  class=""> 学生
                                    <input  type="radio" name="checked" value="admin"  class=""> 管理员

                                </div>
                                <button id="login" type="submit" class="btn btn-primary">登录</button>
                            </form>
                            <br />
                            <small>没有账号?</small><a href="${pageContext.request.contextPath}/views/register.jsp" class="signup">&nbsp;注册</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
