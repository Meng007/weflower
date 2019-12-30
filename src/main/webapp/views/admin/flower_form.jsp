<%--
  Created by IntelliJ IDEA.
  User: 13557
  Date: 2019/12/27
  Time: 13:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sys" tagdir="/WEB-INF/tags/sys" %>
<html>
<head>
    <title>我的商城 | 内容管理</title>
    <jsp:include page="includes/header.jsp" />
    <link rel="stylesheet" href="/static/assets/plugins/jquery-ztree/css/zTreeStyle/zTreeStyle.min.css" />
    <link rel="stylesheet" href="/static/assets/plugins/dropzone/dropzone.css" />
    <link rel="stylesheet" href="/static/assets/plugins/dropzone/min/basic.min.css" />
    <link rel="stylesheet" href="/static/assets/plugins/wangEditor/wangEditor.min.css" />
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <jsp:include page="includes/nav.jsp" />
    <jsp:include page="includes/menu.jsp" />

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                花卉管理
                <small></small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li class="active">控制面板</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <c:if test="${baseResult != null}">
                        <div class="alert alert-${baseResult.status == 200 ? "success" : "danger"} alert-dismissible">
                            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                                ${baseResult.message}
                        </div>
                    </c:if>

                    <div class="box box-info">
                        <div class="box-header with-border">
                            <h3 class="box-title">${flower.fid == null ? "新增" : "编辑"}内容</h3>
                        </div>
                        <!-- /.box-header -->
                        <!-- form start -->
                        <form id="inputForm" class="form-horizontal" action="/flower/info" method="post" modelAttribute="tbContent">
                            <div class="box-body">
                               <%-- <div class="form-group">
                                    <label class="col-sm-2 control-label">父级类目</label>

                                    <div class="col-sm-10">
                                        <form:hidden id="categoryId" path="tbContentCategory.id" />
                                        <input id="categoryName" class="form-control required" placeholder="请选择" readonly="true" data-toggle="modal" data-target="#modal-default" value="${tbContent.tbContentCategory.name}" />
                                    </div>
                                </div>--%>

                                <div class="form-group">
                                    <input type="hidden" name="action" value="${flower ==null ?"add":"edit"}">
                                    <input type="hidden" value="${flower.fid}" name="fid">
                                    <label for="" class="col-sm-2 control-label">标题</label>

                                    <div class="col-sm-10">
                                        <input name="title" value="${flower.title}" class="form-control required" placeholder="标题" />
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="" class="col-sm-2 control-label">价格</label>

                                    <div class="col-sm-10">
                                        <input name="price" value="${flower.price}" class="form-control required" placeholder="价格" />
                                    </div>
                                </div>
                                   <div class="form-group">
                                       <label for="" class="col-sm-2 control-label">状态</label>

                                       <div class="col-sm-10">
                                           <input type="radio" name="bock" value="0" class=" required"  ${flower.bock==0 ? "checked":""}  /> 下架
                                           <input type="radio" name="bock" value="1" class=" required"  ${flower.bock==1 ? "checked":""} ${flower.bock==null ?"checked":""}/> 上架
                                       </div>
                                   </div>

                                <div class="form-group">
                                    <label for="" class="col-sm-2 control-label">花名</label>

                                    <div class="col-sm-10">
                                        <input name="name" value="${flower.name}" class="form-control required" placeholder="花名" />
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="" class="col-sm-2 control-label">数量</label>

                                    <div class="col-sm-10">
                                        <input name="num" value="${flower.num}" class="form-control" placeholder="库存数量" />
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="" class="col-sm-2 control-label">图片</label>

                                    <div class="col-sm-10">
                                        <input name="pic" value="${flower.pic}" class="form-control" placeholder="图片" id="pic" />
                                        <div id="dropz" class="dropzone"></div>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-sm-2 control-label">详情</label>

                                    <div class="col-sm-10">
                                        <input type="hidden"  name="content" />
                                        <div id="editor"></div>
                                    </div>
                                </div>
                            </div>

                            <div class="box-footer">
                                <button type="button" class="btn btn-default" onclick="history.go(-1);">返回</button>
                                <button id="btnSubmit" type="submit" class="btn btn-info pull-right">提交</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </section>
    </div>

    <jsp:include page="includes/copyright.jsp" />
</div>

<jsp:include page="includes/footer.jsp" />
<script src="/static/assets/plugins/jquery-ztree/js/jquery.ztree.core-3.5.min.js"></script>
<script src="/static/assets/plugins/dropzone/min/dropzone.min.js"></script>
<script src="/static/assets/plugins/wangEditor/wangEditor.min.js"></script>

<!-- 自定义模态框 -->
<sys:modal title="请选择" message="<ul id='myTree' class='ztree'></ul>" />

<script>
    $(function () {
       /* App.initZTree("/content/category/tree/data", ["id"], function (nodes) {
            var node = nodes[0];
            $("#categoryId").val(node.id);
            $("#categoryName").val(node.name);
            $("#modal-default").modal("hide");
        });*/

        initWangEditor();
    });

    /**
     * 初始化富文本编辑器
     */
    function initWangEditor () {
        var E = window.wangEditor;
        var editor = new E('#editor');
        // 配置服务器端地址
        editor.customConfig.uploadImgServer = '/upload';
        editor.customConfig.uploadFileName = 'editorFiles';
        editor.create();

        $("#btnSubmit").bind("click", function() {
            var contentHtml = editor.txt.html();
            $("#content").val(contentHtml);
        });
    }

    App.initDropzone({
        id: "#dropz",
        url: "/image/upload",
        init: function () {
            this.on("success", function (file, data) {
                var data = JSON.parse(data);
                console.log(data.img)
                $("#pic").val(data.img);
            });
        }
    });

   /* App.initDropzone({
        id: "#dropz2",
        url: "/upload",
        init: function () {
            this.on("success", function (file, data) {
                $("#pic2").val(data.fileName);
            });
        }
    });*/

</script>
</body>

