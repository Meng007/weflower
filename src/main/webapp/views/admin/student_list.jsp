<%--
  Created by IntelliJ IDEA.
  User: 13557
  Date: 2019/12/25
  Time: 17:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sys" tagdir="/WEB-INF/tags/sys" %>

<html>
<head>
    <title>我的花卉 | 用户管理</title>
    <jsp:include page="includes/header.jsp" />
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
                用户管理
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

                    <div class="box box-info box-info-search" style="display: none;">
                        <div class="box-header">
                            <h3 class="box-title">高级搜索</h3>
                        </div>

                        <div class="box-body">
                            <div class="row form-horizontal">
                                <div class="col-xs-12 col-sm-3">
                                    <div class="form-group">
                                        <label for="username" class="col-sm-4 control-label">姓名</label>

                                        <div class="col-sm-8">
                                            <input id="username" class="form-control" placeholder="姓名" />
                                        </div>
                                    </div>
                                </div>
                                <div class="col-xs-12 col-sm-3">
                                    <div class="form-group">
                                        <label for="email" class="col-sm-4 control-label">邮箱</label>

                                        <div class="col-sm-8">
                                            <input id="email" class="form-control" placeholder="邮箱" />
                                        </div>
                                    </div>
                                </div>
                                <div class="col-xs-12 col-sm-3">
                                    <div class="form-group">
                                        <label for="phone" class="col-sm-4 control-label">手机</label>

                                        <div class="col-sm-8">
                                            <input id="phone" class="form-control" placeholder="手机" />
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="box-footer">
                            <button type="button" class="btn btn-info pull-right" onclick="search();">搜索</button>
                        </div>
                    </div>

                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">用户列表</h3>
                        </div>

                        <div class="box-body">
                            <a href="/page/info?action=student_form" type="button" class="btn btn-sm btn-default"><i class="fa fa-plus"></i> 新增</a>&nbsp;&nbsp;&nbsp;
                            <button type="button" class="btn btn-sm btn-default" onclick="App.deleteMulti('/student/info')"><i class="fa fa-trash-o"></i> 删除</button>&nbsp;&nbsp;&nbsp;
                            <a href="#" type="button" class="btn btn-sm btn-default"><i class="fa fa-download"></i> 导入</a>&nbsp;&nbsp;&nbsp;
                            <a href="#" type="button" class="btn btn-sm btn-default"><i class="fa fa-upload"></i> 导出</a>&nbsp;&nbsp;&nbsp;
                            <button type="button" class="btn btn-sm btn-primary" onclick="$('.box-info-search').css('display') == 'none' ? $('.box-info-search').show('fast') : $('.box-info-search').hide('fast')"><i class="fa fa-search"></i> 搜索</button>
                        </div>

                        <!-- /.box-header -->
                        <div class="box-body table-responsive">
                            <table id="dataTable" class="table table-hover">
                                <thead>
                                <tr>
                                    <th><input type="checkbox" class="minimal icheck_master" /></th>
                                    <th>ID</th>
                                    <th>用户名</th>
                                    <th>手机号</th>
                                    <th>地址</th>
                                    <th>更新时间</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                </tbody>
                            </table>
                        </div>
                        <!-- /.box-body -->
                    </div>
                    <!-- /.box -->
                </div>
            </div>
        </section>
    </div>

    <jsp:include page="includes/copyright.jsp" />
</div>

<jsp:include page="includes/footer.jsp" />

<!-- 自定义模态框 -->
<sys:modal />

<script>
    var _dataTable;

    $(function () {
        var _columns = [
            {
                "data": function (row, type, val, meta) {
                    return '<input id="' + row.sid + '" type="checkbox" class="minimal" />';
                }
            },
            {"data": "sid"},
            {"data": "username"},
            {"data": "phone"},
            {"data": "address"},
            {"data": "updated"},
            {
                "data": function (row, type, val, meta) {
                    var detailUrl = "/user/detail?id=" + row.sid;
                    var deleteUrl = "/student/info";
                    return '<button type="button" class="btn btn-sm btn-default" onclick="App.showDetail(\'' + detailUrl + '\');"><i class="fa fa-search"></i> 查看</button>&nbsp;&nbsp;&nbsp;' +
                        '<a href="/admin/info?action=edit&sid=' + row.sid + '" type="button" class="btn btn-sm btn-primary"><i class="fa fa-edit"></i> 编辑</a>&nbsp;&nbsp;&nbsp;' +
                        '<button type="button" class="btn btn-sm btn-danger" onclick="App.deleteSingle(\'' + deleteUrl + '\', \'' + row.sid + '\')"><i class="fa fa-trash-o"></i> 删除</button>';
                }
            }
        ];

        _dataTable = App.initDataTables("/student/info?action=list", _columns);
    });

    function search() {
        var username = $("#username").val();
        var phone = $("#phone").val();
        var email = $("#email").val();

        var param = {
            "username": username,
            "phone": phone,
            "email": email
        };

        _dataTable.settings()[0].ajax.data = param;
        _dataTable.ajax.reload();
    }
</script>
</body>
</html>
