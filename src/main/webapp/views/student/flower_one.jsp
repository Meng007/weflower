<%--
  Created by IntelliJ IDEA.
  User: 13557
  Date: 2019/12/29
  Time: 11:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="utf-8" />
    <title></title>
</head>
<body>
    <c:if test="${msg !=null}">
        <script>
            alert("${msg}")
        </script>
    </c:if>
<div id="bigSummerIntroduction" style="text-align: center">
    <p class="bigImgIntroduction"><img src=" ${flower.pic}" width="350px" height="350px"/></p>
    <div class="bigWordIntroduction">
        <div class="BigWIColor">
            <div class="BigWI">
                <h1>类别:${flower.type}</h1>
                <p>${flower.title}</p>
                <p>花名：${flower.name}</p>
                <p>状态：${flower.bock==1 ? "在库中...":"该商品已下架"}</p>
                <p>库存：${flower.num}</p>
                <p>价格: <span style="color: red">${flower.price}</span></p>
            </div>
            <a href="/order/info?action=shop&fid=${flower.fid}">立即购买</a> &nbsp;&nbsp;
            <a href="/cart/info?action=flower_cart&fid=${flower.fid}">加入购物车</a>
        </div>
    </div>
</body>
</html>
