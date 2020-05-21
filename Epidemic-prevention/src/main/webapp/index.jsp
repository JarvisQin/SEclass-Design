
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--这个就是运行后第一次打开的页面 用作 登录界面 放在了WEB-INF外面-->
<%@ include file="/WEB-INF/page/include/taglib.jsp" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="${ctx}/layui/css/layui.css">
    <link rel="stylesheet" href="${ctx}/css/style.css">
    <script>
        var ctx = "${ctx}";  //因为下面引入的login.js中会用到ctx变量
    </script>
    <title>登录</title>

</head>
<body style="background-image: url(image/bg4.jpg);background-size: 100% 100%;background-attachment: fixed"  >
<div style="text-align: center;margin-top: 70px;font-size:80px;font-family: 'Edwardian Script ITC';">
    <a href="#" style="color:rgba(0 ,0 ,128,1)" >Welcome to Dormitory Management System</a>
</div>

<div class="login-main">
    <header class="layui-elip">宿舍管理系统</header>
    <form class="layui-form" lay-filter="login">
        <div class="layui-input-inline">
            <input id="username" type="text" placeholder="用户名" class="layui-input">
        </div>
        <div class="layui-input-inline">
            <input id="password" type="password" placeholder="密码" class="layui-input">
        </div>
        <div class="layui-input-inline" style="display: flex;">
            <input type="text" id="code" placeholder="验证码" class="layui-input">
            <canvas id="canvas" width="100%" height="35"></canvas>
        </div>
        <div class="layui-input-inline">
            <button id="loginBt" class="layui-btn">登录</button>
        </div>
    </form>

</div>
<script type="text/javascript" src="${ctx }/layui/layui.js"></script>
<script type="text/javascript" src="${ctx }/js/login.js"></script>
<script type="text/javascript" src="${ctx }/js/pubilc.js"></script><!--每个页面都要加入 设置下ajax  涉及到未登录跳转的问题-->
</body>

</html>






