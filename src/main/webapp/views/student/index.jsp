<%@ page import="com.sdz.flower.pojo.Student" %><%--
  Created by IntelliJ IDEA.
  User: 13557
  Date: 2019/12/24
  Time: 12:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8" />
    <title></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/index.css" />
</head>
<body>
<div id="all">
    <!--heading start-->
    <div id="heading">
        <h1>玉师F4</h1>
        <h2>花之语</h2>
        <span>为你提供最好的服务</span>
        <p>Provide you with the best service</p>

            <div id="login" style="text-align: right">
                <c:if test="${student !=null}">
                    <span style="position: absolute;right: 20px">欢迎：<a href="#" style="color: red;">${student.username}</a></span>
                    <br>
                    <span style="position: absolute;right: 20px;top: 50px;"><a href="/common/info?action=stu" style="color: black;">退出登录</a></span>

                </c:if>
                <c:if test="${student ==null}">
                    <a href="${pageContext.request.contextPath}/views/login.jsp">登录</a>
                    <a href="${pageContext.request.contextPath}/views/register.jsp">注册</a>
                </c:if>

            </div>

    </div>


    <!--occupyNav star-->
    <div id="occupyNav"></div>


    <!--bigPicture-->
    <div id="bigPicture"></div>


    <!--campusSummerFlower star-->
    <div id="campusSummerFlower">
        <h1 align="center" class="xjxyhh">夏季校园花卉</h1>
        <p class="greyLine" id="leftLine"></p>
        <p class="greyLine" id="rightLine"></p>
        <p class="flowerCi">炎炎夏日，凉花易语</p>
        <ul class="flowerImgIntroduction" id="flower_dr">
           <%-- <li><a href=""><img src="/static/img/drmp.jpg" /></a></li>
            <li><a href=""><img src="/static/img/drqkp.jpg" /></a></li>
            <li><a href=""><img src="/static/img/drgzy.jpg" /></a></li>
            <li><a href=""><img src="/static/img/drcp.jpg" /></a></li>--%>
        </ul>
        <ul class="flowerWordIntroduction">
            <li><p class="wordColor1">新品多肉木盒装</p></li>
            <li><p class="wordColor1">新品多肉缺口盆</p></li>
            <li><p class="wordColor1">新品多肉缸之玉</p></li>
            <li><p class="wordColor1">新品多肉白瓷盆</p></li>
        </ul>
        <div id="bigSummerIntroduction">
            <p class="bigImgIntroduction"><img id="dr5" src="/images/2019-12-28-16-40-56_66.jpg" /></p>
            <div class="bigWordIntroduction">
                <div class="BigWIColor">多肉div</div>
                <div class="BigWI">
                    <h1>多肉植物</h1>
                    <p>美丽生活，更加多彩</p>
                </div>
                <!--<input type="button" value="立即购买" class="bigPicButton" />-->
                <a id="a5" href=""><p class="bigPicButton">立即购买></p></a>

            </div>
        </div>

    </div>
    <div style="text-align: left">
        <button type="button" onclick="dr_s()">上一页</button>
        <button type="button" onclick="dr_x()">下一页</button>
    </div>

    <!--campusLRPZFlower star-->
    <div id="campusLRPZFlower">
        <div id="campusLRPZFlowerTop">
            <div class="workBox">
                <p class="verticalLineBorderLeft LRPZborderColor"></p>
                <p class="toptransverseLineBorderLeft LRPZborderColor"></p>
                <p class="bottomtransverseLineBorderLeft LRPZborderColor"></p>
                <p class="verticalLineBorderRight LRPZborderColor"></p>
                <p class="toptransverseLineBorderRight LRPZborderColor"></p>
                <p class="bottomtransverseLineBorderRight LRPZborderColor"></p>
                <h1 class="workBoxTitle">懒人盆栽</h1>
                <p class="workBoxTitleBottomChina">懒人易养，轻松惬意，绿意生活，此刻开始</p>
                <p class="workBoxTitleBottomEnglishOne">Lounger are easy to raise, relaxed</p>
                <p class="workBoxTitleBottomEnglishTwo">and comfortable, green life, from now on</p>
                <img src="/static/img/feather1.png" class="feather" />
                <img src="/static/img/lrFlower.jpg" class="introductionImg" />

            </div>
        </div>
        <div id="campusLRPZFlowerMiddle"></div>
        <div id="campusLRPZFlowerBottom"></div>


        <div id="campusLRPZFlowerShow">
            <div id="bigLRPZIntroduction">
                <p class="bigImgIntroduction1"><img id="flower_pz_img" src="/static/img/lrpzbig.jpg" /></p>
                <div class="bigWordIntroduction1">
                    <div class="BigWIColor">汲水盆</div>
                    <div class="BigWI">
                        <h1>懒人盆栽</h1>
                        <p>清新绿色，温馨生活</p>
                    </div>
                    <p class="bigPicButton"><a id="flower_pz_a" href="">立即购买></a></p>

                </div>
            </div>
            <ol>
                <ul id="flower_pz_1">
                   <%-- <li>
                        <a><img src="img/lrpz1-1.jpg" /></a>
                        <p><font>鸭脚木</font>(绿意盎然正能量)</p>
                        <p class="buy"><span class="buyWord">懒人盆栽</span><span class="buyBuy">立即购买></span></p>
                    </li>
                    <li>
                        <a><img src="img/lrpz1-2.jpg" /></a>
                        <p><font>筋头竹</font>(绿色人生更精彩)</p>
                        <p class="buy"><span class="buyWord">懒人盆栽</span><span class="buyBuy">立即购买></span></p>
                    </li>
                    <li>
                        <a><img src="img/lrpz1-3.jpg" /></a>
                        <p><font>发财树</font>(室内清新绿意情)</p>
                        <p class="buy"><span class="buyWord">懒人盆栽</span><span class="buyBuy">立即购买></span></p>
                    </li>--%>
                </ul>
                <ul id="flower_pz_2">
                   <%-- <li>
                        <a><img src="img/lrpz2-1.jpg" /></a>
                        <p><font>橡皮树</font>(融入自然融入家)</p>
                        <p class="buy"><span class="buyWord">懒人盆栽</span><span class="buyBuy">立即购买></span></p>
                    </li>
                    <li>
                        <a><img src="img/lrpz2-2.jpg" /></a>
                        <p><font>竹柏</font>(清香自然好生活)</p>
                        <p class="buy"><span class="buyWord">懒人盆栽</span><span class="buyBuy">立即购买></span></p>
                    <li>
                        <a><img src="img/lrpz2-3.jpg" /></a>
                        <p><font>吊   兰</font>(美好生活享生态)</p>
                        <p class="buy"><span class="buyWord">懒人盆栽</span><span class="buyBuy">立即购买></span></p>
                    </li>--%>
                </ul>
                <ul id="flower_pz_3">
                    <%--<li>
                        <a><img src="img/lrpz3-1.jpg" /></a>
                        <p><font>豆瓣绿</font>(健康生活更开心)</p>
                        <p class="buy"><span class="buyWord">懒人盆栽</span><span class="buyBuy">立即购买></span></p>
                    </li>
                    <li>
                        <a><img src="img/lrpz3-2.jpg" /></a>
                        <p><font>金砖</font>(给心灵一份自然)</p>
                        <p class="buy"><span class="buyWord">懒人盆栽</span><span class="buyBuy">立即购买></span></p>
                    </li>
                    <li>
                        <a><img src="img/lrpz3-3.jpg" /></a>
                        <p><font>柠檬树</font>(自然气息伴早起)</p>
                        <p class="buy"><span class="buyWord">懒人盆栽</span><span class="buyBuy">立即购买></span></p>
                    </li>--%>
                </ul>
            </ol>
        </div>
        <img src="/static/img/pointLrpic1.png" class="pointPic" />
    </div>
    <div style="text-align: left">
        <button type="button" onclick="pz_s()">上一页</button>
        <button type="button" onclick="pz_x()">下一页</button>
    </div>

    <!--campusHHPJFlower star-->
    <div id="campusHHPJFlower">
        <div id="campusHHPJFlowerTop">
            <div class="workBox">
                <p class="verticalLineBorderLeft HHPJborderColor"></p>
                <p class="toptransverseLineBorderLeft HHPJborderColor"></p>
                <p class="bottomtransverseLineBorderLeft HHPJborderColor"></p>
                <p class="verticalLineBorderRight HHPJborderColor"></p>
                <p class="toptransverseLineBorderRight HHPJborderColor"></p>
                <p class="bottomtransverseLineBorderRight HHPJborderColor"></p>
                <h1 class="workBoxTitle">花卉盆景</h1>
                <p class="workBoxTitleBottomChina2">姹紫嫣红，婀娜多姿，花卉奇栽，乐享生活</p>
                <p class="workBoxTitleBottomEnglishOne2">Colorful, graceful, strangely planted flowers, enjoy life</p>
                <p class="workBoxTitleBottomEnglishTwo2"></p>
                <img src="/static/img/feather2.png" class="feather" />
                <img src="/static/img/lrFlower.jpg" class="introductionImg" />

            </div>
        </div>
        <div id="campusHHPJFlowerMiddle"></div>


        <div id="campusHHPJFlowerShow">
            <div id="bigHHPJIntroduction">
                <p class="bigImgIntroduction1"><img id="flower_pj_img" src="img/hhpjbig.png" /></p>
                <div class="bigWordIntroduction2">
                    <div class="BigWIColor">水培粉掌</div>
                    <div class="BigWI">
                        <h1>花卉盆景</h1>
                        <p>温和的舒适花<br />创造更好的生活</p>
                    </div>
                    <p class="bigPicButton"><a id="flower_pj_a" href="">立即购买></a></p>
                </div>
            </div>
            <ol>
                <ul id="flower_pj_1">
                   <%-- <li>
                        <a><img src="img/hhpj1-1.jpg" /></a>
                        <p><font>红枫</font>(福寿吉祥送祝愿)</p>
                        <p class="buy buyHHPJ"><span class="buyWord buyWordHHPJ">花卉盆景</span><span class="buyBuy buyBuyHHPJ">立即购买></span></p>
                    </li>
                    <li>
                        <a><img src="img/hhpj1-2.jpg" /></a>
                        <p><font>百子莲</font>(苍雅古朴之妙品)</p>
                        <p class="buy buyHHPJ"><span class="buyWord buyWordHHPJ">花卉盆景</span><span class="buyBuy buyBuyHHPJ">立即购买></span></p>
                    </li>
                    <li>
                        <a><img src="img/hhpj1-3.jpg" /></a>
                        <p><font>粉红玫瑰</font>(爱的喜悦更温馨)</p>
                        <p class="buy buyHHPJ"><span class="buyWord buyWordHHPJ">花卉盆景</span><span class="buyBuy buyBuyHHPJ">立即购买></span></p>
                    </li>--%>
                </ul>
                <ul id="flower_pj_2">
                    <%--<li>
                        <a><img src="img/hhpj2-1.jpg" /></a>
                        <p><font>小仓兰</font>(兰中皇后之美誉)</p>
                        <p class="buy buyHHPJ"><span class="buyWord buyWordHHPJ">花卉盆景</span><span class="buyBuy buyBuyHHPJ">立即购买></span></p>
                    </li>
                    <li>
                        <a><img src="img/hhpj2-2.jpg" /></a>
                        <p><font>朱顶红</font>(大展宏图更热情)</p>
                        <p class="buy buyHHPJ"><span class="buyWord buyWordHHPJ">花卉盆景</span><span class="buyBuy buyBuyHHPJ">立即购买></span></p>
                    <li>
                        <a><img src="img/hhpj2-3.jpg" /></a>
                        <p><font>蓝色妖姬</font>(清纯的爱蓝色梦)</p>
                        <p class="buy buyHHPJ"><span class="buyWord buyWordHHPJ">花卉盆景</span><span class="buyBuy buyBuyHHPJ">立即购买></span></p>
                    </li>--%>
                </ul>
            </ol>
        </div>
        <img src="/static/img/pointLrpic2.png" class="pointPic" />
    </div>

    <div style="text-align: left">
        <button type="button" onclick="pj_s()">上一页</button>
        <button type="button" onclick="pj_x()">下一页</button>
    </div>
    <!--campusSZLPFlower star-->
    <div id="campusSZLPFlower">
        <div id="campusSZLPFlowerTop">
            <div class="workBox">
                <p class="verticalLineBorderLeft HHPJborderColor"></p>
                <p class="toptransverseLineBorderLeft HHPJborderColor"></p>
                <p class="bottomtransverseLineBorderLeft HHPJborderColor"></p>
                <p class="verticalLineBorderRight HHPJborderColor"></p>
                <p class="toptransverseLineBorderRight HHPJborderColor"></p>
                <p class="bottomtransverseLineBorderRight HHPJborderColor"></p>
                <h1 class="workBoxTitle">水植绿培</h1>
                <p class="workBoxTitleBottomChina2">四季依旧，水植常青，赏心悦目，健康常伴</p>
                <p class="workBoxTitleBottomEnglishOne2"></p>
                <p class="workBoxTitleBottomEnglishTwo2"></p>
                <img src="/static/img/feather3.png" class="feather" />
                <img src="/static/img/lrFlower.jpg" class="introductionImg" />

            </div>
        </div>
        <div id="campusSZLPFlowerMiddle"></div>
        <div id="campusSZLPFlowerShow">
            <div id="bigSZLPIntroduction">
                <p class="bigImgIntroduction1"><img id="flower_sp_img" src="img/lzspbig.png" /></p>
                <div class="bigWordIntroduction3">
                    <div class="BigWIColor">水培粉掌</div>
                    <div class="BigWI">
                        <h1>玻璃盆</h1>
                        <p>无土栽培<br />环境更清洁</p>
                    </div>
                    <p class="bigPicButton"><a id="flower_sp_a" href="">立即购买></a></p>
                </div>
            </div>
            <ol>
                <ul id="flower_sp">
                   <%-- <li >
                        <a><img src="img/lzsp1-1.png" /></a>
                        <p><font>红掌</font>(绿色生活一点红)</p>
                        <p class="buySZLP"><span class="buyWord buyWordSZLP">水植绿培</span><span class="buyBuy buyBuySZLP">立即购买></span></p>
                    </li>
                    <li>
                        <a><img src="img/lzsp1-2.png" /></a>
                        <p><font>节节高</font>(赏心悦目馨体验)</p>
                        <p class="buySZLP"><span class="buyWord buyWordSZLP">水植绿培</span><span class="buyBuy buyBuySZLP">立即购买></span></p>
                    </li>
                    <li>
                        <a><img src="img/lzsp1-3.png" /></a>
                        <p><font>高贵竹</font>(清香起伴绿意栖)</p>
                        <p class="buySZLP"><span class="buyWord buyWordSZLP">水植绿培</span><span class="buyBuy buyBuySZLP">立即购买></span></p>
                    </li>--%>
                </ul>
            </ol>
        </div>
        <img src="/static/img/pointLrpic3.png" class="pointPic" />
    </div>
    <div style="text-align: left">
        <button type="button" onclick="sp_s()">上一页</button>
        <button type="button" onclick="sp_x()">下一页</button>
    </div>
    <!--bottom start-->
    <div id="bottom">
        <div id="bottomPicture"></div>
        <div id="bottomRemain">
            <hr />
            <p>Copyright © 2019-2020 玉林师范学院 All Rights Reserved   (V9.3.4 HongYe Team)</p>
        </div>
    </div>
</div>

<!--nav start-->
<div id="nav">
    <ul>
        <a href="index.html" class="li_two" id="homePage"><li>首页</li></a>
        <a href="html/drzw.html" target="_blank" class="li_four"><li>多肉植物</li></a>
        <a href="html/pzhh.html" target="_blank" class="li_four"><li>盆栽花卉</li></a>
        <a href="html/FlowerPoem.html" target="_blank" class="li_two"><li>花诗</li></a>
    </ul>
</div>
<script type="text/javascript" src="/static/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="/static/js/flower.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        dr();
        pz();
        pj();
        sp()
    })

    function dr_s() {
        var page = data1.page;
        if (page>1){
            data1.page=page-1;
            dr();
        }else {
            alert("已经是第一页了")
        }
    }
    function dr_x() {
        var page = data1.page;

        if (page<20){
            data1.page=page+1;
            dr();
        }else {
            alert("已经是最后一页了")
        }

    }
    function pz_s() {
        var page = data2.page;
        if (page>1){
            data2.page=page-1;
            pz();
        }else {
            alert("已经是第一页了")
        }
    }
    function pz_x() {
        var page = data2.page;
        alert(page)
        if (page<20){
            data2.page=page+1;
            pz();
        }else {
            alert("已经是最后一页了")
        }

    }

    function pj_s() {
        var page = data3.page;
        if (page>1){
            data3.page=page-1;
            pj();
        }else {
            alert("已经是第一页了")
        }
    }
    function pj_x() {
        var page = data3.page;

        if (page<20){
            data3.page=page+1;
            pj();
        }else {
            alert("已经是最后一页了")
        }

    }
    function sp_s() {
        var page = data4.page;
        if (page>1){
            data4.page=page-1;
            sp();
        }else {
            alert("已经是第一页了")
        }
    }
    function sp_x() {
        var page = data4.page;

        if (page<20){
            data4.page=page+1;
            sp();
        }else {
            alert("已经是最后一页了")
        }

    }
</script>
</body>
</html>
