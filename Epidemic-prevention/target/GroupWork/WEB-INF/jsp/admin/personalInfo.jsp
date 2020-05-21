<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet"
          href="${ctx}/layui/css/layui.css">
    <script>
        var ctx = "${ctx}";
    </script>
</head>
<body>
<div class="layui-card-header">个人信息</div>
<div class="layui-card-body" pad15="">
    <form class="layui-form">
        <!--隐藏参数-->
        <input type="hidden" name="adminId" value="${admin.adminId}"/>
        <div class="layui-form-item">
            <label class="layui-form-label">用户名</label>
            <div class="layui-input-inline">
                <input type="text" class="layui-input" name="username"
                       value="${admin.username}" disabled="disabled">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">昵称</label>
            <div class="layui-input-inline">
                <input type="text" class="layui-input" name="nickname"
                       value="${admin.nickname}" lay-verify="nickname" autocomplete="off"
                placeholder="请输入昵称">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">性别</label>
            <div class="layui-input-block">
                <c:if test="${admin.sex==0}">
                    <input type="radio" name="sex" value="1" title="男">
                    <input type="radio" name="sex" value="0" title="女" checked>
                    <input type="radio" name="sex" value="2" title="保密">
                </c:if>
                <c:if test="${admin.sex==1}">
                    <input type="radio" name="sex" value="1" title="男" checked>
                    <input type="radio" name="sex" value="0" title="女" >
                    <input type="radio" name="sex" value="2" title="保密">
                </c:if>
                <c:if test="${admin.sex==2}">
                    <input type="radio" name="sex" value="1" title="男" >
                    <input type="radio" name="sex" value="0" title="女" >
                    <input type="radio" name="sex" value="2" title="保密" checked>
                </c:if>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">手机</label>
            <div class="layui-input-inline">
                <input type="text" class="layui-input" name="phone"
                       value="${admin.phone}" lay-verify="required|phone" autocomplete="off">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">邮箱</label>
            <div class="layui-input-inline">
                <input type="text" class="layui-input" name="email"
                       value="${admin.email}" lay-verify="required|email" autocomplete="off">
            </div>
        </div>
        <div class="layui-card-header"></div>
        <div class="layui-card-body" pad12="6">
            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button class="layui-btn" lay-submit="" lay-filter="updateAdmin">确认修改</button>
                </div>
            </div>
        </div>
    </form>
</div>
<script type="text/javascript" src="${ctx }/layui/layui.js"></script>
<script type="text/javascript" src="${ctx }/js/admin/updateAdmin.js"></script>
<script type="text/javascript" src="${ctx }/js/pubilc.js"></script>
</body>
</html>