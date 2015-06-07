<%--
  Created by IntelliJ IDEA.
  User: 智康
  Date: 2015/2/10 0010
  Time: 10:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-cn">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>eecourse 首页</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/custom.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <!--<script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>-->
    <!--<script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>-->
    <![endif]-->
</head>
<%--<body onload="setUserNameCookie()">--%>
<body>
    <nav class="navbar navbar-default" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapse" data-toggle="collapse" data-target="#navbarCollapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="/"><img alt="Brand" class="img-responsive" max-width="100%" src="img/logo.png"></a>
            </div>

            <div class="collapse navbar-collapse" id="navbarCollapse">
                <ul class="nav navbar-nav">
                    <li><a href="/">首页</a></li>
                    <li><a href="/course">课程管理</a> </li>
                    <li><a href="#">用户管理</a></li>
                    <%--<li><a href="/onlineChat">在线咨询</a></li>--%>
                    <!--<li><a href="${pageContext.request.contextPath}/chat">在线咨询</a></li>-->
                    <li><a href="/chatManagerServer">客服管理</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="/loginUser">用户登录</a></li>
                    <li><a href="/loginServer">客服登录</a></li>
                </ul>
            </div>
        </div>
    </nav>

    <a class="btn btn-default" href="/onlineChat/xian" role="button">西安</a>
    <a class="btn btn-default" href="/onlineChat/shanghai" role="button">上海</a>
    <a class="btn btn-default" href="/onlineChat/beijing" role="button">北京</a>
    <%--<a class="btn btn-default" href="/DataBaseOperation" role="button">测试</a>--%>
    <h1>&nbsp;</h1>
    <h1>&nbsp;</h1>
    <h1>&nbsp;</h1>
    <h1>&nbsp;</h1>
    <h1>&nbsp;</h1>
    <h1>&nbsp;</h1>



    <footer>
        <hr/>
        <div class="container">
            <p class="text-center">上海图元软件技术有限公司</p>
            <p class="text-center">Copyright © 2015 All rights reserved.</p>
        </div>
    </footer>

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="js/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
    <script src="js/test.js"></script>
    </body>
</html>
