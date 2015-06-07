<%--
  Created by IntelliJ IDEA.
  User: haitao
  Date: 2015/3/7
  Time: 19:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<% @ OutputCache Location = " None ";VaryByParam = " None "   %>--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>在线咨询</title>
    <!-- Bootstrap -->
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/custom.css" rel="stylesheet">
    <link href="../css/icheck-squareblue.css" rel="stylesheet">
    <link href="../css/consultManager.css" rel="stylesheet">

    <script language="javascript">
        //设置禁用浏览器缓存
        $.ajaxSetup({cache:false})
    </script>
</head>
<body onload="start()">
<%--<body >--%>
<nav class="navbar navbar-default" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapse" data-toggle="collapse" data-target="#navbarCollapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/"><img alt="Brand" class="img-responsive" max-width="100%" src="../img/logo.png"></a>
        </div>

        <div class="collapse navbar-collapse" id="navbarCollapse">
            <ul class="nav navbar-nav">
                <li><a href="/">在线客服</a></li>
                <%--<li><a href="/course">课程管理</a> </li>--%>
                <%--<li><a href="#">用户管理</a></li>--%>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#">已登录</a></li>
            </ul>
        </div>
    </div>
</nav>
<div class="container-fluid container-margin-top">
    <div class="row ">
        <div class="col-md-8 ">
            <%--<div class="col-xs-12 col-sm-9 ">--%>
                <%--<div class="col-md-12 ">--%>
                    <div class="panel panel-default" >
                        <div class="panel-heading">在线客户列表</div>
                        <table class="table table-bordered table-hover" id="onlineUser">
                            <%--<tr class="table_row">--%>
                                <%--<td >"在线客户URL"</td>--%>
                            <%--</tr>--%>
                        </table>
                    </div>
                <%--</div>--%>
            <%--</div><!--/span-->--%>
        </div><!--/.col-left-->
        <div class="col-md-4 panel-right">
            <%--<div class="col-md-12">--%>
                <div class="panel-right-area ">
                    <span class="panel-right-title">最新客户动态</span>
                </div>
            <%--</div>--%>
        </div><!--/.col-right-->
    </div><!--/.row-->
</div><!--/.container-->

<%--<footer>--%>
<%--<div class="container container-margin-top">--%>
<%--<p class="text-center">上海图元软件技术有限公司</p>--%>
<%--<p class="text-center">Copyright © 2015 All rights reserved.</p>--%>
<%--</div>--%>
<%--</footer>--%>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="../js/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="../js/bootstrap.min.js"></script>
<script src="../js/consultManager.js"></script>
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
<script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
<script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
</body>
</html>
