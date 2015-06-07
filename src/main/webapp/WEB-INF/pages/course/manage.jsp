<%--
  Created by IntelliJ IDEA.
  User: 智康
  Date: 2015/2/10 0010
  Time: 11:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="zh-cn">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>课程管理</title>

    <!-- Bootstrap -->
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/custom.css" rel="stylesheet">
    <link href="../css/icheck-squareblue.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
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
            <a class="navbar-brand" href="/"><img alt="Brand" class="img-responsive" max-width="100%" src="../img/logo.png"></a>
        </div>

        <div class="collapse navbar-collapse" id="navbarCollapse">
            <ul class="nav navbar-nav">
                <li><a href="/">首页</a></li>
                <li><a href="/course">课程管理</a> </li>
                <li><a href="#">用户管理</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#">欢迎您，admin</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container">
    <h1>课程列表</h1>
    <nav class="navbar">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbarCourse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
            </div>
            <div class="collapse navbar-collapse" id="navbarCourse">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="/course">全部 <span class="sr-only">(current)</span></a></li>
                    <li><a href="#">已发布</a> </li>
                    <li><a href="#">未发布</a> </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">课程类目<span class="caret"></span></a>
                        <ul class="dropdown-menu" role="menu">
                            <li><a href="#">FPGA</a></li>
                            <li><a href="#">SOC</a></li>
                            <li><a href="#">嵌入式</a></li>
                        </ul>
                    </li>
                </ul>
                <form class="navbar-form navbar-left" role="search">
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="搜索课程">
                    </div>
                    <button type="submit" class="btn btn-primary">搜索</button>
                </form>

                <a href="/course/add" type="button" class="btn btn-success navbar-right">添加课程</a>
            </div>
        </div>
    </nav>

    <div class="container">
        <div>
            <a href="/course/add2" type="button" class="btn btn-info">添加课程测试</a>
        </div>
        <c:if test="${!empty courses}">
            <table class="table table-bordered table-striped">
                <thead>
                <tr>
                    <th>课程名</th>
                    <th>类目</th>
                    <th>期号</th>
                    <th>发布状态</th>
                    <th>开始时间</th>
                    <th>授课地点</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${courses}" var="course">
                    <tr>
                        <td><a href="${course.courseId}">${course.courseName}</a></td>
                        <td> ${course.courseCat}</td>
                        <td>${course.courseQihao}</td>
                        <c:if test="${course.isPublished}">
                            <td>已发布</td>
                        </c:if>
                        <c:if test="${course.isPublished==false}">
                            <td>未发布</td>
                        </c:if>
                        <td>${course.startTime}</td>
                        <td>${course.teachCenter}-${course.address}</td>
                        <td>
                            <a href="course/update/${course.courseId}" type="button" class="btn btn-primary">编辑</a>
                            <a href="course/delete/${course.courseId}" type="button" class="btn btn-warning">删除</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:if>
    </div>
</div>








<footer>
    <hr/>
    <div class="container">
        <p class="text-center">上海图元软件技术有限公司</p>
        <p class="text-center">Copyright © 2015 All rights reserved.</p>
    </div>
</footer>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="../js/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="../js/bootstrap.min.js"></script>
</body>
</html>

