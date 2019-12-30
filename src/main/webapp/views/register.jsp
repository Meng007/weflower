<%--
  Created by IntelliJ IDEA.
  User: 13557
  Date: 2019/12/24
  Time: 12:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.min.css">
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
                                <h1>欢迎注册</h1>
                            </div>
                            <p>用户注册界面</p>
                        </div>
                    </div>
                </div>
                <div class="col-lg-6 bg-white">
                    <form action="${pageContext.request.contextPath}/common/info" method="post">
                        <div class="form d-flex align-items-center">
                            <div class="content">
                                <p style="color: red">${msg}</p>
                                <div class="form-group">
                                    <%--判断后台调用哪个方法--%>
                                    <input type="hidden" name="action"  value="add">
                                    <input id="register-username" class="input-material" type="text" name="username" placeholder="请输入用户名/姓名" >
                                </div>
                                <div class="form-group">
                                    <input id="register-password" class="input-material" type="password" name="password" placeholder="请输入密码"   >
                                </div>
                                <div class="form-group">
                                    <input id="register-passwords" class="input-material" type="password" name="password2" placeholder="确认密码"   >
                                </div>
                                <div class="form-group">
                                    <button id="regbtn" type="submit" name="registerSubmit" class="btn btn-primary">注册</button>
                                </div>
                                <small>已有账号?</small><a href="${pageContext.request.contextPath}/views/login.jsp" class="signup">&nbsp;登录</a>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
