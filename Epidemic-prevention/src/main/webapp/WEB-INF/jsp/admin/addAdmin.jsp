<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>添加管理员</title>
    <link rel="stylesheet" href="${ctx }/layui/css/layui.css" media="all" />
    <script>
        <%-- js全局变量  js文件中都可以直接应用这个变量--%>
        var ctx="${ctx}";
    </script>
    <script type="text/css">
        .layui-form-item .layui-inline {
            width: 33.333%;
            float: left;
            margin-right: 0;
        }

        @media ( max-width :1240px) {
            .layui-form-item .layui-inline {
                width: 100%;
                float: none;
            }
        }
    </script>
</head>
<body class="childrenBody">
<form class="layui-form" style="width: 80%;" id="aaf">
    <div class="layui-form-item">
        <label class="layui-form-label">用户名</label>
        <div class="layui-input-block">
            <input type="text" id="username" class="layui-input userName"
                   lay-verify="required" placeholder="请输入用户名" name="username" value="">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">密码</label>
        <div class="layui-input-block">
            <input type="password" id="password" class="layui-input userName"
                   lay-verify="pass" placeholder="请输入密码" name="password" value="">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">确认密码</label>
        <div class="layui-input-block">
            <input type="password"  class="layui-input userName"
                   lay-verify="repass" placeholder="请再次输入密码"  value="">
        </div>
    </div>
    <!--上面的lay-verify 值 pass repass在layui.all中都有定义 可以看看具体验证的格式 如几位密码 之类-->
    <div class="layui-form-item">
        <label class="layui-form-label">昵称</label>
        <div class="layui-input-block">
            <input type="text" id="nickname" class="layui-input userName"
                   lay-verify="required" placeholder="请输入昵称" name="nickname" value="">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">邮箱</label>
        <div class="layui-input-block">
            <input type="text" id="email" class="layui-input userName"
                   lay-verify="email" placeholder="请输入邮箱" name="email" value="">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">性别</label>
        <div class="layui-input-block">
            <input type="radio" name="sex" value="1" title="男" checked>
            <input type="radio" name="sex" value="0" title="女">
            <input type="radio" name="sex" value="2" title="保密">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">手机号</label>
        <div class="layui-input-block">
            <input type="text" id="phone" class="layui-input userName"
                   lay-verify="phone" placeholder="请输入手机号" name="phone" value="">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">分配角色</label>
        <div class="layui-input-block">
            <select name="roleId">
                <option value="">请选择</option>
                <c:forEach items="${roles}" var="r">
                    <option value="${r.roleId}">${r.roleName}</option>
                </c:forEach>
            </select>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit="" lay-filter="addAdmin">立即提交</button>
        </div>
    </div>
</form>
<script type="text/javascript" src="${ctx }/layui/layui.js"></script>
<script type="text/javascript" src="${ctx }/js/admin/addAdmin.js"></script>
<script type="text/javascript" src="${ctx }/js/pubilc.js"></script>
</body>