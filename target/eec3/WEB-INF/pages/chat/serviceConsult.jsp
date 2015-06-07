<%--
  Created by IntelliJ IDEA.
  User: haitao
  Date: 2015/3/7
  Time: 19:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <link href="../css/serviceConsult.css" rel="stylesheet">

    <%
        String sessionId = (String)request.getAttribute("sessionId");
        System.out.println("sessionId="+sessionId);
    %>
    <script language="javascript">
        //设置禁用浏览器缓存
        $.ajaxSetup({cache:false})
    </script>
</head>
<%--<body onload="start()">--%>
<body onload="start(<%=sessionId%>)">
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
    <div class="row">
        <div class="col-md-9">
            <div class="row panel-left-up">
                <div class="col-md-12">
                    <div contentEditable="true" class="left-up-text" id="chatContent">

                    </div>
                    <%--<textarea class="left-up-text" id="chatContent">--%>

                    <%--</textarea>--%>
                </div>
            </div>
            <div class="row panel-split-line">

            </div>
            <div class="row panel-left-down">
                <div class="col-md-12">
                    <textarea class="left-down-text" id="sendContent"
                              onkeydown="if(event.keyCode == 13){sendServer();}">

                    </textarea>
                    <%--<div contentEditable="true" class="left-down-text" id="sendContent"--%>
                         <%--onkeydown="if(event.keyCode == 13){sendServer();}">--%>

                    <%--</div>--%>
                </div>
            </div>
            <div class="row panel-left-function">
                <div class="col-md-9 col-sm-8 col-xs-4 col-lg-9">
                    <div class="panel-left-btnArea2">

                    </div>
                </div>
                <div class="col-md-3 col-sm-4 col-xs-8 col-lg-3">
                    <div class=" panel-left-btnArea">
                        <div class=" panel-footer">
                            <button id="finish" type="button" class="btn btn-default ">结束对话</button>
                            <button id="send" onclick="sendServer()" type="button" class="btn btn-primary send-btn-location">发送</button>
                        </div>
                    </div>
                </div>
            </div>
        </div><!--/.col-left-->
        <div class="col-md-3 panel-right">
            <%--<div class="col-md-12">--%>
                <div class="panel-right-area ">
                    <span class="panel-right-title">近期热点问题</span>
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
<script src="../js/serviceConsult.js"></script>
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
<script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
<script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
</body>
</html>
