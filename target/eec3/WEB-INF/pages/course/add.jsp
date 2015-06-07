<%--
  Created by IntelliJ IDEA.
  User: 智康
  Date: 2015/2/10 0010
  Time: 12:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="zh-cn">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>添加课程</title>

    <!-- Bootstrap -->
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/custom.css" rel="stylesheet">

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
    <h1>添加一门课程</h1>
    <form:form method="post" action="add" commandName="course" role="form" id="courseForm">
        <div class="form-group courseSolidItem fg1">
            <label for="courseName">课程名：</label>
            <input type="text" class="form-control" id="courseName" name="courseName" placeholder="填写课程名">
        </div>
        <div class="form-group courseSolidItem fg1">
            <label for="courseQihao">课程期号：</label>
            <input type="text" class="form-control" id="courseQihao" name="courseQihao" placeholder="填写课程期号"/>
        </div>
        <div class="form-group courseSolidItem fg1">
            <label for="startTime">开始时间：</label>
            <input type="date" class="form-control" id="startTime" name="startTime" placeholder="填写课程开始时间">
        </div>
        <div class="form-group courseSolidItem fg1">
            <label for="teachCenter">授课中心：</label>
            <input type="text" class="form-control" id="teachCenter" name="teachCenter" placeholder="填写授课中心"/>
        </div>
        <div class="form-group courseSolidItem fg1">
            <label for="address">开课地点：</label>
            <input type="text" class="form-control" id="address" name="address" placeholder="填写开课地点"/>
        </div>
        <div class="form-group courseSolidItem fg1">
            <label for="maxAttend">报名限额：</label>
            <input type="text" class="form-control" id="maxAttend" name="maxAttend" placeholder="填写课程报名人数限额"/>
        </div>
        <div class="form-group courseSolidItem fg1">
            <label for="price">价格：</label>
            <input type="text" class="form-control" id="price" name="price" placeholder="填写课程价格"/>
        </div>
        <div class="form-group courseSolidItem fg1">
            <label for="introduction">课程简介：</label>
            <input type="text"  class="form-control" id="introduction" name="introduction" placeholder="填写课程简介"/>
        </div>
        <div class="form-group courseSolidItem fg1">
            <label for="courseTixi">课程体系：</label>
            <input type="text" class="form-control" id="courseTixi" name="courseTixi" placeholder="填写课程体系"/>
        </div>
        <div class="form-group courseSolidItem fg1">
            <label for="trainFacility">培训设施：</label>
            <input type="text" class="form-control" id="trainFacility" name="trainFacility" placeholder="填写培训设施"/>
        </div>
        <div class="form-group courseSolidItem fg1">
            <label for="trainObject">培养对象：</label>
            <input type="text" class="form-control" id="trainObject" name="trainObject" placeholder="填写培养对象"/>
        </div>

        <div class="form-group courseSolidItem fg1">
            <label for="courseTese1">课程特色1：</label>
            <input type="text" class="form-control" id="courseTese1" placeholder="填写课程特色">
        </div>
        <div class="form-group courseSolidItem fg1">
            <label for="courseTese2">课程特色2：</label>
            <input type="text" class="form-control" id="courseTese2" placeholder="填写课程特色">
        </div>

        <button type="button" class="btn btn-primary" id="addItemBtn">添加课程特色</button>
        <button type="button" class="btn btn-warning" id="delItemBtn">删除课程特色</button>
        <button type="button" class="btn btn-success" id="saveItemBtn">保存</button><br/> <br/>

        <button type="submit" class="btn btn-primary">添加课程</button>
    </form:form>
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
<script src="../js/jquery.backstretch.min.js"></script>
<script src="../js/holder.min.js"></script>
<script src="../js/icheck.min.js"></script>
<script src="../js/addtese.js"></script>
<script type="text/javascript">
    $(function(){
        $('input').iCheck({
            checkboxClass: 'icheckbox_square-blue',
            radioClass: 'iradio_square-blue',
            increaseArea: '20%' // optional
        });

        $(".jumbotron").backstretch("../img/bg-sailing.jpg");
        // $(".jumbotron").backstretch("holder.js/1110x740");
    });
</script>

</body>
</html>


